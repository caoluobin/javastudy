package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.List;

public class Code_2850 {
    public int minimumMoves(int[][] grid) {
        return dfs(grid);
    }
    //从每个大于 1 的格子向每个等于 0 的格子连边，容量为 1，费用为两个格子之间的曼哈顿距离。
    //从超级源点向每个大于 1 的格子连边，容量为格子的值减一（即移走的石子数），费用为 0。
    //从每个等于 0 的格子向超级汇点连边，容量 1（即移入的石子数），费用为 0。
    private int dfs(int[][] grid) {
        int res=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int count =grid[i][j];
                if (count==0) {
                    while (true) {

                    }
                }
            }
        }
        return 0;
    }

    public int minimumMoves2(int[][] grid) {
        List<List<Integer>> zerolist = new ArrayList<>();
        List<List<Integer>> morelist = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int count =grid[i][j];
                if (count==0){
                    List<Integer>  list=new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    zerolist.add(list);
                } else if (count>1) {
                    List<Integer>  list=new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    morelist.add(list);
                }
            }
        }

        return 0;
    }
}
