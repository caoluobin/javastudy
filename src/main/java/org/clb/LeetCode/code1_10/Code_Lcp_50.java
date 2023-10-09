package org.clb.LeetCode.code1_10;

public class Code_Lcp_50 {

    public int giveGem(int[] gem, int[][] operations) {

        for (int[] operation : operations) {
            int x= operation[0];
            int give= gem[x]/2;
            gem[x] =gem[x]-give;
            gem[operation[1]]= gem[operation[1]]+give;
        }
        int max = -1;
        int min =10000;
        for (int i : gem) {
            max = Math.max(max,i);
            min = Math.min(min,i);
        }

        return max-min;
    }
}
