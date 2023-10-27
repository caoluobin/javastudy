package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ�� m �� n �еľ��� matrix ���밴�� ˳ʱ������˳�� �����ؾ����е�����Ԫ�ء�
 */
public class Code_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int uRow = 0;
        int dRow = matrix.length - 1;
        int lColumn = 0;
        int rColumn = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while (dRow >= uRow && rColumn >= lColumn) {
            //ֻ��һ��
            if (uRow == dRow) {
                for (int i = lColumn; i < rColumn + 1; i++) {
                    res.add(matrix[uRow][i]);
                }
            } else if (lColumn == rColumn) {//ֻ��һ��
                for (int i = uRow; i < dRow + 1; i++) {
                    res.add(matrix[i][lColumn]);
                }
            } else {
                for (int i = lColumn; i < rColumn + 1; i++) {
                    res.add(matrix[uRow][i]);
                }
                for (int i = uRow + 1; i < dRow + 1; i++) {
                    res.add(matrix[i][rColumn]);
                }
                for (int i = rColumn - 1; i >= lColumn; i--) {
                    res.add(matrix[dRow][i]);
                }
                for (int i = dRow - 1; i >= uRow + 1; i--) {
                    res.add(matrix[i][lColumn]);
                }
            }
            uRow += 1;
            lColumn += 1;
            dRow -= 1;
            rColumn -= 1;
        }
        return res;

    }
}
