package org.clb.LeetCode.code1_10;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_2560 {

    public static void main(String[] args) {
        int[] nums ={1,2,3,2,5,6};
        Code_2560 code = new Code_2560();
        System.out.println(code.minCapability(nums,2));
    }
    public int minCapability(int[] nums, int k) {
        int left = 0, right = 0;
        //找到最大值
        for (int x : nums) {
            right = Math.max(right, x);
        }

        while (left + 1 < right) { // 开区间写法
            int mid = (left + right) >>> 1;
            if (check(nums, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int[] nums, int k, int mx) {
        int f0 = 0, f1 = 0;
        for (int x : nums) {
            if (x > mx) {
                f0 = f1;
            } else {
                int tmp = f1;
                f1 = Math.max(f1, f0 + 1);
                f0 = tmp;
            }
        }
        return f1 >= k;
    }
}
