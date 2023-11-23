package org.clb.LeetCode.code1_10;

public class Code_2525 {

    public static void main(String[] args) {
        System.out.println(Code_2525.categorizeBox(2909,3968,3272,727));
    }
    public static String categorizeBox(int length, int width, int height, int mass) {
        long m =(long) length*width*height;
        int maxV= 10000;
        //体积
        long maxVolume = 1000*1000*1000;
        if ((m>=maxVolume||length>=maxV||width>=maxV||height>=maxV) && mass>=100) {
            return "Both";
        } else if (m>=maxVolume||length>=maxV||width>=maxV||height>=maxV) {
            return "Bulky";
        } else if (mass>=100) {
            return "Heavy";
        } else {
            return "Neither";
        }
    }
}
