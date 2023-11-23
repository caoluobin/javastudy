package org.clb.structure.binary_tree;

import org.clb.pojo.list.BTreeNode;

/**
 * @Description 二叉树利用递归完成先序、中序、后序遍历
 * @Classname BinaryTreeCode1
 * @Date 2021/8/5 9:16
 * @Author clb
 */
public class BinaryTreeCode1 extends BTreeUtil {

    public static void pre(BTreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value);
        pre(head.left);
        pre(head.right);
    }

    public static void mid(BTreeNode head) {
        if (head == null) {
            return;
        }
        pre(head.left);
        System.out.print(head.value);
        pre(head.right);
    }

    public static void pos(BTreeNode head) {
        if (head == null) {
            return;
        }
        pre(head.left);
        pre(head.right);
        System.out.print(head.value);
    }


    public static void main(String[] args) {
        BTreeNode head = getBTreeNodeA_G();
        mid(head);

    }
}
