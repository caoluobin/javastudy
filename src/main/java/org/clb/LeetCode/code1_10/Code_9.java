package org.clb.LeetCode.code1_10;

public class Code_9 {

    public static void main(String[] args) {

    }

    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        if (s.length()<=1) return true;
        char[] chars = s.toCharArray();
        int length =chars.length;
        for (int i = 0; i < length; i++) {
            if (i==length/2) break;
            if (chars[i]==chars[length-i-1]) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
    public boolean isPalindrome2(int x) {
        if (x<0) return false;

        int num = x;
        int cur = 0;
        while (num>0) {
            cur = cur*10 + num%10;
            num = num/10;
        }
        return num==cur;
    }
}
