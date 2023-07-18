package org.clb.LeetCode.code1_10;

public class Code_415 {

    public static void main(String[] args) {
        System.out.println((int)'0');
    }

    public String addStrings(String num1, String num2) {
        int length1 = num1.length()-1;
        int length2 = num2.length()-1;
        StringBuilder str = new StringBuilder();
        int jinwei = 0;
        while (length1>=0||length2>=0||jinwei==1) {
            int a =length1>=0? num1.charAt(length1--)-48:0;
            int b =length2>=0? num2.charAt(length2--)-48:0;
            str.append((a+b+jinwei)%10);
            jinwei = (a+b+jinwei)/10;
        }
        return str.reverse().toString();
    }
}
