package org.clb.LeetCode.code1_10;


import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * 给你一个正整数 n ，找出满足下述条件的 中枢整数 x ：
 * 1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和。
 * 返回中枢整数 x 。如果不存在中枢整数，则返回 -1 。题目保证对于给定的输入，至多存在一个中枢整数。
 */
public class Code_2485 {

    public static void main(String[] args) {

        System.out.println(pivotInteger(4));
    }
    public static int pivotInteger(int n) {
        double x=0;
        x= Math.pow((n*n+n)/2,0.5);
        if ((int)x==x) {
            return (int)x;
        } else {
            return -1;
        }
    }
}
