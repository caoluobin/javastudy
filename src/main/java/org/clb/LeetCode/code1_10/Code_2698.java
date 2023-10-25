package org.clb.LeetCode.code1_10;


import java.util.*;

/**
 * 给你一个正整数 n ，请你返回 n 的 惩罚数 。
 * n 的 惩罚数 定义为所有满足以下条件 i 的数的平方和：
 * 1 <= i <= n
 * i * i 的十进制表示的字符串可以分割成若干连续子字符串，且这些子字符串对应的整数值之和等于 i 。
 */
public class Code_2698 {
    public static void main(String[] args) {
        Code_2698 code = new Code_2698();
        System.out.println(code.punishmentNumber(45));
    }
    // key 当前值  set: 所有拥有的和
    private static Map<Integer, Set<Integer>> map = new HashMap<>();
    public int punishmentNumber(int n) {
        int res=0;
        for (int i = 1; i < n + 1; i++) {
            int m = i *i;
            if (isM(i,m)) {
                res+=i*i;
            }
        }
        return res;
    }
    private boolean isM(Integer count,Integer m) {
        //如果包含
        Set<Integer> set = map.get(m);
        if (set!=null) {
            return set.contains(count);
        } else {
            //1233
           return dfs(m).contains(count);
        }
    }

    /**
     * 计算m的所有结果至map中
     * @param m
     */
    private Set<Integer> dfs(Integer m) {
        if (map.containsKey(m)) {
            return map.get(m);
        }
        Set<Integer> set = new HashSet<>();
        set.add(m);
        if (m>=10) {
            int a =10 ;
            while (m>=a) {
                int d =m%a;
                int s = m/a;
                Set<Integer> dfs = dfs(s);
                for (Integer df : dfs) {
                    set.add(df + d);
                }
                a=a*10;
            }
        }
        map.put(m,set);
        return set;
    }


}
