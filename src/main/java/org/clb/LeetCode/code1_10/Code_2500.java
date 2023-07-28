package org.clb.LeetCode.code1_10;

import java.util.Arrays;

public class Code_2500 {
    public int deleteGreatestValue(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] ints = grid[i];
            Arrays.sort(ints);
        }
        int length = grid[0].length;
        for (int i = 0; i < length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max,grid[j][i]);
            }
            res+=max;
        }
        return res;
    }

}
