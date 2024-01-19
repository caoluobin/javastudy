package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Coe_78 {

    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(new Coe_78().subsets(nums));
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int[] select =new int[nums.length];
        list.add(new ArrayList<>());
        dfs(list,nums,0,new ArrayList<>(),select,0);
        return list;
    }

    private void dfs(List<List<Integer>> list, int[] nums, int count,List<Integer> addList,int[] select,int start) {
        if (count==nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (select[i]==1) {
                continue;
            }
            List<Integer> add2List= new ArrayList<>();
            add2List.addAll(addList);
            add2List.add(nums[i]);
            select[i]=1;
            dfs(list,nums,count+1,add2List,select,i+1);
            select[i]=0;
            list.add(add2List);
        }
    }
}
