package org.clb.LeetCode.code1_10;

/**
 * 是否回文链表
 */
public class Code_234 {
    public static void main(String[] args) {
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(2,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        Code_234 code = new Code_234();
        code.isPalindrome(node1);
    }

    public boolean isPalindrome(ListNode head) {
        if (head.next ==null) {
            return true;
        }
        ListNode slow =head;
        ListNode speed = head;
        int count = 1;
        while (speed.next!=null) {// 1 2 2 1
            slow = slow.next;
            speed = speed.next;
            count++;
            if (speed.next!=null) {
                speed = speed.next;
                count++;
            }
        }
        ListNode right = count%2==1?slow.next:slow;
        ListNode left =reverseList(head, slow);
        while (right!=null) {
            if (right.val!=left.val) {
                return false;
            } else {
                right =right.next;
                left =left.next;
            }
        }
        return true;
    }
    public ListNode reverseList(ListNode head,ListNode endHead) {

        // 1  2->3
        // null<- 1 <- 2<-3
        ListNode tem;//null
        ListNode last = null;//2
        while (head!= null) {//3
            if (endHead.equals(head)) {
                break;
            }
            tem = head.next;
            head.next =last;
            last = head;
            head = tem;
        }
        return last;

    }
    private static   class ListNode {
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
