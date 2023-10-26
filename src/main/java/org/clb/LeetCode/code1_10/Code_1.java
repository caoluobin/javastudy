package org.clb.LeetCode.code1_10;

import java.util.HashMap;
import java.util.Map;

public class Code_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int r = target - num;
            if (map.containsKey(r)) {
                return new int[]{map.get(r),i};
            } else {
                map.put(num,i);
            }
        }

        return null;
    }
}
