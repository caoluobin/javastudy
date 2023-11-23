package org.clb.LeetCode.code1_10;

import org.clb.juc.aqs.ReadWriteLockTest;

import java.util.*;

import static org.clb.juc.aqs.ReadWriteLockTest.count;

/**
 * 给你一个 m x n 的二元矩阵 matrix ，且所有值被初始化为 0 。请你设计一个算法，随机选取一个满足 matrix[i][j] == 0 的下标 (i, j) ，并将它的值变为 1 。
 * 所有满足 matrix[i][j] == 0 的下标 (i, j) 被选取的概率应当均等。
 * 尽量最少调用内置的随机函数，并且优化时间和空间复杂度。实现 Solution 类：
 * Solution(int m, int n) 使用二元矩阵的大小 m 和 n 初始化该对象
 * int[] flip() 返回一个满足 matrix[i][j] == 0 的随机下标 [i, j] ，并将其对应格子中的值变为 1
 * void reset() 将矩阵中所有的值重置为 0
 */
public class Code_519 {
    public int m;
    public int n;
    public int cnt;
    public Map<Integer,Integer> map = new HashMap<>();
    public Random random = new Random();
    public Code_519(int m, int n) {
        this.m = m;
        this.n = n;
        this.cnt = m*n;
    }

    public int[] flip() {
        int index = random.nextInt(cnt--);
        Integer count = map.getOrDefault(index, index);
        map.put(index, map.getOrDefault(cnt, cnt));
        return new int[]{count % m, count /m};
    }

    public void reset() {
        cnt = m*n;
        map.clear();
    }

    public static void main(String[] args) {
        Code_519 code519 = new Code_519(3, 1);
        printArray(code519.flip());
        printArray(code519.flip());
        printArray(code519.flip());

    }
    public static void printArray(int[] flip) {
        for (int i : flip) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
