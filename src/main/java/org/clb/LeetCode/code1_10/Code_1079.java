package org.clb.LeetCode.code1_10;

import java.util.HashMap;
import java.util.Map;

/**
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 */
public class Code_1079 {





    public static int numTilePossibilities(String tiles) {

        return 1;
    }
    public int numTilePossibilitiesT(String tiles) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : tiles.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        return backtrack(freq);
    }

    private int backtrack(Map<Character, Integer> freq) {
        int res = 0;
        for (char letter : freq.keySet()) {
            if (freq.get(letter) > 0) {
                freq.put(letter, freq.get(letter) - 1); // 选择当前字母
                res += 1 + backtrack(freq); // 回溯计算
                freq.put(letter, freq.get(letter) + 1); // 撤销选择
            }
        }
        return res;
    }
}
