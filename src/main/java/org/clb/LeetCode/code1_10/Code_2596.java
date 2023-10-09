package org.clb.LeetCode.code1_10;

import java.util.*;

public class Code_2596 {


    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0]!=0) {
            return false;
        }
        Map<Integer,Grid> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                map.put(grid[i][j],new Grid(grid[i][j], i, j));
            }
        }
        Grid g=null;

        for (int i = 0; i < grid.length * grid.length; i++) {
            Grid nowGrid = map.get(i);
            if (nowGrid == null) {
                return false;
            }
            if (g==null) {
                g=nowGrid;
            } else {
                if (!(Math.abs(nowGrid.x-g.x)==2&&Math.abs(nowGrid.y-g.y)==1)&&!(Math.abs(nowGrid.x-g.x)==1&&Math.abs(nowGrid.y-g.y)==2)) {
                    return false;
                }
                g = nowGrid;
            }

        }
        return true;
    }

    class Grid{
        private Integer index;
        private Integer x;
        private Integer y;

        public Grid(Integer index, Integer x, Integer y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }

        public Integer getIndex() {
            return index;
        }
    }
}
