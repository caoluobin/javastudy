package org.clb.LeetCode.code1_10;

/**
 * I  1 V  5  X  10 L  50 C  100 D  500 M  1000
 * ͨ������£�����������С�������ڴ�����ֵ��ұߡ���Ҳ�������������� 4 ��д�� IIII������ IV������ 1 ������ 5 ����ߣ�
 * ����ʾ�������ڴ��� 5 ��С�� 1 �õ�����ֵ 4 ��ͬ���أ����� 9 ��ʾΪ IX���������Ĺ���ֻ�������������������
 * I ���Է��� V (5) �� X (10) ����ߣ�����ʾ 4 �� 9��
 * X ���Է��� L (50) �� C (100) ����ߣ�����ʾ 40 �� 90��
 * C ���Է��� D (500) �� M (1000) ����ߣ�����ʾ 400 �� 900��
 * ����һ������������תΪ�������֡�
 */
public class Code_12 {

    public static void main(String[] args) {
        System.out.println(new Code_12().intToRoman(3999));
    }
    public String intToRoman(int num) {

        return "";
    }
    public String intToRoman2(int num) {
        //��numת����������
        String[] roman = {"I", "V", "X", "L", "C", "D", "M"};
        String result = "";
        int i =0;
        while (num>0) {
            int temp = num % 10;
            switch (temp) {
                case 1:
                    result = roman[i] + result;
                    break;
                case 2:
                    result = roman[i] + roman[i] + result;
                    break;
                case 3:
                    result = roman[i] + roman[i] + roman[i] + result;
                    break;
                case 4:
                    result = roman[i] + roman[i + 1] + result;
                    break;
                case 5:
                    result = roman[i + 1] + result;
                    break;
                case 6:
                    result = roman[i + 1] + roman[i] + result;
                    break;
                case 7:
                    result = roman[i + 1] + roman[i] + roman[i] + result;
                    break;
                case 8:
                    result = roman[i + 1] + roman[i] + roman[i] + roman[i] + result;
                    break;
                case 9:
                    result = roman[i] + roman[i + 2] + result;
                    break;
            }
            i+=2;
            num = num / 10;
        }
        return result;
    }
}
