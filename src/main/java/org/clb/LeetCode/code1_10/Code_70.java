package org.clb.LeetCode.code1_10;

/**
 * ������������¥�ݡ���Ҫ n ������ܵ���¥����
 * ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
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
