package org.clb.LeetCode.code1_10;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *给你一个正整数数组 nums 。每一次操作中，你可以从 nums 中选择 任意 一个数并将它减小到 恰好 一半。（注意，在后续操作中你可以对减半过的数继续执行操作）
 * 请你返回将 nums 数组和 至少 减少一半的 最少 操作数。
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
        //余数
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
