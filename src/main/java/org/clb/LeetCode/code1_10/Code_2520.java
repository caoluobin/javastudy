package org.clb.LeetCode.code1_10;

/**
 * ����һ������ num ������ num �������� num ����λ����Ŀ��
 * ������� nums % val == 0 ������Ϊ���� val �������� nums ��
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
