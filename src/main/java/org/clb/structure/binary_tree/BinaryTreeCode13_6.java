package org.clb.structure.binary_tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.clb.pojo.list.BTreeNode;

/**
 * @Description 给定一颗二叉树的头结点x, 获取左右子树都为搜索二叉树的子树的节点数
 * @Classname BinaryTreeCode13_1
 * @Date 2021/11/21 13:34
 * @Author clb
 */
public class BinaryTreeCode13_6 {
    public static int getBstCount(BTreeNode head) {
        return process(head).count;
    }

    public static Info process(BTreeNode x) {
        if (x == null) return null;
        Info left = process(x.left);
        Info right = process(x.right);
        boolean isBST = true;
        int max = Integer.parseInt(x.value);
        int min = Integer.parseInt(x.value);
        int count = 0;
        if (left != null) {
            isBST = left.isBST && Integer.parseInt(x.value) > left.max;
            max = Math.max(max, left.max);
            min = Math.max(min, left.min);
            count += left.count;
        }
        if (right != null) {
            isBST = right.isBST && Integer.parseInt(x.value) < right.min && isBST;
            max = Math.max(max, right.max);
            min = Math.max(min, right.min);
            count += right.count;
        }
        if (isBST) count++;

        return new Info(isBST, max, min, count);
    }

    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            BTreeNode x = BTreeUtil.generateBTree();
            if (getBstCount(x) != getCount(x)) {
                count++;
            }
        }


    }

    public static int getCount(BTreeNode x) {
        if (x == null) return 0;
        int left = getCount(x.left);
        int right = getCount(x.right);
        boolean bst = BinaryTreeCode13_3.isBST(x);
        int a = bst ? 1 : 0;
        return left + right + a;
    }

    @Data
    @AllArgsConstructor
    private static class Info {
        public boolean isBST;
        public int max;
        public int min;
        public int count;
    }
}
