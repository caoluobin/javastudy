package org.clb.LeetCode.code1_10;

/**
 * ����һ���������� nums������ǡ��������Ԫ��ֻ����һ�Σ���������Ԫ�ؾ��������Ρ� �ҳ�ֻ����һ�ε�������Ԫ�ء�����԰� ����˳�� ���ش𰸡�
 * �������Ʋ�ʵ������ʱ�临�Ӷȵ��㷨�ҽ�ʹ�ó�������ռ�����������⡣
 */
public class Code_260 {

    public static void main(String[] args) {
        System.out.println(10^10);
    }
    public int[] singleNumber(int[] nums) {
        int eor = 0;
        for (int i = 0; i < nums.length; i++) {
            eor ^= nums[i];
        }
        //��ȡ���Ҳ��1
        int eor2 = eor & (-eor);//5: 0101 1011
        int resulta = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & eor2) != 0) {
                resulta ^= nums[i];
            }
        }
        int[] result = new int[2];
        result[0] = resulta;
        result[1] = resulta ^ eor;
        return result;
    }
}
