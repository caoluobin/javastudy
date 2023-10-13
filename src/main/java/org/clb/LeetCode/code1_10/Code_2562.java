package org.clb.LeetCode.code1_10;

/**
 * ����һ���±�� 0 ��ʼ���������� nums ��
 * �ֶ����������ֵ� ���� ������������ֵ���������γɵ������֡�
 * ���磬15 �� 49 �Ĵ����� 1549 ��
 * nums �� ����ֵ ������� 0 ��ִ����������ֱ�� nums ��Ϊ�գ�
 * ��� nums �д��ڲ�ֹһ�����֣��ֱ�ѡ�� nums �еĵ�һ��Ԫ�غ����һ��Ԫ�أ������ߴ����õ���ֵ�ӵ� nums �� ����ֵ �ϣ�Ȼ��� nums ��ɾ����һ�������һ��Ԫ�ء�
 * ���������һ��Ԫ�أ��򽫸�Ԫ�ص�ֵ�ӵ� nums �Ĵ���ֵ�ϣ�Ȼ��ɾ�����Ԫ�ء�
 * ����ִ�������в����� nums �Ĵ���ֵ��
 */
public class Code_2562 {
    public static void main(String[] args) {
        Code_2562 code = new Code_2562();
        System.out.println(code.findTheArrayConcVal(new int[]{5,14,13,8,12}));
    }
    public long findTheArrayConcVal(int[] nums) {
        long sum = 0;
        int length = nums.length;
        for (int i = 0; i < length/2; i++) {
            int num = nums[length - i - 1];
            int a = 1;
            while (num>0) {
                sum+=num%10*a;
                num=num/10;
                a=a*10;
            }
            sum+=nums[i]*a;

        }
        if (length%2==1) {
            sum+=nums[length/2];
        }

        return sum;
    }
}
