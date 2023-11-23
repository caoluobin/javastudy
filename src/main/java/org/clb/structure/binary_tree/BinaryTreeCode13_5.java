package org.clb.structure.binary_tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.clb.pojo.list.BTreeNode;

/**
 * @Description 给定一颗二叉树的头结点x,判断该树是否是满二叉树
 * @Classname BinaryTreeCode13_1
 * @Date 2021/11/21 13:34
 * @Author clb
 */
public class BinaryTreeCode13_5 {
    public static boolean isFull(BTreeNode head) {
        return process(head).isFull;
    }

    public static Info process(BTreeNode x) {
        if (x==null) return null;
        Info left = process(x.left);
        Info right = process(x.right);
        boolean isFull=false;
        if (left!=null&&right!=null&&left.isFull&&right.isFull){
            isFull=true;
        }
        if (left==null&&right==null){
            isFull=true;
        }
        return new Info(isFull);
    }

    public static void main(String[] args) {
        System.out.println(isFull(BTreeUtil.getBTreeNode1_10()));

    }

    @Data
    @AllArgsConstructor
    private static class Info {
        public boolean isFull;

    }
}
