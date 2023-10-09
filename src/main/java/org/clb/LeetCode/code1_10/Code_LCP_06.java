package org.clb.LeetCode.code1_10;

import java.util.Arrays;

public class Code_LCP_06 {
    public int minCount(int[] coins) {
        int sum = 0 ;
        for (int i = 0; i < coins.length; i++) {
            sum+=(coins[i]+1)/2;
        }
        return sum;
    }

}
