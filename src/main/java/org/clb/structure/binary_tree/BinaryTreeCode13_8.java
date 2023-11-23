package org.clb.structure.binary_tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.clb.pojo.list.BTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 给定一颗二叉树的头结点head，返回这颗二叉树中最大的二叉搜索子树的头结点
 * @Classname BinaryTreeCode13_1
 * @Date 2021/11/21 13:34
 * @Author clb
 */
public class BinaryTreeCode13_8 {
    public static int getBstMaxNodeCount(BTreeNode head) {
        return process(head).count;
    }

    public static Info process(BTreeNode x) {
        if (x == null) return null;
        Info left = process(x.left);
        Info right = process(x.right);
        boolean isBST = false;
        int count = 0;
        int max = Integer.parseInt(x.value);
        int min = Integer.parseInt(x.value);
        if (left != null && right == null) {
            isBST = left.isBST && left.max < Integer.parseInt(x.value);
            max = Math.max(max, left.max);
            min = Math.min(min, left.min);
            count = isBST ? left.count + 1 : left.count;
        }
        if (right != null && left == null) {
            isBST = right.isBST && right.min > Integer.parseInt(x.value);
            max = Math.max(max, right.max);
            min = Math.min(min, right.min);
            count = isBST ? right.count + 1 : right.count;
        }
        if (left != null && right != null) {
            isBST = left.isBST && right.isBST && left.max < Integer.parseInt(x.value) && right.min > Integer.parseInt(x.value);
            count = isBST ? left.count + right.count + 1 : Math.max(left.count, right.count);
            max = Math.max(Math.max(left.max, right.max), Integer.parseInt(x.value));
            min = Math.min(Math.min(left.min, right.min), Integer.parseInt(x.value));
        }
        if (left == null && right == null) {
            isBST = true;
            count = 1;
        }
//        else if (left != null && right == null && left.max < Integer.parseInt(x.value)) {
//            isBST = true;
//            count = left.count + 1;
//        } else if (right != null && left == null && right.min > Integer.parseInt(x.value)) {
//            isBST = true;
//            count = right.count + 1;
//        }
        return new Info(isBST, count, max, min);
    }

    public static int getBstMaxNodeCount2(BTreeNode x) {
        int count = 0;
        Queue<BTreeNode> queue = new LinkedList<>();
        queue.add(x);
        while (!queue.isEmpty()) {
            BTreeNode now = queue.poll();
            if (BinaryTreeCode13_3.isBST(now)) {
                count = Math.max(count, getCount(now));
            }
            if (now.left != null) {
                ((LinkedList<BTreeNode>) queue).add(now.left);
            }
            if (now.right != null) {
                ((LinkedList<BTreeNode>) queue).add(now.right);
            }
        }
        return count;
    }

    public static int getCount(BTreeNode x) {
        Queue<BTreeNode> queue = new LinkedList<>();
        int count = 0;
        queue.add(x);
        while (!queue.isEmpty()) {
            BTreeNode now = queue.poll();
            count++;
            if (now.left != null) {
                ((LinkedList<BTreeNode>) queue).add(now.left);
            }
            if (now.right != null) {
                ((LinkedList<BTreeNode>) queue).add(now.right);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 10000; i++) {
            BTreeNode x = BTreeUtil.generateBTree();
            if (getBstMaxNodeCount(x) != getBstMaxNodeCount2(x)) {
                getBstMaxNodeCount2(x);
                count++;
            }
        }
        System.out.println(count);
        System.out.println(getBstMaxNodeCount(BTreeUtil.getBTreeNode1_10()));
        System.out.println(getBstMaxNodeCount2(BTreeUtil.getBTreeNode1_10()));
    }


    @Data
    @AllArgsConstructor
    private static class Info {
        public boolean isBST;
        public int count;
        public int max;
        public int min;

    }
}
