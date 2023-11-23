package org.clb.LeetCode.code1_10;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [?231,  231 ? 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
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
