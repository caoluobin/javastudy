package org.clb.LeetCode.code1_10;

/**
 * ����һ������Ϊ n �Ļ����������� nums ������ nums �ķǿ� ������ �������ܺ� ��
 * �������� ��ζ�������ĩ�˽����뿪ͷ�����ʻ�״����ʽ�ϣ� nums[i] ����һ��Ԫ���� nums[(i + 1) % n] �� nums[i] ��ǰһ��Ԫ���� nums[(i - 1 + n) % n] ��
 * ������ ���ֻ�ܰ����̶������� nums �е�ÿ��Ԫ��һ�Ρ���ʽ�ϣ����������� nums[i], nums[i + 1], ..., nums[j] �������� i <= k1, k2 <= j ���� k1 % n == k2 % n ��
 */
public class Code_918 {

    public static void main(String[] args) {
        System.out.println(new Code_918().maxSubarraySumCircular(new int[]{-3,-2,-3}));
    }

    public int maxSubarraySumCircular(int[] nums) {
        //������
        int positiveSum = 0;
        //�����׶κ�
        int negativeStageSum = 0;
        int sum = 0;
        int startIndex = 0;
        int index = 0;
        boolean flag = true;
        int max = Integer.MIN_VALUE;
        //��С�����׶κ�
        int minNegative = Integer.MAX_VALUE;
        while (index != startIndex || flag) {
            if (nums[index] > 0) {
                positiveSum += nums[index];
                sum += nums[index];
                negativeStageSum = 0;
                max=Math.max(max,sum);
            } else {
                negativeStageSum += nums[index];
                sum += nums[index];
                max=Math.max(max,sum);
                if (Math.abs(negativeStageSum) >positiveSum) {
                    minNegative = Math.min(minNegative, negativeStageSum);
                    startIndex = index + 1;
                    negativeStageSum = 0;
                    positiveSum = 0;
                    sum = 0;
                }
            }

            if (index == nums.length - 1) {
                index = 0;
                flag = false;
            } else {
                index++;
            }

        }
        if (index==startIndex) {
            max = Math.max(max,sum - minNegative);
        }

        return max;

    }
}
