package org.clb.LeetCode.code1_10;

/**
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
 * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 */
public class Code_918 {

    public static void main(String[] args) {
        System.out.println(new Code_918().maxSubarraySumCircular(new int[]{-3,-2,-3}));
    }

    public int maxSubarraySumCircular(int[] nums) {
        //正数和
        int positiveSum = 0;
        //负数阶段和
        int negativeStageSum = 0;
        int sum = 0;
        int startIndex = 0;
        int index = 0;
        boolean flag = true;
        int max = Integer.MIN_VALUE;
        //最小负数阶段和
        int minNegative = Integer.MAX_VALUE;
        while (index != startIndex || flag) {
            if (nums[index] > 0) {
                positiveSum += nums[index];
                sum += nums[index];
                negativeStageSum = 0;
                max=Math.max(max,sum);
            } else {
                negativeStageSum += nums[index];
                sum += nums[index];
                max=Math.max(max,sum);
                if (Math.abs(negativeStageSum) >positiveSum) {
                    minNegative = Math.min(minNegative, negativeStageSum);
                    startIndex = index + 1;
                    negativeStageSum = 0;
                    positiveSum = 0;
                    sum = 0;
                }
            }

            if (index == nums.length - 1) {
                index = 0;
                flag = false;
            } else {
                index++;
            }

        }
        if (index==startIndex) {
            max = Math.max(max,sum - minNegative);
        }

        return max;

    }
}
