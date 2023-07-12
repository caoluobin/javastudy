package org.clb.LeetCode.code1_10;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 */
public class Code_11 {

    public static void main(String[] args) {
        //生成随机数组对maxArea和maxArea2的返回结果进行测试 如果不一致输出
        for (int i = 0; i < 100; i++) {
            int[] ints = generateRandomArray(100, 100);
            int maxArea = new Code_11().maxArea(ints);
            int maxArea2 = new Code_11().maxArea2(ints);
            if (maxArea!=maxArea2) {
                System.out.println("maxArea = " + maxArea);
                System.out.println("maxArea2 = " + maxArea2);
                System.out.println("ints = " + ints);
                break;
            }
        }
    }

    /**
     * 生成随机数组
     * @param length 数组长度
     * @param max 数组元素最大值
     * @return
     */
    private static int[] generateRandomArray(int length, int max) {
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = (int) (Math.random() * max);
        }
        return ints;
    }
    /**
     * 双指针 从两边向中间移动 移动短的那一边 因为移动长的那一边不可能使面积增大 只有移动短的那一边才有可能使面积增大 但是移动短的那一边也不一定能使面积增大 所以移动短的那一边
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left<right){
            max = Math.max(max,Math.min(height[left],height[right])*(right-left));
            if (height[left]<height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left<right){
            max = Math.max(max,Math.min(height[left],height[right])*(right-left));
            if (height[left]<height[right]) {
                int now = height[left];
                do {
                    left++;
                } while (now>=height[left]&&left<right);
            }else {
                int now = height[right];
                do {
                    right--;
                } while (height[right]<=now&&left<right);
            }
        }
        return max;
    }
    public int maxArea3(int[] height) {
        int max = 0;
        int heighta = 0;
        List<Area> areas = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, Math.min(height[0], height[i]) * (i));
            if (height[i] > heighta) {
                heighta = height[i];
                areas.add(new Area(i, height[i]));
            }
        }
        for (int i = 1; i < height.length; i++) {
            for (Area area : areas) {
                if (area.index < i) {
                    max = Math.max(max, Math.min(area.height, height[i]) * (i - area.index));
                }
            }

        }
        return max;
    }

    class Area {
        int index;
        int height;

        public Area(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}
