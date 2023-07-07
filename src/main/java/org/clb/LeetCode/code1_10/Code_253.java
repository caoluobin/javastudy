package org.clb.LeetCode.code1_10;

import java.util.*;

/**
 * ���� k λ���˼ƻ��� n �����ӴӾɲֿ��ƶ����²ֿ⡣������������ n �� k���Լ�һ����ά�������� time ������Ĵ�СΪ k x 4 ��
 * ���� time[i] = [leftToRighti, pickOldi, rightToLefti, putNewi] ��
 * һ���ӽ������ֿ�ָ���ֻ��ͨ��һ����ͨ�С��ɲֿ�λ�ںӵ��Ұ����²ֿ��ںӵ��󰶡���ʼʱ������ k λ���˶����ŵ����ȴ���Ϊ���ƶ���Щ���ӣ��� i λ���ˣ��±�� 0 ��ʼ�����ԣ�
 * ���󰶣��²ֿ⣩����ŵ��Ұ����ɲֿ⣩����ʱ leftToRighti ���ӡ�
 * �Ӿɲֿ�ѡ��һ�����ӣ������ص��űߣ���ʱ pickOldi ���ӡ���ͬ���˿���ͬʱ������ѡ�����ӡ�
 * ���Ұ����ɲֿ⣩����ŵ��󰶣��²ֿ⣩����ʱ rightToLefti ���ӡ�
 * �����ӷ����²ֿ⣬�����ص��űߣ���ʱ putNewi ���ӡ���ͬ���˿���ͬʱ������ѡ�����ӡ�
 * �������������һ����������Ϊ���� i �� Ч�ʵ��� ���� j ��
 * leftToRighti + rightToLefti > leftToRightj + rightToLeftj
 * leftToRighti + rightToLefti == leftToRightj + rightToLeftj �� i > j
 * ����ͨ����ʱ��Ҫ��ѭ���¹���
 * ������� x �����ű�ʱ������ y ���ڹ��ţ���ô���� x ��Ҫ���űߵȴ���
 * ���û�����ڹ��ŵĹ��ˣ���ô�����ұߵȴ��Ĺ��˿����ȹ��š����ͬʱ�ж���������ұߵȴ�����ô Ч����� �Ĺ��˻��ȹ��š�
 * ���û�����ڹ��ŵĹ��ˣ������ұ�Ҳû���ڵȴ��Ĺ��ˣ�ͬʱ�ɲֿ⻹ʣ������һ��������Ҫ���ˣ���ʱ������ߵĹ��˿��Թ��š����ͬʱ�ж����������ߵȴ�����ô Ч����� �Ĺ��˻��ȹ��š�
 * ���� n �����Ӷ���Ҫ�����²ֿ⣬���㷵�����һ���������ӵĹ��� ������� ��ʱ�䡣
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
            //��������������
            if (bridgeWorker.leftToRightSurplus != 0) {
                bridgeWorker.leftToRightSurplus = 0;
                timeCost+= bridgeWorker.leftToRight;
                leftWorkerList.forEach(a -> a.putNew = Math.max(a.putNew - finalBridgeWorker.leftToRight, 0));
                rightWorkerList.forEach(a -> a.pickOld = Math.max(a.pickOld - finalBridgeWorker.leftToRight, 0));
                rightWorkerList.add(bridgeWorker);
            } else if (bridgeWorker.rightToLeftSurplus != 0){//��������������
                bridgeWorker.rightToLeftSurplus = 0;
                timeCost+= bridgeWorker.rightToLeft;
                leftWorkerList.forEach(a -> a.putNew = Math.max(a.putNew - finalBridgeWorker.rightToLeft, 0));
                rightWorkerList.forEach(a -> a.pickOld = Math.max(a.pickOld - finalBridgeWorker.rightToLeft, 0));
                leftWorkerList.add(bridgeWorker);
            }
            addSurplusWordToQueue(leftWorkerList, rightWorkerList, leftWorkerPriorityQueue, rightWorkerPriorityQueue);
            //����ұ������ڵ�
            if (!rightWorkerPriorityQueue.isEmpty()) {
                bridgeWorker = rightWorkerPriorityQueue.poll();
            } else if (!leftWorkerPriorityQueue.isEmpty()&&n>1) {
                bridgeWorker = leftWorkerPriorityQueue.poll();
                n--;
            } else {
                //����ұ�û���ڵȣ����Ҳû���ڵȣ����ǻ�������û����
                //��ȡleftWorkerList��putNew��С��
                Optional<Integer> minLeft = leftWorkerList.stream().map(a -> a.putNew).min(Integer::compareTo);
                Optional<Integer> minRight = rightWorkerList.stream().map(a -> a.pickOld).min(Integer::compareTo);
                //��ȡminLeft��minRight����С��
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
        //ʣ��
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
