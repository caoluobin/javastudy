package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ����һ�� m x n �ľ������һ��Ԫ��Ϊ 0 ��
 * ���������к��е�����Ԫ�ض���Ϊ 0 ����ʹ�� ԭ�� �㷨��
 */
public class Code_73 {
    public void setZeroes(int[][] matrix) {
        boolean row = false;
        boolean column = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        row = true;
                    }
                    if (j == 0) {
                        column = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i : matrix[0]) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0]==0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j]=0;
                }
            }
        }
        if (row) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[0][i] =0;
            }
        }
        if (column) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] =0;
            }
        }

    }

    public void setZeroes1(int[][] matrix) {
        Set<Integer> columns = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            boolean flag = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if (flag) {
                    if (matrix[i][j] == 0) {
                        columns.add(j);
                    } else {
                        matrix[i][j] = 0;
                    }
                } else if (matrix[i][j] == 0) {
                    columns.add(j);
                    flag = true;
                    j = -1;
                }
            }
        }
        for (Integer column : columns) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][column] = 0;
            }
        }
    }

    public void setZeroes2(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        for (Integer row : rows) {
            for (int i = 0; i < matrix[row].length; i++) {
                matrix[row][i] = 0;
            }
        }
        for (Integer column : columns) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][column] = 0;
            }
        }
    }
}
