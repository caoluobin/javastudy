package org.clb.LeetCode.code1_10;

import java.util.Arrays;
import java.util.Map;

/**
 * 给定一个 正整数 数组 beans ，其中每个整数表示一个袋子里装的魔法豆的数目。
 * 请你从每个袋子中 拿出 一些豆子（也可以 不拿出），使得剩下的 非空 袋子中（即 至少还有一颗 魔法豆的袋子）魔法豆的数目 相等。一旦把魔法豆从袋子中取出，你不能再将它放到任何袋子中。
 * 请返回你需要拿出魔法豆的 最少数目。
 */
public class Code_2171 {

    public static void main(String[] args) {
        long a = Integer.MAX_VALUE*2L;
        System.out.println(a);
    }
    public long minimumRemoval2(int[] beans) {
        Arrays.sort(beans);
        //前缀和
        long sum = 0;
        for (int i = 0; i < beans.length; i++) {
            sum += beans[i];
        }
        long res = sum- beans[0]*(long)beans.length;
        for (int i = 1; i < beans.length; i++) {
            res = Math.min(res,sum-(long)(beans.length-i)*beans[i]);
        }
        return res;
    }
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        //前缀和
        long[] pre = new long[beans.length];
        pre[0] = 0;
        for (int i = 1; i < beans.length; i++) {
            pre[i]=pre[i-1]+beans[i-1];
        }
        long res = pre[beans.length-1];
        long lastSum =0;
        int count = 1;
        for (int i = beans.length-2; i >=0; i--) {
            lastSum += ((long) (count)) *(beans[i+1]-beans[i]);
            res = Math.min(res,pre[i]+lastSum);
            count++;
        }
        return res;
    }
}
