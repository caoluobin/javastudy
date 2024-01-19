package org.clb.LeetCode.code1_10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Code_2744 {

    public int maximumNumberOfStringPairs(String[] words) {
        int res = 0;
        Set<String> set = new HashSet<>();
        for (String word : words) {
            String reverse = new StringBuilder(word).reverse().toString();
            if (set.remove(reverse)) {
                res++;
            } else {
                set.add(word);
            }
        }
        return res;
    }
}
