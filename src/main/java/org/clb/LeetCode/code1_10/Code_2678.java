package org.clb.LeetCode.code1_10;

public class Code_2678 {
    public static void main(String[] args) {

    }

    public static  int countSeniors(String[] details) {
        int count= 0;
        for (String detail : details) {
            if (Integer.parseInt(detail.substring(11,13))>60) {
                count++;
            }
        }
        return count;
    }

}
