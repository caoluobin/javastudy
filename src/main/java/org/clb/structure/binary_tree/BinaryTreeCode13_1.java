package org.clb.structure.binary_tree;

import org.clb.pojo.list.BTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 是否是完全二叉树
 * @Classname BinaryTreeCode13_1
 * @Date 2021/11/21 13:34
 * @Author clb
 */
public class BinaryTreeCode13_1 {

    public static boolean isCompleteBinaryTree(BTreeNode head) {
        if (head == null) return true;
        Queue<BTreeNode> queue = new LinkedList<>();
        queue.add(head);
        BTreeNode l;
        BTreeNode r;
        //是否是叶节点
        boolean isleaf=false;
        while (!queue.isEmpty()){
            BTreeNode nowNode = queue.poll();
            l=nowNode.left;
            r=nowNode.right;
            if ((isleaf&&(l!=null||r!=null))||(l==null&&r!=null)){
                return false;
            }
            if (l!=null) queue.add(l);
            if (r!=null) queue.add(r);
            if (l==null||r==null) isleaf=true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isCompleteBinaryTree(BTreeUtil.getBTreeNodeA_G()));
        System.out.println(isCompleteBinaryTree(BTreeUtil.getNotCompleteBTreeNode()));
    }
}
