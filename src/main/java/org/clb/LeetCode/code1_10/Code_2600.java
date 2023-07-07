package org.clb.LeetCode.code1_10;

/**
 * ������װ��һЩ��Ʒ��ÿ����Ʒ�϶���������� 1 ��0 �� -1 ��
 * �����ĸ��Ǹ����� numOnes ��numZeros ��numNegOnes �� k ��
 * �������������
 * numOnes �����Ϊ 1 ����Ʒ��
 * numZeroes �����Ϊ 0 ����Ʒ��
 * numNegOnes �����Ϊ -1 ����Ʒ��
 * �ּƻ�����Щ��Ʒ��ǡ��ѡ�� k ����Ʒ���������п��з����У���Ʒ�����������֮�͵����ֵ��
 */
public class Code_2600 {


    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k == 0) {
            return 0;
        }
        if (k<=numOnes){
            return k;
        } else if (k<=numOnes+numZeros){
            return numOnes;
        } else if (k<=numOnes+numZeros+numNegOnes){
            return numOnes-(k-numOnes-numZeros);
        } else {
            return numOnes+numNegOnes;
        }
    }
}
