package org.clb.LeetCode.code1_10;

public class Code_2544 {

    public static void main(String[] args) {
        System.out.println(new Code_2544().alternateDigitSum(332));
    }
    public int alternateDigitSum(int n) {
        int sum = 0;
        int i = 0;
        while (n > 0) {
            int digit = n % 10;
            if (i % 2 == 0) {
                sum += digit;
            } else {
                sum -= digit;
            }
            n=n/10;
            i++;
        }
        return i % 2 == 0 ? - sum : sum;
    }
}
