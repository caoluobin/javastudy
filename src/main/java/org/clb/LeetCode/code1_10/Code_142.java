package org.clb.LeetCode.code1_10;

public class Code_142 {

    public ListNode detectCycle(ListNode head) {
        // x  y
        // x y
        //2 x +2y
        ListNode a = new ListNode(1);
        a.next = head;
        ListNode slow = a;
        ListNode fast = a;
        boolean flag = false;
        do {
            slow = slow.next;
            fast = fast.next;
            if (fast!=null) {
                fast=fast.next;
            } else {
                return null;
            }
            if (fast==slow) {
                if (flag) {
                    return slow;
                }
                slow=head;
                flag = true;
            }
        } while (slow!=null && fast!=null);

        return null;
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
