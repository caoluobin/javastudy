package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Code_42 {

    public int trap(int[] height) {
        int leftMaxIndex =0;
        List<Integer> maxList = new ArrayList<>();

        int last = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i]>last) {

            }
            if (height[i]==last) {

            }
            if (height[i]<last) {
                //如果大于等于leftMaxIndex的值 leftMaxIndex==i 结清左边的值
                //maxList加i
            }
        }
        return 0;

    }
}
