package org.clb.structure.binary_tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.clb.pojo.list.BTreeNode;

/**
 * @Description 是否是搜索二叉树
 * @Classname BinaryTreeCode13_1
 * @Date 2021/11/21 13:34
 * @Author clb
 */
public class BinaryTreeCode13_3 {
    public static boolean isBST(BTreeNode head) {
        return process(head).isBST;
    }

    public static Info process(BTreeNode x) {
        if (x == null) {
            return null;
        }
        Info left = process(x.left);
        Info right = process(x.right);
        boolean isBST = true;
        int max = Integer.parseInt(x.value);
        int min = Integer.parseInt(x.value);
        if (left != null) {
            isBST = left.isBST;
            max = Math.max(left.max, max);
            min = Math.min(left.min, min);
        }
        if (right != null) {
            isBST = isBST && right.isBST;
            max = Math.max(right.max, max);
            min = Math.min(right.min, min);
        }
        if (left != null && left.max >= Integer.parseInt(x.value)) {
            isBST = false;
        }
        if (right != null && right.min <= Integer.parseInt(x.value)) {
            isBST = false;
        }
        return new Info(isBST, max, min);
    }

    public static void main(String[] args) {
//        int count = 0;
//        for (int i = 0; i < 1000; i++) {
//            if (isBST(BTreeUtil.generateBTree())) {
//                System.out.println(true);
//                System.out.println(i);
//                count++;
//            }
//        }
//        System.out.println(count);
        System.out.println(isBST(BTreeUtil.getBTreeNode1_10()));

    }

    /**
     * @param
     * @description: 条件1.左子树的最大值小于当前节点 2.右子树的最小值大于当前节点
     * @return:
     */
    @Data
    @AllArgsConstructor
    public static class Info {
        public boolean isBST;
        public int max;
        public int min;
    }
}
