package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.List;

public class Code_2850 {
    public int minimumMoves(int[][] grid) {
        return dfs(grid);
    }
    //��ÿ������ 1 �ĸ�����ÿ������ 0 �ĸ������ߣ�����Ϊ 1������Ϊ��������֮��������پ��롣
    //�ӳ���Դ����ÿ������ 1 �ĸ������ߣ�����Ϊ���ӵ�ֵ��һ�������ߵ�ʯ������������Ϊ 0��
    //��ÿ������ 0 �ĸ����򳬼�������ߣ����� 1���������ʯ������������Ϊ 0��
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
