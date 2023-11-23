package org.clb.LeetCode.code1_10;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。  nums中数字为-1000~1000
 */
public class Code_560 {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        //key 前i个的和  value 该和的个数
        Map<Integer,Integer> map = new HashMap<>();
        int pre = 0;
        //代表pre=k的时候有一个
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre+=nums[i];
            if (map.containsKey(pre-k)) {// pre-k 代表前面和
                count+= map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                if (sum==k) {
                    count++;
                }
            }
        }
        return count;
    }

}
