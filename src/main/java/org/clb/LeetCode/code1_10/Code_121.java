package org.clb.LeetCode.code1_10;

/**
 * ����һ������ prices �����ĵ� i ��Ԫ�� prices[i] ��ʾһ֧������Ʊ�� i ��ļ۸�
 * ��ֻ��ѡ�� ĳһ�� ������ֻ��Ʊ����ѡ���� δ����ĳһ����ͬ������ �����ù�Ʊ�����һ���㷨�����������ܻ�ȡ���������
 * ��������Դ���ʽ����л�ȡ�������������㲻�ܻ�ȡ�κ����󣬷��� 0 ��
 */
public class Code_121 {
    public static void main(String[] args) {
        int a = 0 ;
        int b = a++;
        System.out.println(b);
    }
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int now =prices[i];
            min = Math.min(min,now);
            res = Math.max(res,now-min);
        }
        return res;
    }
}
