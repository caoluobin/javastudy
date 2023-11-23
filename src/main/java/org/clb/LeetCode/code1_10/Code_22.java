package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Code_22 {

    // ()() (())

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        Map<Integer,List<String>> map = new HashMap<>();
        return dfs(map,n);
    }

    private List<String> dfs(Map<Integer, List<String>> map, int n) {
        if (n==1) {
            List<String> list = new ArrayList<>();
            list.add("()");
            map.put(1,list);
            return list;
        }
        List<String> list = map.getOrDefault(n - 1, dfs(map, n - 1));

        return null;
    }

}
