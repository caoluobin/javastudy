package org.clb.LeetCode.code1_10;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Code_70 {

    public static void main(String[] args) {
        Code_70 code = new Code_70();
        System.out.println(code.climbStairs(4));
    }
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int r = 1;
        int q = 1;
        int p = 1;
        for (int i = 1; i < n; i++) {
            p=q;
            q=r;
            r=p+q;
        }
        return r;
    }
}
