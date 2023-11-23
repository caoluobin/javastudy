package org.clb.LeetCode.code1_10;

public class Code_318 {
    public int maxProduct(String[] words) {
        int max = 0;
        int[] w = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            int a = 0;
            for (char aChar : chars) {
                a|=1<<(aChar-'a'+1);
            }
            w[i]=a;
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if ((w[i]&w[j])==0){
                    max =Math.max(max,words[i].length()*words[j].length());
                }

            }
        }
        return max;
    }

    public int maxProduct2(String[] words) {
        int[][]  a = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                int index = c -'a';
                a[i][index]++;
            }
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            to:
            for (int j = i; j < words.length; j++) {
                char[] chars = words[j].toCharArray();
                for (char aChar : chars) {
                    if (a[i][aChar-'a']!=0) {
                        continue to;
                    }
                }
                max = Math.max(max,words[i].length()*chars.length);
            }
        }
        return max;
    }

}
