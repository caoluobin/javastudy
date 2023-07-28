package org.clb.LeetCode.codeUtil;

public class ArrayUtil {

    public static void main(String[] args) {
        dealString("[2,7],[2,6],[3,6],[4,6],[7,6],[2,1],[3,1],[4,1],[6,1],[7,1],[3,8],[5,8],[7,8],[1,9],[2,9],[6,9],[7,9]");
    }
    public static void dealString(String a) {
        String[] split = a.split(",");
        for (String s : split) {
            s=s.replace("[", "{");
            s=s.replace("]", "}");
            s=s+",";
            System.out.print(s);
        }
    }
}
