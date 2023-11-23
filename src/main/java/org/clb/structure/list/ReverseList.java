package org.clb.structure.list;

import org.clb.pojo.list.Node;

/**
 * 将链表反转
 */
public class ReverseList {
    public static Node reverseMyListByIterate(Node head){
        Node next,pre=null;
        while (head.getNext()!=null){
            next=head.getNext();
            head.setNext(pre);
            pre=head;
            head=next;
        }
        return pre;
    }
    public static Node create(){
        Node now=new Node("1");
        Node first=now;
        first.setName(0+"");
        for (int i = 1; i < 9; i++) {
            Node next=new Node(i+"");
            now.setNext(next);
            now.setName(i+"");
            now=next;
        }
        return first;
    }
    public static void iterate(Node node){
        while (true){
            System.out.println(node.getName());
            if (node.getNext()==null)break;
            node=node.getNext();
        }
    }
    public static void main(String[] args) {
        Node node=reverseMyListByIterate(create());
    }
}
