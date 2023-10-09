package org.clb.LeetCode.code1_10;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
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
