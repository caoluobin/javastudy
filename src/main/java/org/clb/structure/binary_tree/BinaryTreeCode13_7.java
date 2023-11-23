package org.clb.structure.binary_tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.clb.pojo.list.BTreeNode;

/**
 * @Description 判断二叉树是否是完全二叉树
 * @Classname BinaryTreeCode13_1
 * @Date 2021/11/21 13:34
 * @Author clb
 */
public class BinaryTreeCode13_7 {
    public static boolean isComplete(BTreeNode head) {
        return process(head).isComplete;
    }

    public static Info process(BTreeNode x) {
        if (x == null) return new Info(true, true, 0);
        Info left = process(x.left);
        Info right = process(x.right);
        boolean isFull = false;
        boolean isComplete = false;
        int height = 0;
        if (left.isFull && right.isFull && left.height == right.height) {
            isFull = true;
            isComplete = true;
        }
        if (left.isFull && right.isComplete && left.height == right.height) {
            isComplete = true;
        }
        if (left.isComplete && right.isFull && left.height == right.height + 1) {
            isComplete = true;
        }
        if (left.isFull && right.isFull && left.height == right.height + 1) {
            isComplete = true;
        }
        height = Math.max(left.height, right.height) + 1;
        return new Info(isFull, isComplete, height);
    }

    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 10000; i++) {
            BTreeNode x = BTreeUtil.generateBTree();
            if (isComplete(x) != BinaryTreeCode13_1.isCompleteBinaryTree(x)) {
                count++;

            }
        }
        System.out.println(count);
    }


    /*1.左满 右满 左高等于右高
     * 2.左完 右满 左高等于右高+1
     * 3. 左满 右满 左高等于右高+1
     * 4.左满 右完 左高等于右高
     * */

    @Data
    @AllArgsConstructor
    private static class Info {
        public boolean isFull;
        public boolean isComplete;
        public int height;
    }
}
