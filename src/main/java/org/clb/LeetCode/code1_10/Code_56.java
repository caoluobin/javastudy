package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * ������ intervals ��ʾ���ɸ�����ļ��ϣ����е�������Ϊ intervals[i] = [starti, endi] ��
 * ����ϲ������ص������䣬������ һ�����ص����������飬��������ǡ�ø��������е��������� ��
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
