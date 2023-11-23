package org.clb.structure.binary_tree;

import org.clb.pojo.list.BTreeNode;

import java.util.Stack;

/**
 * @Description 不用递归实现二叉树的先序、中序、后序遍历
 * @Classname BinaryTreeCode2
 * @Date 2021/8/5 9:27
 * @Author clb
 */
public class BinaryTreeCode2 extends BTreeUtil{
    public static void pre(BTreeNode head){
        if (head==null) return;
        Stack<BTreeNode> stack=new Stack<>();
        BTreeNode cur=head;
        while (stack.size()!=0||cur!=null){
            if (cur!=null) System.out.println(cur.value);
            if (cur.right!=null) stack.push(cur.right);
            if (cur.left!=null) stack.push(cur.left);
            cur=stack.size()==0?null:stack.pop();
        }
    }
    public static void mid(BTreeNode head){
        if (head==null) return;
        Stack<BTreeNode> stack=new Stack<>();
        BTreeNode cur=head;
        while (stack.size()!=0||cur!=null){
            //如果当前节点不会空的话
            if (cur!=null) {
                stack.push(cur);
                cur=cur.left;
            }else {
                cur = stack.pop();
                System.out.println(cur.value);
                cur=cur.right;
            }
        }
    }
    public static void pos(BTreeNode head){
        if (head==null) return;
        Stack<BTreeNode> stack=new Stack<>();
        Stack<BTreeNode> stack2=new Stack<>();
        BTreeNode cur=head;
        while (stack.size()!=0||cur!=null){
            if (cur!=null) stack2.push(cur);
            if (cur.left!=null) stack.push(cur.left);
            if (cur.right!=null) stack.push(cur.right);
            cur=stack.size()==0?null:stack.pop();
        }
        while (stack2.size()!=0){
            System.out.println(stack2.pop().value);
        }
    }

    public static void main(String[] args) {
        mid(getBTreeNodeA_G());
    }
}
