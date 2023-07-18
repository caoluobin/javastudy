package org.clb.LeetCode.code1_10;

/**
 * ����һ�� n x n �� ���� �������� matrix �������ҳ�������ͨ�� matrix ���½�·�� �� ��С�� ��
 * �½�·�� ���Դӵ�һ���е��κ�Ԫ�ؿ�ʼ������ÿһ����ѡ��һ��Ԫ�ء�����һ��ѡ���Ԫ�غ͵�ǰ����ѡԪ��������һ�У���λ�����·������ضԽ�������������ҵĵ�һ��Ԫ�أ���
 * ������˵��λ�� (row, col) ����һ��Ԫ��Ӧ���� (row + 1, col - 1)��(row + 1, col) ���� (row + 1, col + 1) ��
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
     * ���شӵ�i�е�j�п�ʼ����С·����
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
