package org.clb.structure.list;

import org.clb.pojo.list.DoubleNode;

/**
 * @Description 反转双向链表
 * @Classname ReverseDoubleList
 * @Date 2021/5/9 13:21
 * @Author clb
 */
public class ReverseDoubleList {
    public static DoubleNode reverseDoubleList(DoubleNode cur){
        DoubleNode pre=null;
        DoubleNode next;
        while (cur.next!=null){
            next=cur.next;
            cur.next=pre;
            cur.pre=next;
            pre=cur;
            cur=next;
        }
        cur.next=cur.pre;
        cur.pre=null;
        return  cur;
    }
    public static DoubleNode create(){
        DoubleNode node1=new DoubleNode(1,null);
        DoubleNode node2=new DoubleNode(2,node1);
        DoubleNode node3=new DoubleNode(3,node2);
        DoubleNode node4=new DoubleNode(4,node3);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=null;
        return node1;
    }
    public static void iterate(DoubleNode node){
        System.out.print(node.data+"  ");
        do{
            node=node.next;
            System.out.print(node.data+"  ");
        }while (node.next!=null);

    }

    public static void main(String[] args) {
        iterate(create());
        System.out.println();
        iterate(reverseDoubleList(create()));
    }
}
