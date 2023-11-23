package org.clb.LeetCode.code1_10;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class Code_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0]=1;
        int[] right = new int[nums.length];
        right[0]=1;
        int leftE = 1;
        int rightE = 1;
        for (int i = 1; i < nums.length; i++) {
            leftE *= nums[i-1];
            left[i]= leftE;
            rightE *= nums[nums.length-i];
            right[i]= rightE;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = left[i]*right[res.length-i-1];
        }
        return res;
    }
}
