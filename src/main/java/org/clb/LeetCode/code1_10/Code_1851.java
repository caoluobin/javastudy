package org.clb.LeetCode.code1_10;

import java.util.*;

/**
 * 给你一个二维整数数组 intervals ，其中 intervals[i] = [lefti, righti] 表示第 i 个区间开始于 lefti 、结束于 righti（包含两侧取值，闭区间）。
 * 区间的 长度 定义为区间中包含的整数数目，更正式地表达是 righti - lefti + 1 。
 * 再给你一个整数数组 queries 。第 j 个查询的答案是满足 lefti <= queries[j] <= righti 的 长度最小区间 i 的长度 。如果不存在这样的区间，那么答案是 -1 。
 * 以数组形式返回对应查询的所有答案。
 */
public class Code_1851 {

    public static void main(String[] args) {
        int[][] intervals = {{4 ,5}, {5, 8}, {1, 9}, {8, 10}, {1, 6}};
        int[] queries = {7,9,3,9,3};
        System.out.println(Arrays.toString(minInterval(intervals, queries)));
    }
    public static int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,new intArrayComparator());
        int[] ints = Arrays.copyOf(queries, queries.length);
        Arrays.sort(queries);
        int[] res = new int[queries.length];
        // 0:保存长度 1：保存interval的右边界
        PriorityQueue<int[]> queue = new PriorityQueue<>(new intArrayComparator());
        Map<Integer,Integer> map = new HashMap<>();

        int index = 0;
        for (int i = 0; i < queries.length; i++) {
            while (index<intervals.length&&intervals[index][0]<=queries[i]) {
                queue.add(new int[]{intervals[index][1]-intervals[index][0]+1,intervals[index][1]});
                index++;
            }
            while (!queue.isEmpty()&&queue.peek()[1]<queries[i]) {
                queue.poll();
            }
            if (queue.isEmpty()) {
                map.put(queries[i],-1);
            } else {
                map.put(queries[i],queue.peek()[0]);
            }

        }
        for (int i = 0; i < ints.length; i++) {
            res[i]=map.get(ints[i]);
        }
        return res;
    }
    public static int[] minInterval2(int[][] intervals, int[] queries) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new intArrayComparator());
        PriorityQueue<int[]> queue2 = new PriorityQueue<>(new intArrayComparator());
        PriorityQueue<int[]> queue3 = new PriorityQueue<>(new intArrayComparator());
        PriorityQueue<int[]> workQueue = queue2;
        queue.addAll(Arrays.asList(intervals));
        int[] ints = Arrays.copyOf(queries, queries.length);
        Arrays.sort(queries);
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int min = Integer.MAX_VALUE;
            if (i>0&&queries[i]==queries[i-1]) {
                res[i]=res[i-1];
                continue;
            }
            while (!workQueue.isEmpty()) {
                int[] now = workQueue.poll();
                if (now[0]<=query&&now[1]>=query) {
                    min = Math.min(min,now[1]-now[0]+1);
                    if (workQueue==queue2) {
                        queue3.add(now);
                    } else {
                        queue2.add(now);
                    }
                }
            }
            workQueue = workQueue == queue2 ? queue3 : queue2;
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                if (now[0]<=query&&now[1]>=query) {
                    min = Math.min(min,now[1]-now[0]+1);
                    workQueue.add(now);
                }else if (now[0]>query){
                    queue.add(now);
                    break;
                }
            }
            map.put(query,min==Integer.MAX_VALUE?-1:min);
        }
        for (int i = 0; i < ints.length; i++) {
            res[i]=map.get(ints[i]);
        }
        return res;
    }
    static class intArrayComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] a, int[] b) {
            if (a[0]==b[0]) {
                return a[1]-b[1];
            }
            return a[0]-b[0];
        }
    }
}
