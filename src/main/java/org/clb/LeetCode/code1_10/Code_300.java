package org.clb.LeetCode.code1_10;

import java.util.*;

/**
 * ����һ���������� nums ���ҵ�������ϸ���������еĳ��ȡ�
 * ������ ���������������������У�ɾ������ɾ���������е�Ԫ��
 * �����ı�����Ԫ�ص�˳�����磬[3,6,2,7] ������ [0,3,1,6,2,2,7] �������С�
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
        // ʹ�����鱣�������� ��һ�����ִ������һλʱ�ں������  �����ҵ����ڵ����һ���ĳɵ�ǰֵ
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
