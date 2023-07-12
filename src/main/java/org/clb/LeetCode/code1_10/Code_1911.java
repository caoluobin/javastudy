package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个下标从 0 开始的数组的 交替和 定义为 偶数 下标处元素之和减去奇数下标处元素之和 。
 * 比方说，数组 [4,2,5,3] 的交替和为 (4 + 5) - (2 + 3) = 4 。
 * 给你一个数组 nums ，请你返回 nums 中任意子序列的 最大交替和 （子序列的下标 重新 从 0 开始编号）。
 * 一个数组的 子序列 是从原数组中删除一些元素后（也可能一个也不删除）剩余元素不改变顺序组成的数组。比方说，[2,7,4] 是 [4,2,3,7,2,1,4] 的一个子序列（加粗元素），但是 [2,4,2] 不是。
 */
public class Code_1911 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,2,1,9,5, 3,1};
        System.out.println(maxAlternatingSum(nums));
    }

    public static long maxAlternatingSum(int[] nums) {
        //l表示偶数下标的最大值
        long l = 0;
        //f表示奇数下标的最大值
        long f = 0;

        for (int i = 0; i < nums.length; i++) {
            l = Math.max(l, f + nums[i]);
            f = Math.max(f, l - nums[i]);
        }
        return Math.max(l, f);
    }

    public static long maxAlternatingSum2(int[] nums) {
        return dfs(nums, new ArrayList<>(), 0);
    }
    public static long dfs(int[] nums, List<Integer> dfs, int index) {
        if (index==nums.length) {
            long sum = 0;
            for (int i = 0; i < dfs.size(); i++) {
                if (i%2==0){
                    sum+=dfs.get(i);
                } else {
                    sum-=dfs.get(i);
                }
            }
            if (dfs.size()%2==0) {
                return sum+nums[index-1];
            }
            return sum;
        }
        long sum = dfs(nums, dfs, index + 1);
        dfs.add(nums[index]);
        long sum1 = dfs(nums, dfs, index + 1);
        dfs.remove(dfs.size()-1);
        return Math.max(sum,sum1);
    }
}
