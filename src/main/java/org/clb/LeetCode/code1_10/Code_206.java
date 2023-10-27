package org.clb.LeetCode.code1_10;

public class Code_206 {

    public ListNode reverseList(ListNode head) {

        // 1  2->3
        // null<- 1 <- 2<-3
        ListNode tem;//null
        ListNode last = null;//2
        while (head!= null) {//3
            tem = head.next;
            head.next =last;
            last = head;
            head = tem;
        }
        return last;

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
