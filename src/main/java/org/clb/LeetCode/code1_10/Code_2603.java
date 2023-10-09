package org.clb.LeetCode.code1_10;

import java.util.*;

public class Code_2603 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        List<String> list1 = list.subList(0,3);
        list1.forEach(System.out::println);
    }
    public int collectTheCoins(int[] coins, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            Set<Integer> setA = map.computeIfAbsent(a, g -> new HashSet<>());
            setA.add(b);
            Set<Integer> setB = map.computeIfAbsent(b, g -> new HashSet<>());
            setB.add(a);
        }
        Set<Integer> oneSet = new HashSet<>();
        Set<Integer> zeroSet = new HashSet<>();
        for (int i = 0; i < coins.length; i++) {
            if (coins[i]==1){
                oneSet.add(i);
            } else {
                zeroSet.add(i);
            }
        }
        int res = Integer.MAX_VALUE;
        for (Integer now : zeroSet) {
            res = Math.min(res,dfs(now,map,oneSet,0,null)[0]) ;
        }
        return 2;
    }

    // step  deep
    private int[] dfs(Integer now, Map<Integer, Set<Integer>> map, Set<Integer> oneSet, Integer count,Integer father) {
        Set<Integer> nextList = map.get(now);
        if (nextList==null||nextList.isEmpty()) {
            return new int[]{0,0};
        }
        int res =count+1;
        for (Integer next : nextList) {
            if (!Objects.equals(next, father)) {
                int[] dfs = dfs(next, map, oneSet, 0, count + 1);
                res = Math.max(1,res) ;
            }
        }

        return new int[]{0,0};
    }
}
