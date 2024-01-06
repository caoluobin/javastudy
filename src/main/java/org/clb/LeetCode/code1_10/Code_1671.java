package org.clb.LeetCode.code1_10;


import java.util.ArrayList;
import java.util.List;

public class Code_1671 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getId());
        new Thread(()->{
            System.out.println(Thread.currentThread().getId());
        }).start();
    }
    public int minimumMountainRemovals(int[] nums) {
        int[] left = getLISArray(nums);
        int[] right = getLISArray(reverse(nums));
        int res =0;
        for(int i=1;i<nums.length-1;i++){
            if(left[i]==1||right[nums.length-i-1]==1) continue;
            res = Math.max(res,left[i]+right[nums.length-i-1]-1);
        }
        return nums.length-res;
    }
    public int[] getLISArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        //贪心 将尽可能小的数保存在数组中  如果大于所有数则加1  否则替换掉第一个大于它的数
        List<Integer> seq = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            //二分查找
            int index = binarySearch(seq, nums[i]);
            if (index == seq.size()) {
                seq.add(nums[i]);
                dp[i] = seq.size();
            } else {
                seq.set(index, nums[i]);
                dp[i] = index + 1;
            }
        }
        return dp;
    }

    public int[] reverse(int[] nums) {
        int n = nums.length;
        int[] reversed = new int[n];
        for (int i = 0; i < n; i++) {
            reversed[i] = nums[n - 1 - i];
        }
        return reversed;
    }

    public int binarySearch(List<Integer> seq, int target) {
        int low = 0, high = seq.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (seq.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
