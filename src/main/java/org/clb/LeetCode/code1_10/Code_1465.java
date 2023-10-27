package org.clb.LeetCode.code1_10;

import java.util.Arrays;

/**
 * ���ε���ĸ߶�Ϊ h �ҿ��Ϊ w������������������ horizontalCuts �� verticalCuts�����У�
 * horizontalCuts[i] �ǴӾ��ε��ⶥ������  i ��ˮƽ�пڵľ���
 * verticalCuts[j] �ǴӾ��ε������ൽ�� j ����ֱ�пڵľ���
 * ���㰴���� horizontalCuts �� verticalCuts ���ṩ��ˮƽ����ֱλ���и�������ҳ� ������ ���Ƿݵ��⣬�������� ��� ��
 * ���ڴ𰸿�����һ���ܴ�����֣������Ҫ����� �� 109 + 7 ȡ�� �󷵻ء�
 */
public class Code_1465 {
    private static int MOD = 1000000007;

    public static void main(String[] args) {
        Code_1465 code = new Code_1465();
        code.maxArea(1000000000, 1000000000, new int[]{2}, new int[]{2});
    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxH = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        for (int i = 1; i < horizontalCuts.length; i++) {
            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        int maxW = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for (int i = 1; i < verticalCuts.length; i++) {
            maxW = Math.max(maxW, verticalCuts[i] - verticalCuts[i - 1]);
        }
        return (int) ((long) maxH * maxW % MOD);
    }
}
