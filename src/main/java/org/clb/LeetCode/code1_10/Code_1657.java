package org.clb.LeetCode.code1_10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Code_1657 {
    public boolean closeStrings2(String word1, String word2) {
        if (word1.length()!=word2.length()) {
            return false;
        }
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        for (char c : chars1) {
            a1[c-'a']++;
        }
        for (char c : chars2) {
            a2[c-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((a1[i]==0&&a2[i]!=0)||(a2[i]==0&&a1[i]!=0)) {
                return false;
            }
        }

        Arrays.sort(a1);
        Arrays.sort(a2);

        // 比较两个Map是否相等
        return Arrays.equals(a1,a2);
    }
    public boolean closeStrings(String word1, String word2) {
        if (word1.length()!=word2.length()) {
            return false;
        }
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        Map<Character,Integer> map1= new HashMap<>();
        Map<Character,Integer> map2= new HashMap<>();
        for (char c : chars1) {
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        for (char c : chars2) {
            map2.put(c,map2.getOrDefault(c,0)+1);
        }
        if (map1.size()!=map2.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (!map2.containsKey(entry.getKey())) {
                return false;
            }
        }
        List<Integer> list1 = map1.entrySet().stream().map(Map.Entry::getValue).sorted().collect(Collectors.toList());
        List<Integer> list2 = map2.entrySet().stream().map(Map.Entry::getValue).sorted().collect(Collectors.toList());
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }


}
