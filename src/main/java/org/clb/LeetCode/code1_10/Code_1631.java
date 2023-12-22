package org.clb.LeetCode.code1_10;

import java.util.*;

public class Code_1631 {

    public static void main(String[] args) {
        Code_1631 code = new Code_1631();
        int[][] a = {{4, 3, 4, 10, 5, 5, 9, 2}, {10, 8, 2, 10, 9, 7, 5, 6}, {5, 8, 10, 10, 10, 7, 4, 2}, {5, 1, 3, 1, 1, 3, 1, 9}, {6, 4, 10, 6, 10, 9, 4, 6}};
        System.out.println(code.minimumEffortPath(a));

    }

    public int minimumEffortPath(int[][] heights) {
        return dichotomy(heights);
    }

    /**
     * 二分法
     */
    private int dichotomy(int[][] heights) {
        int left = 0;
        int right = 10;
        int ans = 0;
        int m = heights.length;
        int n = heights[0].length;
        while (left<=right) {
            int mid = (left+right)/2;
            boolean[][] flags =new boolean[m][n];
            flags[0][0]=true;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j < n - 1&&flags[i][j]&&Math.abs(heights[i][j] - heights[i][j + 1])<=mid) {//右
                        flags[i][j+1] = true;
                    }
                    if (i < m - 1&&flags[i][j]&&Math.abs(heights[i][j] - heights[i + 1][j])<=mid) {//下
                        flags[i+1][j] = true;
                    }
                }
            }
            if (flags[m-1][n-1]) {
                ans= mid;
                right = mid-1;
            } else {
                left = mid+1;
            }

        }
        return ans;
    }

    /**
     * 并查集
     * @param heights
     * @return
     */
    private int union(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<int[]> list = new ArrayList<>(m*n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n - 1) {//右
                    list.add(new int[]{n * i + j, n * i + j + 1, Math.abs(heights[i][j] - heights[i][j + 1])});
                }
                if (i < m - 1) {//下
                    list.add(new int[]{n * i + j, n * (i + 1) + j, Math.abs(heights[i][j] - heights[i + 1][j])});
                }
            }
        }
        int ans = 0;
        list.sort((a, b) -> {
            return a[2] - b[2];
        });
        Union union = new Union(m, n);
        for (int[] poll : list) {
            union.union(poll[0], poll[1]);
            if (union.isSameSet(0, m * n - 1)) {
                ans = poll[2];
                break;
            }
        }

        return ans;
    }

    private class Union {

        private int[] parents;

        private int[] sizes;

        public Union(int m, int n) {
            parents = new int[m * n];
            sizes = new int[m * n];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
                sizes[i] = 1;
            }
        }

        public int findP(int a) {
            return a == parents[a] ? a :(parents[a]= findP(parents[a]));//扁平化处理
        }

        public void union(int a, int b) {
            int aP = findP(a);
            int bP = findP(b);
            //a挂b
            if (sizes[bP] > sizes[aP]) {
                sizes[bP] += sizes[aP];
                sizes[aP] = 0;
                parents[aP] = bP;
            } else {//b挂a
                sizes[aP] += sizes[bP];
                sizes[bP] = 0;
                parents[bP] = aP;
            }
        }

        public boolean isSameSet(int a, int b) {
            return findP(a) == findP(b);
        }
    }
}
