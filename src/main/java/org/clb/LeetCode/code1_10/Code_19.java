package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ������ɾ������ĵ����� n ����㣬���ҷ��������ͷ��㡣
 */
public class Code_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        List<ListNode> list = new ArrayList<>();
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        if (list.size() == 1) return null;
        if (n == list.size()) return head.next;
        ListNode listNode = list.get(list.size() - n - 1);
        listNode.next = n == list.size() ? null : listNode.next.next;
        return head;
    }

    public class ListNode {
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
