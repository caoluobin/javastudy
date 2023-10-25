package org.clb.LeetCode.code1_10;

/**
 * ���������ַ��� text1 �� text2�������������ַ������ ���������� �ĳ��ȡ���������� ���������� ������ 0 ��
 * һ���ַ����� ������ ��ָ����һ���µ��ַ�����������ԭ�ַ����ڲ��ı��ַ������˳��������ɾ��ĳЩ�ַ���Ҳ���Բ�ɾ���κ��ַ�������ɵ����ַ�����
 * ���磬"ace" �� "abcde" �������У��� "aec" ���� "abcde" �������С�
 * �����ַ����� ���������� ���������ַ�������ͬӵ�е������С�
 */
public class Code_1143 {


    public static void main(String[] args) {
        Code_1143 code = new Code_1143();
        System.out.println(code.longestCommonSubsequence("abcde","abcc"));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();// abcde  abcc
        char[] chars2 = text2.toCharArray();
        int[][] dp = new int[chars1.length+1][chars2.length+1];

        for (int i = 1; i < chars1.length+1; i++) {
            for (int j = 1; j < chars2.length+1; j++) {
                if (chars1[i-1] == chars2[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[chars1.length][chars2.length];
    }
}
