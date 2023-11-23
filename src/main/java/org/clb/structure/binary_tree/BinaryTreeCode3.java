package org.clb.structure.binary_tree;

import org.clb.pojo.list.BTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 按层遍历二叉树
 * @Classname BinaryTreeCode3
 * @Date 2021/9/16 22:20
 * @Author clb
 */
public class BinaryTreeCode3 {
    public static void levelTraverse(BTreeNode head){
        if (head==null||head.value==null)return;
        System.out.println(head.value);
        Queue<BTreeNode> queue=new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            BTreeNode node=queue.poll();
//            System.out.println(node.value);
            if (node.left!=null){
                System.out.println(node.left.value);
                queue.add(node.left);
            }
            if (node.right!=null){
                System.out.println(node.right.value);
                queue.add(node.right);
            }
        }

    }

    public static void main(String[] args) {
        levelTraverse(BTreeUtil.getBTreeNodeA_G());
    }
}
