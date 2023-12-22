package org.clb.LeetCode.code1_10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Code_2646 {
    public static void main(String[] args) {
        int[][] edges = {{3, 24}, {6, 2}, {2, 23}, {7, 35}, {12, 28}, {13, 20}, {15, 21}, {20, 5}, {23, 18}, {18, 33}, {27, 9}, {28, 8}, {8, 4}, {4, 22}, {22, 21}, {21, 10}, {10, 0}, {0, 9}, {31, 30}, {30, 33}, {32, 16}, {16, 39}, {34, 35}, {35, 26}, {26, 33}, {36, 33}, {37, 40}, {38, 33}, {33, 24}, {24, 19}, {19, 25}, {25, 29}, {29, 14}, {14, 5}, {39, 17}, {17, 1}, {1, 9}, {9, 11}, {40, 11}, {11, 5}, {5, 41}};
        int[] price = {34, 34, 8, 44, 26, 8, 44, 38, 4, 26, 6, 2, 20, 10, 8, 8, 38, 38, 12, 22, 16, 14, 28, 16, 28, 20, 22, 32, 14, 8, 42, 20, 42, 36, 14, 38, 24, 4, 2, 20, 36, 2};
        int[][] trips = {{35, 35}, {36, 3}, {8, 2}};
        Code_2646 code = new Code_2646();
        System.out.println(code.minimumTotalPrice(4, edges, price, trips));

    }

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            //处理关联关系到map中
            deal(edge, map);
        }
        int[] cnt = new int[price.length];
        for (int[] trip : trips) {
            //处理经过的点
            count(cnt, map, trip[0], trip[1], null);
        }
        for (int i = 0; i < cnt.length; i++) {
            price[i] = price[i] * cnt[i];
        }
        //0 表示原来  1表示减半
        Integer[][] min = new Integer[price.length][2];
        int res = 0;
        int[] f = new int[price.length];
        for (int i = 0; i < price.length; i++) {
            if (price[i] != 0&&f[i]==0) {
                res += dfs(price, map, i, min, null, false,f);
            }
        }

        return res;
    }

    private int dfs(int[] price, Map<Integer, Set<Integer>> map, int root, Integer[][] min, Integer parent, boolean parentDe ,int[] f) {
        if (price[root] == 0) {
            return 0;
        }
        f[root]=1;
        Set<Integer> set = map.getOrDefault(root,new HashSet<>());
        //节点不减半
        int res;
        if (min[root][0] == null) {
            res = price[root];
            for (Integer index : set) {
                if (index.equals(parent)) {
                    continue;
                }
                res += dfs(price, map, index, min, root, false,f);
            }
            min[root][0] = res;
        } else {
            res = min[root][0];
        }


        //节点减半
        if (!parentDe) {
            if (min[root][1] == null) {
                int y = price[root] / 2;
                for (Integer index : set) {
                    if (index.equals(parent)) {
                        continue;
                    }
                    y += dfs(price, map, index, min, root, true,f);
                }
                res = Math.min(res, y);
                min[root][1] = res;
            } else {
                res = Math.min(res, min[root][1]);
            }
        }
        return res;
    }

    private boolean count(int[] cnt, Map<Integer, Set<Integer>> map, int start, int end, Integer parent) {
        if (start == end) {
            cnt[start]++;
            return true;
        }
        Set<Integer> set = map.get(start);
        if (set.contains(end)) {
            cnt[start]++;
            cnt[end]++;
            return true;
        }
        for (Integer s2 : set) {
            if (s2.equals(parent)) {
                continue;
            }
            boolean isHad = count(cnt, map, s2, end, start);
            if (isHad) {
                cnt[start]++;
                return true;
            }
        }
        return false;
    }

    private void deal(int[] edge, Map<Integer, Set<Integer>> map) {
        int a = edge[0];
        int b = edge[1];
        Set<Integer> setA = map.getOrDefault(a, new HashSet<>());
        setA.add(b);
        map.put(a, setA);
        Set<Integer> setB = map.getOrDefault(b, new HashSet<>());
        setB.add(a);
        map.put(b, setB);
    }
}
