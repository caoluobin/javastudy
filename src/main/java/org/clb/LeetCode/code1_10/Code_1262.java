package org.clb.LeetCode.code1_10;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ���������ܱ�3���������������
 */
public class Code_1262 {
    public static void main(String[] args) {

        System.out.println(maxSumDivThree2(new int[]{1,2,3,4,4}));
    }

    /**
     * ̰��
     *
     * @param nums ����
     * @return
     */
    public static int maxSumDivThree2(int[] nums) {
        PriorityQueue<Integer> queue1 = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (num % 3 == 1) {
                if (queue1.size() < 2) {
                    queue1.add(num);
                } else if (queue1.peek() > num) {
                    queue1.poll();
                    queue1.add(num);
                }

            }
            if (num % 3 == 2) {
                if (queue2.size() < 2) {
                    queue2.add(num);
                } else if (queue2.peek() > num) {
                    queue2.poll();
                    queue2.add(num);
                }
            }
        }
        if (sum % 3 == 1) {
            if (queue1.size()>1)
                queue1.poll();
            return queue1.peek() == null && queue2.size() < 2 ? 0 : queue1.peek() == null ? sum - queue2.poll() - queue2.poll() : queue2.size() < 2 ? sum - queue1.peek() : sum - Math.min(queue1.peek(), queue2.poll() + queue2.poll());
        }
        if (sum % 3 == 2) {
            if (queue2.size()>1)
                queue2.poll();
            return queue2.peek() == null && queue1.size() < 2 ? 0 : queue2.peek() == null ? sum - queue1.poll() - queue1.poll() : queue1.size() < 2 ? sum - queue2.peek() : sum - Math.min(queue2.peek(), queue1.poll() + queue1.poll());
        }
        return sum;
    }

    public static int secondMin(int a, int b, int c) {
        // ȡ��Сֵ
        int min = Math.min(Math.min(a, b), c);
        // ȡ��Сֵ
        int secondMin = Integer.MAX_VALUE;
        if (a > min && a < secondMin) {
            secondMin = a;
        }
        if (b > min && b < secondMin) {
            secondMin = b;
        }
        if (c > min && c < secondMin) {
            secondMin = c;
        }
        return secondMin;
    }


    /**
     * ��̬�滮
     *
     * @param nums
     * @return
     */
    public static int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][3];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1); // -1 ��ʾû�м����
        return dfs(memo, nums, n - 1, 0);
    }

    /**
     * @param memo
     * @param nums
     * @param i    ��i��Ԫ��ѡ��ѡ
     * @param j    ����
     * @return
     */

    private static int dfs(int[][] memo, int[] nums, int i, int j) {
        if (i < 0) {
            return j == 0 ? 0 : Integer.MIN_VALUE;
        }
        if (memo[i][j] != -1) {
            return memo[i][j]; // ֮ǰ�����
        }
        return memo[i][j] = Math.max(dfs(memo, nums, i - 1, j),
                dfs(memo, nums, i - 1, (j + nums[i]) % 3) + nums[i]);
    }


}
