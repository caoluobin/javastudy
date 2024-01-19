package org.clb.LeetCode.code1_10;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 */
public class Code_994 {

    public static void main(String[] args) {
        Code_994 code = new Code_994();
        code.orangesRotting(new int[][]{{2,2},{1,1},{0,0},{2,0}});
    }
    /**
     * 先找出所有的橘子放入队列中 然后通过队列进行bfs搜索 将边上的橘子再次放入队列
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i,j,0});
                }

            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0];
            int j = poll[1];
            int time = poll[2];
            if (grid[i][j]==1) {
                res=time;
            }
            grid[i][j]=2;
            if (j > 0 && grid[i][j - 1] == 1) {
                queue.add(new int[]{i,j-1,time+1});
            }
            // 往右
            if (j < n - 1 && grid[i][j + 1] == 1) {
                queue.add(new int[]{i,j+ 1,time+1});
            }
            //往上
            if (i > 0 && grid[i - 1][j] == 1) {
                queue.add(new int[]{i-1,j,time+1});
            }
            //往下
            if (i < m - 1 && grid[i + 1][j] == 1) {
                queue.add(new int[]{i+ 1,j,time+1});
            }

        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return res;
    }

}
