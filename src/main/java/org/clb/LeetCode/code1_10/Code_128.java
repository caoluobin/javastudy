package org.clb.LeetCode.code1_10;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class Code_128 {

    public static void main(String[] args) {
//        System.out.println(Code_128.longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}));
    }

    public   int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length>1000) {
            return longestConsecutive2(nums);
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return dealSet(set,0);
    }

    public  int dealSet(Set<Integer> set,int max) {
        if (set.isEmpty()) return max;
        int start = 0;
        int count = 1;
        for (Integer integer : set) {
            start = integer;
            set.remove(start);
            break;
        }
        int de = 1;
        int ad = 1;
        while (true) {
            if (set.contains(start + ad)) {
                set.remove(start + ad);
                count++;
                ad++;
            } else if (set.contains(start - de)) {
                set.remove(start - de);
                count++;
                de++;
            } else {
                break;
            }
        }
        return dealSet(set,Math.max(max,count));
    }

    /**
     * 111 4  1 4
     *
     * @param nums
     * @return
     */
    public  int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        Integer[] ints = new Integer[max - min + 1];
        for (int num : nums) {
            ints[num - min] = num;
        }
        int res = 0;
        int count = 1;
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] == null) {
                if (ints[i - 1] != null) {
                    res = Math.max(res, count);
                    count = 0;
                }
            } else {
                count++;
            }
        }
        return Math.max(res, count);
    }
}
