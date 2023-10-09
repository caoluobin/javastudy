package org.clb.LeetCode.code1_10;

public class Code_2849 {

    public static void main(String[] args) {
        Code_2849 code = new Code_2849();
        System.out.println(code.isReachableAtTime(1, 4, 1, 2, 1));
    }
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx==fx&&sy==fy) {
            return t>1;
        }
        return Math.max(Math.abs(fx-sx),Math.abs(fy-sy))<=t;
    }
}
