package org.clb.LeetCode.code1_10;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class Code_48 {
    public void rotate(int[][] matrix) {
        int start = 0;
        int end = matrix.length - 1;
        while (end>=start) {
            //从 start 到 end-1依次旋转
            for (int i = start; i < end; i++) {
                int temp =matrix[start][i];
                matrix[start][i] = matrix[end-i+start][start];
                matrix[end-i+start][start]=matrix[end][end-i+start];
                matrix[end][end-i+start] =matrix[i][end];
                matrix[i][end] = temp;
            }
            start+=1;
            end-=1;
        }
    }
}
