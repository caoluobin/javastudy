package org.clb.LeetCode.code1_10;

import java.util.Arrays;

/**
 * 有 n 个人排成一个队列，从左到右 编号为 0 到 n - 1 。给你以一个整数数组 heights ，每个整数 互不相同，heights[i] 表示第 i 个人的高度。
 * 一个人能 看到 他右边另一个人的条件是这两人之间的所有人都比他们两人 矮 。更正式的，第 i 个人能看到第 j 个人的条件是 i < j
 * 且 min(heights[i], heights[j]) > max(heights[i+1], heights[i+2], ..., heights[j-1]) 。
 * 请你返回一个长度为 n 的数组 answer ，其中 answer[i] 是第 i 个人在他右侧队列中能 看到 的 人数 。
 */
public class Code_1944 {

    public static void main(String[] args) {
        Code_1944 code = new Code_1944();
        //2 2 2 10 2
        int[] arr = {2, 2, 2, 10, 2};
        print(code.canSeePersonsCount(arr));
        print(code.canSeePersonsCount2(arr));
//        randomTest();
    }
    public static void randomTest() {
        Code_1944 code = new Code_1944();
        for (int i = 0; i < 1000; i++) {
            //随机生成输入比较测试如果返回值不一样则打印
            int[] arr = new int[(int) (Math.random() * 5) + 1];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = (int) (Math.random() * 10) + 1;
            }
            int[] res1 = code.canSeePersonsCount(arr);
            int[] res2 = code.canSeePersonsCount2(arr);
            if (!Arrays.equals(res1, res2)) {
                print(arr);
                print(res1);
                print(res2);
                break;
            }
        }
    }
    public static void print(int[] arr){
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        for (int i = 0; i < n;) {
            i = dfs(res,heights,i,i+1);

        }
        return res;
    }

    /**
     * 处理start位置的数据 从index开始 并返回对应的下一个位置
     * @param res
     * @param heights
     * @param start
     * @param index
     * @return
     */
    private int dfs(int[] res, int[] heights, int start, int index) {
        if (index>=heights.length) {
            return index;
        }
        if (heights[index]>=heights[start]) {
            res[start]++;
            return index;
        } else {
            int next = dfs(res, heights, index , index + 1);
            res[start]++;
            return dfs(res, heights, start, next);
        }
    }


    public int[] canSeePersonsCount2(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int max =0;
            int count =0;
            for (int j = i+1; j < n; j++) {
                if (max>heights[i]) {
                    break;
                }
                if (heights[j]>max) {
                    count++;
                    max=heights[j];
                }
            }
            res[i]=count;
        }
        return res;
    }
}
