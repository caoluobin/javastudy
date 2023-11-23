package org.clb.structure.string;

import java.util.HashMap;

/**
 * @Description 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @Classname StringCodeO1
 * @Date 2021/5/18 8:52
 * @Author clb
 */
public class StringCodeO1 {
    public static int count(String s) {
        int start = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], i);
                max = Math.max(max, i - start + 1);
            } else {
                start = Math.max(start, map.get(chars[i]) + 1);
                max = Math.max(max, i - start + 1);
                map.put(chars[i], i);
            }
        }
        //    max=Math.max(max,count);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abbcdefbcs"));
    }

    /*
    abbcdefbcs
     */
    public static int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0; //记录最大值
        int start = 0; // 窗口开始位置
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);//以ASCII值存储
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }
}
