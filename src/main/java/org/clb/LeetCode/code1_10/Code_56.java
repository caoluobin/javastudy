package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class Code_56 {

    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for (int[] interval : intervals) {
            queue.add(interval);
        }
        List<int[]> list = new ArrayList<>();
        int[] last = queue.poll();
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (last[1]>=now[0]) {
                last[1]= Math.max(now[1],last[1]);
            } else {
                list.add(last);
                last=now;
            }
        }
        list.add(last);
        return list.toArray(new int[0][]);
    }
}
