package org.clb.LeetCode.code1_10;

/**
 * һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ ��Start�� ����
 * ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ ��Finish�� ����
 * ���ܹ��ж�������ͬ��·����
 */
public class Code_62 {

    public static void main(String[] args) {
        Code_62 code = new Code_62();
        System.out.println(code.uniquePaths(1,1));
    }
    public int uniquePaths(int m, int n) {
        if (m==1&&n==1) return 0;
        int[][] sum = new int[m][n];
        dfs(sum,0,0);
        return sum[0][0];
    }

    private void dfs(int[][] sum, int x, int y) {
        if (x==sum[0].length-1||y==sum.length-1) {
            sum[y][x] =1;
            return;
        }
        if (sum[y][x]!=0) {
            return;
        }
        dfs(sum,x+1,y);
        dfs(sum,x,y+1);
        sum[y][x] = sum[y][x+1]+sum[y+1][x];
    }
}
