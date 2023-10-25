package org.clb.LeetCode.code1_10;

import java.util.*;
import java.util.stream.Collectors;

public class Code_49 {
    public static void main(String[] args) {
        Code_49 code =new Code_49();
        code.groupAnagrams(new String[]{"bdddddddddd","bbbbbbbbbbc"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {//45
        //1-26  1 1 3   1 2 2//11 24 35     31 62   93
        Map<String,List<String>>  map = new HashMap<>();
        for (String str : strs) {
            int[] m = new int[26];
            char[] chars = str.toCharArray();
            for (char aChar : chars) {
                m[aChar-'a']=m[aChar-'a']+1;
            }
            StringBuffer strB = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                strB.append('a'+i);
                strB.append(m[i]);
            }
            List<String> list = map.computeIfAbsent(strB.toString(),a-> new ArrayList<>());
            list.add(str);
        }

        return map.entrySet().stream().map(a->a.getValue()).collect(Collectors.toList());
    }
    public List<List<String>> groupAnagrams2(String[] strs) {//45
        Map<String,List<String>>  map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            List<String> list = map.computeIfAbsent(Arrays.toString(chars),a-> new ArrayList<>());
            list.add(str);
        }

        return map.entrySet().stream().map(a->a.getValue()).collect(Collectors.toList());
    }
}
