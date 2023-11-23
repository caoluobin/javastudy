package org.clb.structure.list;

import org.apache.commons.lang3.StringUtils;
import org.clb.pojo.list.Node;
import org.clb.util.Asserts;

/**
 * @Description 给定一个可能有环也可能无环的, 返回第一个环节点或者null
 * @Classname ListCode04
 * @Date 2021/8/2 9:40
 * @Author clb
 */
public class ListCode4 {
    public static Node getFirstLoopNode(Node head) {
        if (head == null || !head.hashNext() || !head.getNext().hashNext()) return null;
        Node fast = head.getNext().getNext();
        Node slow = head.getNext();
        while (fast != slow) {
            if (fast == null || !fast.hashNext() || !fast.getNext().hashNext()) return null;
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        fast=head;
        while (fast!=slow){
            fast = fast.getNext();
            slow = slow.getNext();
        }
        return fast;
    }

    public static void main(String[] args) throws Exception {
        Node node1=new Node("1");
        Node node2=new Node("2");
        Node node3=new Node("3");
        Node node4=new Node("4");
        Node node5=new Node("5");
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
//        node5.setNext(node2);
        System.out.println(Asserts.objectNotNull2(getFirstLoopNode(node1))?getFirstLoopNode(node1).getName():"非环链表");
    }

}
