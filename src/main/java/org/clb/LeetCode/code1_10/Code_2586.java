package org.clb.LeetCode.code1_10;

import java.util.HashSet;
import java.util.Set;

public class Code_2586 {
    private static Set<Character> set =new HashSet(){
        {
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }
    };
    public int vowelStrings(String[] words, int left, int right) {
        int count =0;
        for(int i=left;i<=right;i++) {
            String word = words[i];
            if(set.contains(word.charAt(0))&&set.contains(word.charAt(word.length()-1))){
                count++;
            }
        }
        return count;
    }
}
