package org.clb.LeetCode.code1_10;

public class Code14 {


    public String longestCommonPrefix(String[] strs) {
        StringBuilder str = new StringBuilder();
        String common = "";
        for (int i = 0; i < strs.length; i++) {
            if (i==0){
                common =strs[0];
            } else {
                common = getCommon(common,strs[i]);
            }

        }
        return common;
    }
    public String getCommon(String a,String b) {
        int minlength = Math.min(a.length(),b.length());
        int i = 0;
        for (; i < minlength; i++) {
            if (!a.substring(i,i+1).equals(b.substring(i,i+1))) {
                break;
            }
        }
        return a.substring(0,i);
    }
}
