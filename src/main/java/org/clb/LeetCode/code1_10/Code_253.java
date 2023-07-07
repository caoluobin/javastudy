package org.clb.LeetCode.code1_10;

import java.util.*;

/**
 * 共有 k 位工人计划将 n 个箱子从旧仓库移动到新仓库。给你两个整数 n 和 k，以及一个二维整数数组 time ，数组的大小为 k x 4 ，
 * 其中 time[i] = [leftToRighti, pickOldi, rightToLefti, putNewi] 。
 * 一条河将两座仓库分隔，只能通过一座桥通行。旧仓库位于河的右岸，新仓库在河的左岸。开始时，所有 k 位工人都在桥的左侧等待。为了移动这些箱子，第 i 位工人（下标从 0 开始）可以：
 * 从左岸（新仓库）跨过桥到右岸（旧仓库），用时 leftToRighti 分钟。
 * 从旧仓库选择一个箱子，并返回到桥边，用时 pickOldi 分钟。不同工人可以同时搬起所选的箱子。
 * 从右岸（旧仓库）跨过桥到左岸（新仓库），用时 rightToLefti 分钟。
 * 将箱子放入新仓库，并返回到桥边，用时 putNewi 分钟。不同工人可以同时放下所选的箱子。
 * 如果满足下面任一条件，则认为工人 i 的 效率低于 工人 j ：
 * leftToRighti + rightToLefti > leftToRightj + rightToLeftj
 * leftToRighti + rightToLefti == leftToRightj + rightToLeftj 且 i > j
 * 工人通过桥时需要遵循以下规则：
 * 如果工人 x 到达桥边时，工人 y 正在过桥，那么工人 x 需要在桥边等待。
 * 如果没有正在过桥的工人，那么在桥右边等待的工人可以先过桥。如果同时有多个工人在右边等待，那么 效率最低 的工人会先过桥。
 * 如果没有正在过桥的工人，且桥右边也没有在等待的工人，同时旧仓库还剩下至少一个箱子需要搬运，此时在桥左边的工人可以过桥。如果同时有多个工人在左边等待，那么 效率最低 的工人会先过桥。
 * 所有 n 个盒子都需要放入新仓库，请你返回最后一个搬运箱子的工人 到达河左岸 的时间。
 */
public class Code_253 {
    public static void main(String[] args) {
        Code_253 code253 = new Code_253();
        int[][] time = {{1,1,2,1}, {1,1,2,1},{1,1,4,1}};
        System.out.println(code253.findCrossingTime(1, 3, time));
    }

    public int findCrossingTime(int n, int k, int[][] time) {
        if (n == 0) {
            return 0;
        }
        PriorityQueue<Worker> leftWorkerPriorityQueue = new PriorityQueue<>(new WorkerComparator());
        PriorityQueue<Worker> rightWorkerPriorityQueue = new PriorityQueue<>(new WorkerComparator());
        List<Worker> leftWorkerList = new ArrayList<>();
        List<Worker> rightWorkerList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            leftWorkerPriorityQueue.add(new Worker(time[i][0], time[i][1], time[i][2], time[i][3], i));
        }
        Worker bridgeWorker = leftWorkerPriorityQueue.poll();
        if (n == 1) {
            return bridgeWorker.leftToRight + bridgeWorker.pickOld + bridgeWorker.rightToLeft + bridgeWorker.putNew;
        }
        n--;
        int timeCost = 0;
        while (n > 0&&(!leftWorkerPriorityQueue.isEmpty()||!rightWorkerPriorityQueue.isEmpty())) {
            Worker finalBridgeWorker = bridgeWorker;
            //桥上有人往右走
            if (bridgeWorker.leftToRightSurplus != 0) {
                bridgeWorker.leftToRightSurplus = 0;
                timeCost+= bridgeWorker.leftToRight;
                leftWorkerList.forEach(a -> a.putNew = Math.max(a.putNew - finalBridgeWorker.leftToRight, 0));
                rightWorkerList.forEach(a -> a.pickOld = Math.max(a.pickOld - finalBridgeWorker.leftToRight, 0));
                rightWorkerList.add(bridgeWorker);
            } else if (bridgeWorker.rightToLeftSurplus != 0){//桥上有人往左走
                bridgeWorker.rightToLeftSurplus = 0;
                timeCost+= bridgeWorker.rightToLeft;
                leftWorkerList.forEach(a -> a.putNew = Math.max(a.putNew - finalBridgeWorker.rightToLeft, 0));
                rightWorkerList.forEach(a -> a.pickOld = Math.max(a.pickOld - finalBridgeWorker.rightToLeft, 0));
                leftWorkerList.add(bridgeWorker);
            }
            addSurplusWordToQueue(leftWorkerList, rightWorkerList, leftWorkerPriorityQueue, rightWorkerPriorityQueue);
            //如果右边有人在等
            if (!rightWorkerPriorityQueue.isEmpty()) {
                bridgeWorker = rightWorkerPriorityQueue.poll();
            } else if (!leftWorkerPriorityQueue.isEmpty()&&n>1) {
                bridgeWorker = leftWorkerPriorityQueue.poll();
                n--;
            } else {
                //如果右边没人在等，左边也没人在等，但是还有箱子没搬完
                //获取leftWorkerList中putNew最小的
                Optional<Integer> minLeft = leftWorkerList.stream().map(a -> a.putNew).min(Integer::compareTo);
                Optional<Integer> minRight = rightWorkerList.stream().map(a -> a.pickOld).min(Integer::compareTo);
                //获取minLeft和minRight中最小的
                int min = Math.min(minLeft.get(), minRight.get());
                leftWorkerList.forEach(a -> a.putNew = Math.max(a.putNew - min, 0));
                rightWorkerList.forEach(a -> a.pickOld = Math.max(a.pickOld - min, 0));
                timeCost+=min;
            }

        }

        return timeCost;
    }

    public void addSurplusWordToQueue(List<Worker> leftWorkerList, List<Worker> rightWorkerList, PriorityQueue<Worker> leftWorkerPriorityQueue, PriorityQueue<Worker> rightWorkerPriorityQueue) {
        Iterator<Worker> leftI = leftWorkerList.iterator();
        while (leftI.hasNext()) {
            Worker next = leftI.next();
            if (next.putNew == 0) {
                leftI.remove();
                leftWorkerPriorityQueue.add(next);
            }
        }
        Iterator<Worker> rightI = rightWorkerList.iterator();
        while (rightI.hasNext()) {
            Worker next = rightI.next();
            if (next.pickOld == 0) {
                rightI.remove();
                rightWorkerPriorityQueue.add(next);
            }
        }
    }
    class Worker {
        int leftToRight;
        //剩余
        int leftToRightSurplus;
        int pickOld;
        int rightToLeft;
        int rightToLeftSurplus;
        int putNew;
        int efficiency;
        int index;

        public Worker(int leftToRight, int pickOld, int rightToLeft, int putNew, int index) {
            this.leftToRight = leftToRight;
            this.leftToRightSurplus = leftToRight;
            this.pickOld = pickOld;
            this.rightToLeft = rightToLeft;
            this.rightToLeftSurplus = rightToLeft;
            this.putNew = putNew;
            this.index = index;
            this.efficiency = leftToRight + rightToLeft;
        }

    }

    class WorkerComparator implements Comparator<Worker> {

        @Override
        public int compare(Worker o1, Worker o2) {
            if (o1.efficiency != o2.efficiency) {
                return o1.efficiency - o2.efficiency;
            } else {
                return o1.index - o2.index;
            }
        }
    }
}
