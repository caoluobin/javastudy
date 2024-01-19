package org.clb.LeetCode.code1_10;

import org.clb.LeetCode.entity.ListNode;

public class Code_2807 {

    public static void main(String[] args) {
        Code_2807 code = new Code_2807();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        System.out.println(code.gcd(6, 22));
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode now = head;
        while (now.next != null) {
            ListNode next =now.next;
            int nowV = now.val;
            int nextV = next.val;
            ListNode tmp = new ListNode(gcd(nowV,nextV), next);
            now.next = tmp;
            now=next;
        }

        return head;
    }

    public int gcd (int a,int b){
        if(a==0||b==0) return 1;
        if(a==b) return a;
        if(a>b) return a%b==0?b:gcd(a%b,b);
        return b%a==0?a:gcd(a,b%a);
    }
}
