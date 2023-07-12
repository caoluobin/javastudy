package org.clb.LeetCode.code1_10;

import java.util.Arrays;
import java.util.List;

public class Code_6 {

    /*
    A   E
    B D F
    C   G
     */
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }


    public static String convert(String s,int numRows) {
        if (numRows<2) return s;
        String[] split = s.split("");
        List<String> list = Arrays.asList(split);
        int size = numRows+numRows-2;
        int rounds = (list.size()+numRows+numRows-3)/(size);
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < rounds; j++) {
                if (j*size+i>=list.size()) break;
                str.append(list.get(j*size+i));
                if (i!=0&&i!=numRows-1&&(j*size+size-i<list.size())) {
                    str.append(list.get(j*size+size-i));
                }
            }
        }
        return str.toString();
    }
}
