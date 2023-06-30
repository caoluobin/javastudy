package org.clb.LeetCode.code1_10;

import org.clb.juc.aqs.ReadWriteLockTest;

import java.util.*;

import static org.clb.juc.aqs.ReadWriteLockTest.count;

/**
 * ����һ�� m x n �Ķ�Ԫ���� matrix ��������ֵ����ʼ��Ϊ 0 ���������һ���㷨�����ѡȡһ������ matrix[i][j] == 0 ���±� (i, j) ����������ֵ��Ϊ 1 ��
 * �������� matrix[i][j] == 0 ���±� (i, j) ��ѡȡ�ĸ���Ӧ�����ȡ�
 * �������ٵ������õ���������������Ż�ʱ��Ϳռ临�Ӷȡ�ʵ�� Solution �ࣺ
 * Solution(int m, int n) ʹ�ö�Ԫ����Ĵ�С m �� n ��ʼ���ö���
 * int[] flip() ����һ������ matrix[i][j] == 0 ������±� [i, j] ���������Ӧ�����е�ֵ��Ϊ 1
 * void reset() �����������е�ֵ����Ϊ 0
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
