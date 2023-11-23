package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。
 *其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
 */
public class Code_1726 {


    public int tupleSameProduct(int[] nums) {
        if (nums.length<4) {
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (i!=j) {
                    int m = nums[i]*nums[j];
                    map.compute(m,(a,b)->{
                        if (b==null) {
                            return 1;
                        }
                        return ++b;
                    });
                }
            }
        }
        int count =0 ;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int size = entry.getValue();
            count+= (size-1)*size/2;
        }
        return 8*count;
    }
}
