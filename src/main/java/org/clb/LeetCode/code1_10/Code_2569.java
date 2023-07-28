package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你两个下标从 0 开始的数组 nums1 和 nums2 ，和一个二维数组 queries 表示一些操作。总共有 3 种类型的操作：
 * 操作类型 1 为 queries[i] = [1, l, r] 。你需要将 nums1 从下标 l 到下标 r 的所有 0 反转成 1 或将 1 反转成 0 。l 和 r 下标都从 0 开始。
 * 操作类型 2 为 queries[i] = [2, p, 0] 。对于 0 <= i < n 中的所有下标，令 nums2[i] = nums2[i] + nums1[i] * p 。
 * 操作类型 3 为 queries[i] = [3, 0, 0] 。求 nums2 中所有元素的和。
 * 请你返回一个数组，包含所有第三种操作类型的答案。
 */
public class Code_2569 {
    public static void main(String[] args) {

    }

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        List<Long> res = new ArrayList<>();
        long nums2Sum = Arrays.stream(nums2).mapToLong(a->a).sum();
        long nums1Sum = Arrays.stream(nums1).mapToLong(a->a).sum();
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (query[0] == 1) {
                for (int j = query[1]; j <= query[2]; j++) {
                    if (nums1[j] == 1) {
                        nums1[j] = 0;
                        nums1Sum--;
                    } else {
                        nums1[j] = 1;
                        nums1Sum++;
                    }

                }
            } else if (query[0] == 2) {
                nums2Sum += nums1Sum * query[1];
            } else {
                res.add(nums2Sum);
            }
        }
        return res.stream().mapToLong(Long::longValue).toArray();
    }
}
