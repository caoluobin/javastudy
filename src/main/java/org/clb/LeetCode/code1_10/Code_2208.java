package org.clb.LeetCode.code1_10;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *����һ������������ nums ��ÿһ�β����У�����Դ� nums ��ѡ�� ���� һ������������С�� ǡ�� һ�롣��ע�⣬�ں�������������ԶԼ������������ִ�в�����
 * ���㷵�ؽ� nums ����� ���� ����һ��� ���� ��������
 */
public class Code_2208 {

    public static void main(String[] args) {
        int[] nums = {9,1,4};//4.5 1 4
        System.out.println(new Code_2208().halveArray(nums));

    }
    public int halveArray(int[] nums) {
        PriorityQueue<Double> queue = new PriorityQueue(Comparator.reverseOrder());
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            queue.add((double)nums[i]);
        }
        int res = 0;
        //����
        double remainder = sum/2;
        while (remainder<sum) {
            double poll = queue.poll();
            sum-=poll/2;
            res++;
            queue.add(poll/2);
        }
        return res;
    }

}
