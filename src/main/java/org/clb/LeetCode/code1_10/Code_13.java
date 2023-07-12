package org.clb.LeetCode.code1_10;

import java.util.HashMap;
import java.util.Map;

public class Code_13 {

    public static Map<String,Integer> map = new HashMap() {
        {
            put("I",1);
            put("V",5);
            put("X",10);
            put("L",50);
            put("C",100);
            put("D",500);
            put("M",1000);
        }
    } ;

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }
    public  static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i<chars.length-1&&getValue(chars[i]) <getValue(chars[i+1])) {
                result = result - getValue(chars[i]);
            } else {
                result = result + getValue(chars[i]);
            }
        }
        return result;

    }
    private static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
