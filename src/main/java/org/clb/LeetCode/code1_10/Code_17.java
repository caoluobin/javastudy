package org.clb.LeetCode.code1_10;

import java.util.*;

public class Code_17 {

    public Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        char[] chars = digits.toCharArray();
        List<String> list = new ArrayList<>();
        for (char aChar : chars) {
            list.add(map.get(aChar));
        }
        List<String> result = new ArrayList<>();
        dfs(list, 0, "", result);
        return result;
    }

    public void dfs(List<String> list, int index, String s, List<String> result) {
        if (index == list.size()) {
            result.add(s);
            return;
        }
        String s1 = list.get(index);
        for (int i = 0; i < s1.length(); i++) {
            dfs(list, index + 1, s + s1.charAt(i), result);
        }
    }
}
