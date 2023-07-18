package org.clb.LeetCode.code1_10;

/**
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 */
public class Code_931 {
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(new Code_931().minFallingPathSum(matrix));
    }
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        Integer[][] dfs = new Integer[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            min = Math.min(min, minFallingPathSum(matrix, dfs,0, i));
        }
        return min;
    }

    /**
     * 返回从第i行第j列开始的最小路径和
     */
    public int minFallingPathSum(int[][] matrix,Integer[][] dfs,int i,int j) {
        if (dfs[i][j]!=null) return dfs[i][j];
        if (i == matrix.length-1) {
            dfs[i][j] = matrix[i][j];
            return matrix[i][j];
        }
        int left = j-1<0?Integer.MAX_VALUE:minFallingPathSum(matrix,dfs,i+1,j-1);
        int right = j+1>=matrix.length?Integer.MAX_VALUE:minFallingPathSum(matrix,dfs,i+1,j+1);
        int mid = minFallingPathSum(matrix,dfs,i+1,j);
        return dfs[i][j] = matrix[i][j] + Math.min(left,Math.min(right,mid));
    }
}
