package org.clb.LeetCode.code1_10;

/**
 * ����һ���������� nums������ ���� answer ������ answer[i] ���� nums �г� nums[i] ֮�������Ԫ�صĳ˻� ��
 * ��Ŀ���� ��֤ ���� nums֮������Ԫ�ص�ȫ��ǰ׺Ԫ�غͺ�׺�ĳ˻�����  32 λ ������Χ�ڡ�
 * �� ��Ҫʹ�ó��������� O(n) ʱ�临�Ӷ�����ɴ��⡣
 */
public class Code_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0]=1;
        int[] right = new int[nums.length];
        right[0]=1;
        int leftE = 1;
        int rightE = 1;
        for (int i = 1; i < nums.length; i++) {
            leftE *= nums[i-1];
            left[i]= leftE;
            rightE *= nums[nums.length-i];
            right[i]= rightE;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = left[i]*right[res.length-i-1];
        }
        return res;
    }
}
