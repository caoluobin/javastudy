package org.clb.LeetCode.code1_10;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class Code_240 {
    public static void main(String[] args) {
        Code_240 code = new Code_240();
        //[[1,2,3,4,5],[6,7,8,9,10],[11,12,13,14,15],[16,17,18,19,20],[21,22,23,24,25]]
        int[][] matrix = {{1,2,3,4,5},
                          {6,7,8,9,10},
                          {11,12,13,14,15},
                          {16,17,18,19,20},
                          {21,22,23,24,25}};

        System.out.println(code.searchMatrix(matrix, 15));
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        return searchMatrix(matrix,target,0,matrix.length-1,0,matrix[0].length-1);
    }
    public boolean searchMatrix(int[][] matrix, int target,int rowLeft,int rowRight,int colLeft,int colRight) {
        int m = matrix.length;
        int n = matrix[0].length;
        int sRow = rowLeft;
        int sCol = colLeft;
        int eRow = rowRight;
        int eCol = colRight;
        if (rowLeft == rowRight && colLeft == colRight) {
            return matrix[rowLeft][colLeft] == target;
        }
        if (target < matrix[rowLeft][colLeft] || target > matrix[rowRight][colRight]) return false;
        //二分找出目标所在行列
        while (rowLeft < rowRight || colLeft < colRight) {
            int rowMid = rowLeft + (rowRight - rowLeft) / 2;
            int colMid = colLeft + (colRight - colLeft) / 2;
            if (target > matrix[rowMid][colMid]) {
                if (rowLeft != rowRight) {
                    rowLeft = rowMid + 1;
                }
                if (colLeft != colRight) {

                    colLeft = colMid + 1;
                }
            } else if (target < matrix[rowMid][colMid]) {
                if (rowLeft != rowRight) {
                    rowRight = rowMid - 1;
                }
                if (colLeft != colRight) {
                    colRight = colMid - 1;
                }
            } else {
                return true;
            }
        }
        if (matrix[rowLeft][colLeft] == target) {
            return true;
        } else {
            if (matrix[rowLeft][colLeft] < target) {
                rowLeft =rowRight<m-1? rowLeft + 1:rowLeft;
                colLeft =colRight<n-1? colLeft + 1:colLeft;
            }
            return searchMatrix(matrix, target, Math.max(rowLeft, sRow), eRow, sCol, Math.max(0,Math.min(colLeft - 1,eCol))) //左下
                    || searchMatrix(matrix, target, sRow, Math.max(0,Math.min(rowLeft - 1,eRow)),Math.max(colLeft,sCol) , eCol);//右上
        }
    }
}
