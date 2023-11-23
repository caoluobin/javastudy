package org.clb.LeetCode.code1_10;

public class Code_141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow!=null && fast!=null) {
            slow = slow.next;
            fast = fast.next;
            if (fast!=null) {
                fast=fast.next;
            } else {
                return false;
            }
            if (fast==slow) {
                return true;
            }
        }

        return false;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
