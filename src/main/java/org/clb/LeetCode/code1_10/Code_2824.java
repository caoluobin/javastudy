package org.clb.LeetCode.code1_10;

import java.util.List;

public class Code_2824 {

    public int countPairs(List<Integer> nums, int target) {
        if (nums.size()==1) {
            return 0;
        }
        nums.sort(Integer::compareTo);
        int count =0;
        for (int i = 0; i < nums.size()-1; i++) {
            for (int j = i+1; j < nums.size(); j++) {
                if (nums.get(i)+nums.get(j)<target) {
                    count++;
                } else {
                    break;
                }
            }
            if (nums.get(i)+nums.get(i+1)>=target) {
                break;
            }
        }
        return count;

    }
}
