package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.List;

public class Code_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int[] select =new int[nums.length];
        dfs(list,nums,0,new ArrayList<>(),select);
        return list;
    }

    private void dfs(List<List<Integer>> list, int[] nums, int count,List<Integer> addList,int[] select ) {
        if (count==nums.length) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (select[i]==1) {
                continue;
            }
            List<Integer> add2List= new ArrayList<>();
            add2List.addAll(addList);
            add2List.add(nums[i]);
            select[i]=1;
            dfs(list,nums,count+1,add2List,select);
            select[i]=0;
            if (count==nums.length-1) {
                list.add(add2List);
            }
        }
    }
}
