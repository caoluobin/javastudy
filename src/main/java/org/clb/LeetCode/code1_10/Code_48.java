package org.clb.LeetCode.code1_10;

/**
 * ����һ�� n �� n �Ķ�ά���� matrix ��ʾһ��ͼ�����㽫ͼ��˳ʱ����ת 90 �ȡ�
 * ������� ԭ�� ��תͼ������ζ������Ҫֱ���޸�����Ķ�ά�����벻Ҫ ʹ����һ����������תͼ��
 */
public class Code_48 {
    public void rotate(int[][] matrix) {
        int start = 0;
        int end = matrix.length - 1;
        while (end>=start) {
            //�� start �� end-1������ת
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
