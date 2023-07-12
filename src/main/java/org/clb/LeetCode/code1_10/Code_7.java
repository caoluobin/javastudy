package org.clb.LeetCode.code1_10;

/**
 * ����һ�� 32 λ���з������� x �����ؽ� x �е����ֲ��ַ�ת��Ľ����
 * �����ת���������� 32 λ���з��������ķ�Χ [?231,  231 ? 1] ���ͷ��� 0��
 * ���軷��������洢 64 λ�������з��Ż��޷��ţ���
 */
public class Code_7 {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new Code_7().reverse(-1563847412));
    }
    public int reverse(int x) {
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        if (chars[0]=='-'&&chars.length==11) {
            String min = String.valueOf(Integer.MIN_VALUE);
            for (int i = 1; i < chars.length; i++) {
                if (chars[chars.length-i]>min.charAt(i)) return 0;
                if (chars[chars.length-i]<min.charAt(i)) break;
            }
        } else if (chars[0]!='-'&&chars.length==10) {
            String max = String.valueOf(Integer.MAX_VALUE);
            for (int i = 0; i < chars.length; i++) {
                if (chars[chars.length-i-1]>max.charAt(i)) return 0;
                if (chars[chars.length-i-1]<max.charAt(i)) break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int a= 0;
        if (x<0) {
            stringBuilder.append('-');
            a=1;
        }
        for (int i = chars.length-1; i >=a ; i--) {
            stringBuilder.append(chars[i]);
        }
        return Integer.parseInt(stringBuilder.toString());
    }

    public int reverse2(int x) {
        int res = 0;
        while (x!=0) {
            int pop = x%10;
            x/=10;
            if (res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&pop>7)) return 0;
            if (res<Integer.MIN_VALUE/10||(res==Integer.MIN_VALUE/10&&pop<-8)) return 0;
            res = res*10+pop;
        }

        return res;
    }
}
