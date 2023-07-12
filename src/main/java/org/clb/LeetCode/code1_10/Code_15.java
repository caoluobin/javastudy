package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;
            if (nums[i]+nums[i+1]+nums[i+2]>0){
                break;
            }
            while (left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    List<Integer> temp = new ArrayList<>();
                    int leftNum = nums[left];
                    int rightNum = nums[right];
                    temp.add(nums[i]);
                    temp.add(leftNum);
                    temp.add(rightNum);
                    result.add(temp);
                    left++;
                    right--;

                    while (left<right-1&&nums[left]==nums[left-1]) {
                        left++;
                    }

                    while (left<right-1&&nums[right]==nums[right+1])  {
                        right--;
                    }
                    if (left==right-1&&nums[left]==leftNum&&rightNum==nums[right]){
                        break;
                    }
                }else if(nums[i]+nums[left]+nums[right]>0){
                    right--;
                }else {
                    left++;
                }
            }
            while (i<nums.length-1&&nums[i]==nums[i+1]){
                i++;
            }
        }
        return result;
    }


}
