package org.clb.LeetCode.code1_10;

import java.util.HashMap;
import java.util.Map;

/**
 * ����һ�׻�����ģ tiles������ÿ����ģ�϶�����һ����ĸ tiles[i]�����������ӡ���ķǿ���ĸ���е���Ŀ��
 * ���룺"AAB"
 * �����8
 * ���ͣ����ܵ�����Ϊ "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"��
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
                freq.put(letter, freq.get(letter) - 1); // ѡ��ǰ��ĸ
                res += 1 + backtrack(freq); // ���ݼ���
                freq.put(letter, freq.get(letter) + 1); // ����ѡ��
            }
        }
        return res;
    }
}
