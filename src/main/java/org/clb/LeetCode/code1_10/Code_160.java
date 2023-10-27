package org.clb.LeetCode.code1_10;

/**
 *
 */
public class Code_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int count = 0;
        while (a != null &&b != null) {
            a = a.next;
            b = b.next;
        }
        while (a!=null) {
            a=a.next;
            headA = headA.next;
        }
        while (b!=null) {
            b=b.next;

            headB = headB.next;
        }
        while (headA!=headB) {
            headA = headA.next;
            headB = headB.next;
            if (headA==null||headB==null) {
                return null;
            }
        }
        return headA;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
