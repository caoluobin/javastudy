package org.clb.LeetCode.code1_10;

/**
 * 给你一个整数 num ，返回 num 中能整除 num 的数位的数目。
 * 如果满足 nums % val == 0 ，则认为整数 val 可以整除 nums 。
 */
public class Code_2520 {
    public int countDigits(int num) {
        int res =0;
        int g = num;
        while (num>=10) {
            int d = num%10;
            if (g%d ==0) {
                res++;
            }
            num=num/10;
        }
        if (g%num ==0) {
            res++;
        }
        return res;

    }

}
