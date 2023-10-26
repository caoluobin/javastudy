package org.clb.LeetCode.code1_10;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 */
public class Code_438 {// abadd  abd


    public static void main(String[] args) {
        System.out.println(Code_438.findAnagrams("abab","ab"));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] chars = p.toCharArray();
        int[] ints = new int[26];
        for (char aChar : chars) {
            ints[aChar-'a'] =ints[aChar-'a']+1;
        }
        char[] sChars = s.toCharArray();
        int[] sInts = new int[26];
        int length = p.length();
        for (int i = 0; i < sChars.length; i++) {
            char sChar = sChars[i];
            sInts[sChar-'a'] =sInts[sChar-'a']+1;
            if (i>p.length()-1) {
                char startChar = sChars[i-length];
                sInts[startChar-'a'] =sInts[startChar-'a']-1;

            }
            if (i>=p.length()-1){
                boolean f=true;
                int count = length ;
                for (int j = 0; j < 26; j++) {
                    if (sInts[j]!=ints[j]||count<=0) {
                        count-=sInts[j];
                        f=false;
                        break;
                    }
                }
                if (f) {
                    res.add(i-length+1);
                }
            }
        }

        return res;
    }
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] chars = p.toCharArray();
        Map<Character,Count> sMap = new HashMap<>();
        int[] ints = new int[26];
        for (char aChar : chars) {
            ints[aChar-'a'] =ints[aChar-'a']+1;
        }
        for (int i = 0; i < ints.length; i++) {
            sMap.put((char)(i+'a'),new Count(ints[i],ints[i]));
        }

        int index =0;
        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            for (Map.Entry<Character, Count> entry : sMap.entrySet()) {
                Count value = entry.getValue();
                value.count=value.origin;
            }
            int sum = p.length();
            for (int j = index; j < sChars.length; j++) {
                char nchar = sChars[j];
                Count count = sMap.get(nchar);
                if (count==null||count.count==0) {
                    break;
                } else {
                    count.count=count.count-1;
                }
                if (--sum==0) {
                    res.add(index);
                }
            }
            index++;
        }

        return res;
    }
    private class Count {
        int count;
        int origin;

        public Count(int count, int origin) {
            this.count = count;
            this.origin = origin;
        }
    }

}
