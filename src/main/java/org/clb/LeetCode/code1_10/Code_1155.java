package org.clb.LeetCode.code1_10;

import java.util.Arrays;

/**
 * ������ n ��һ�������ӣ�ÿ�������϶��� k ���棬�ֱ���Ϊ 1 �� k ��
 * ������������ n ,  k �� target �����ؿ��ܵķ�ʽ(���ܹ� kn �ַ�ʽ��)�������ӵ�������ʹ���泯�ϵ�����֮�͵��� target ��
 * �𰸿��ܴܺ�����Ҫ�� 109 + 7 ȡģ ��
 */
public class Code_1155 {

    public static void main(String[] args) {
        System.out.println(Code_1155.numRollsToTarget2(30, 30, 500));
    }
    private static final int MOD = 1_000_000_007;

    public int numRollsToTarget(int n, int k, int target) {
        if (target < n || target > n * k) {
            return 0; // �޷���� target
        }
        int[][] memo = new int[n + 1][target - n + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1); // -1 ��ʾû�м����
        }
        return dfs(n, target - n, memo, k);
    }

    private int dfs(int i, int j, int[][] memo, int k) {
        if (i == 0) {
            return j == 0 ? 1 : 0;
        }
        if (memo[i][j] != -1) { // ֮ǰ�����
            return memo[i][j];
        }
        int res = 0;
        for (int x = 0; x < k && x <= j; x++) { // ������ x
            res = (res + dfs(i - 1, j - x, memo, k)) % MOD;
        }
        return memo[i][j] = res; // ���仯
    }





    public static int numRollsToTarget2(int n, int k, int target) {
        if (target < n) {
            return 0;
        }
        Integer[][] df = new Integer[n][target];
        return dfs2(n, k, target, df);
    }

    private static int dfs2(int n, int k, int target, Integer[][] df) {
        if (target < n ||target>n*k) {
            return 0;
        }
        if (df[n - 1][target - 1] != null) {
            return df[n - 1][target - 1];
        }

        if (n == 1) {
            if (target <= k) {
                df[n - 1][target - 1] = 1;
                return 1;
            }
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
             res = (res+dfs2(n - 1, k, target - i - 1, df))%MOD;

        }
        return df[n - 1][target - 1] = res;
    }

}
