package org.clb.LeetCode.code1_10;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class Code_200 {

    public static void main(String[] args) {
        char[][] grid = {{'1','0','1','1','1'},
                         {'1','0','1','0','1'},
                         {'1','1','1','0','1'}};
        Code_200 code = new Code_200();
        System.out.println(code.numIslands(grid));
    }

    /**
     * 搜索grid把连接的所有岛值改为水 搜索次数即为岛的个数
     * @param grid
     * @return
     */
    public int numIslands3(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res =0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]=='0') {
                    continue;
                }
                dfs2(grid,i,j,m,n);
                res++;
            }
        }
        return res;
    }

    private void dfs2( char[][] grid, int i, int j,int m,int n) {
        grid[i][j]='0';
        //往左
        if (j>0&&grid[i][j-1]=='1') {
            dfs2(grid,i,j-1,m,n);
        }
        // 往右
        if (j<n-1&&grid[i][j+1]=='1') {
            dfs2(grid,i,j+1,m,n);
        }
        //往上
        if (i>0&&grid[i-1][j]=='1') {
            dfs2(grid,i-1,j,m,n);
        }
        //往下
        if (i<m-1&&grid[i+1][j]=='1') {
            dfs2(grid,i+1,j,m,n);
        }
    }
    public int numIslands2(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][] parents = new Integer[m][n];
        int res =0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (parents[i][j]!=null||grid[i][j]=='0') {
                    continue;
                }
                dfs(parents,grid,i,j,m,n);
                res++;
            }
        }
        return res;
    }

    private void dfs(Integer[][] parents, char[][] grid, int i, int j,int m,int n) {
        parents[i][j]=1;
        //往左
        if (j>0&&grid[i][j-1]=='1'&&parents[i][j-1]==null) {
            dfs(parents,grid,i,j-1,m,n);
        }
        // 往右
        if (j<n-1&&grid[i][j+1]=='1'&&parents[i][j+1]==null) {
            dfs(parents,grid,i,j+1,m,n);
        }
        //往上
        if (i>0&&grid[i-1][j]=='1'&&parents[i-1][j]==null) {
            dfs(parents,grid,i-1,j,m,n);
        }
        //往下
        if (i<m-1&&grid[i+1][j]=='1'&&parents[i+1][j]==null) {
            dfs(parents,grid,i+1,j,m,n);
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        UnionSet unionSet = new UnionSet(m*n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]=='0') {//水
                    unionSet.water(i*n+j);
                } else {//陆地
                    //往上
                    if (i!=0&&grid[i-1][j]=='1') {
                        unionSet.union(i*n+j,(i-1)*n+j);
                    }
                    // 往右
                    if (j!=(n-1)&&grid[i][j+1]=='1') {
                        unionSet.union(i*n+j,i*n+j+1);
                    }
                }
            }
        }

        return unionSet.getParentCount();
    }

    private class UnionSet {
        private int[] parents;
        private int[] sizes;

        public UnionSet(int size) {
            this.parents = new int[size];
            this.sizes = new int[size];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
                sizes[i] = 1;
            }
        }
        private int getParentCount() {
            Set<Integer> set = new HashSet<>();
            for (int parent : parents) {
                if (parent!=-1) {
                    set.add(findParent(parent));
                }
            }
            return set.size();
        }

        private int findParent(int a) {
            return a == parents[a] ? a : (parents[a] = findParent(parents[a]));
        }

        private void water(int a ) {
            parents[a]=-1;
        }
        private void union(int a, int b) {
            int aP = findParent(a);
            int bP = findParent(b);
            if (aP==bP) return;
            //往上挂 再往左挂  越靠左上优先级越高
            if (aP<bP) {
                parents[bP] = aP;
                sizes[aP]+=sizes[bP];
                sizes[bP]=0;
            } else{
                parents[aP] = bP;
                sizes[bP]+=sizes[aP];
                sizes[aP]=0;
            }
        }
    }
}
