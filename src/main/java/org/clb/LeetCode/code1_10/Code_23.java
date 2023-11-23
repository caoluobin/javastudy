package org.clb.LeetCode.code1_10;

import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class Code_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode first = null;
        ListNode now = null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node!=null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            ListNode nowNode = queue.poll();
            if (first == null) {
                first = nowNode;
                now = first;
            } else {
                now .next = nowNode;
                now = nowNode;
            }
            if (nowNode.next!=null) {
                queue.add(nowNode.next);
            }
        }
        return first;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
