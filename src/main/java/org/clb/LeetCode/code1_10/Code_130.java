package org.clb.LeetCode.code1_10;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
public class Code_130 {
    int[][] a = {{1,0},{0,1}};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        UnionSet unionSet = new UnionSet(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]=='O') {
                    for (int[] direct : a) {
                        int row = i+direct[0];
                        int col = j+direct[1];
                        if (row>=0&&row<m&&col>=0&&col<n&&board[row][col] == 'O') {
                            unionSet.union(i*n+j,row*n+col);
                        }
                    }
                }
            }
        }
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                int parent = unionSet.findParent(i * n + j);
                if (!checkBoard(parent,m,n)) {
                    board[i][j]='X';
                }
            }
        }
    }

    private boolean checkBoard(int index ,int m,int n) {
        return (index>=0&&index<n)||//第一行
                (index>=(m-1)*n&&index<m*n)||//第m行
                (index%n==0)||(index%n==(n-1));
    }

    private class UnionSet {
        int[] parents;
        int[] sizes;
        int m;
        int n;

        public UnionSet(int m,int n) {
            int size = m*n;
            this.m = m;
            this.n = n;
            this.parents = new int[size];
            this.sizes = new int[size];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
                sizes[i] = 1;
            }
        }

        public int findParent(int a) {
            return a == parents[a] ? a : (parents[a] = findParent(parents[a]));
        }

        public void union(int a, int b) {
            int aP = findParent(a);
            int bP = findParent(b);
            if (aP != bP) {
                if ((checkBoard(bP,m,n)||sizes[aP] < sizes[bP])&&!checkBoard(aP,m,n)) {//aP 挂到bP上
                    parents[aP] = bP;
                    sizes[bP] += sizes[aP];
                    sizes[aP] = 0;
                } else {
                    parents[bP] = aP;
                    sizes[aP] += sizes[bP];
                    sizes[bP] = 0;
                }
            }
        }
    }
}
