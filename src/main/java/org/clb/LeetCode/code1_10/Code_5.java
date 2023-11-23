package org.clb.LeetCode.code1_10;

public class Code_5 {


    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        if (s.length()<2) return s;
        int left =0;
        int right = 0;
        int start = 0;
        int maxLen = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int length = 1;
            left = i-1;
            right=i+1;
            //中间几个相等处理
            //左边处理
            while (left>=0&&chars[left]==chars[i]) {
                left--;
                length++;
            }
            //右边处理
            while (right<chars.length&&chars[right]==chars[i]) {
                right++;
                length++;
            }
            //两边扩散处理
            while (left>=0&&right<chars.length&&chars[left]==chars[right]) {
                left--;
                right++;
                length+=2;
            }

            System.out.println("i："+i+"  length"+length+" left"+left);
            if (maxLen<length) {
                maxLen=length;
                start = left;

            }


        }
        return s.substring(start+1,start+maxLen+1);
    }


}
