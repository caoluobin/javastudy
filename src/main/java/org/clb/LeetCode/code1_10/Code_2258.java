package org.clb.LeetCode.code1_10;

import java.util.Arrays;
import java.util.ServiceLoader;

public class Code_2258 {
    public static void main(String[] args) {
        String a ="aaa";
        String b ="aaa";
        String c = new String("aaa");
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(a==c.intern());
    }
    public int maximumMinutes(int[][] grid) {
        int[][] peopleTimes = new int[grid.length][grid[0].length];
        int[][] fireTimes = new int[grid.length][grid[0].length];

        return 0;
    }
}
