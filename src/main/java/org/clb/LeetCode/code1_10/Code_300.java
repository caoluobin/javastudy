package org.clb.LeetCode.code1_10;

import java.util.*;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素
 * 而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class Code_300 {
    public static void main(String[] args) {

        Code_300 code = new Code_300();
        System.out.println(code.lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }

    public int lengthOfLIS(int[] nums) {

        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> {
            if (Objects.equals(a.count, b.count)) {
                return b.value.compareTo(a.value);
            }
            return b.count.compareTo(a.count);
        });
        for (int i = 0; i < nums.length; i++) {
            int now = nums[i];
            int count = 1; // 1  3 4 5  1 2 3
            List<Node> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                list.add(node);
                if (node.value < now) {
                    count = Math.max(count, node.count + 1);
                    break;
                } else if (node.value == now) {
                    count = Math.max(count, node.count);
                }
            }
            queue.addAll(list);
            queue.add(new Node(now, count));
        }
        return queue.peek().count;
    }
    public int lengthOfLIS2(int[] nums) {
        // 使用数组保存子序列 但一个数字大于最后一位时在后面插入  否则找到大于的最后一个改成当前值
        return 0;
    }
    private static class Node {
        Integer value;
        Integer count;

        public Node(Integer value, Integer count) {
            this.value = value;
            this.count = count;
        }

        public Integer getValue() {
            return value;
        }
    }

}
