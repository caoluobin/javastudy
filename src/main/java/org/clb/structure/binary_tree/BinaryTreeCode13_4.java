package org.clb.structure.binary_tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.clb.pojo.list.BTreeNode;

/**
 * @Description 给定一颗二叉树的头结点x, 任何两个节点之间都存在距离, 返回整颗二叉树的最大距离
 * @Classname BinaryTreeCode13_1
 * @Date 2021/11/21 13:34
 * @Author clb
 */
public class BinaryTreeCode13_4 {
    public static int getMaxDis(BTreeNode head) {
        return process(head).maxDis;
    }

    public static Info process(BTreeNode x) {
        if (x == null) return new Info(-1, -1);
        Info left = process(x.left);
        Info right = process(x.right);
        int max = 0;
        int height = Math.max(left.height + 1, right.height + 1);
        max = Math.max(left.maxDis, right.maxDis);
        max = Math.max(max, left.height + right.height + 2);
        return new Info(height, max);
    }

    public static void main(String[] args) {
        int count = 0;
//        for (int i = 0; i < 1000; i++) {
//
//            System.out.println(getMaxDis(BTreeUtil.generateBTree()));
//        }
//        System.out.println(count);
        System.out.println(getMaxDis(BTreeUtil.getBTreeNode1_10()));

    }

    /**
     * @param
     * @description: 条件1.左子树的最大值小于当前节点 2.右子树的最小值大于当前节点
     * @return:
     */
    @Data
    @AllArgsConstructor
    public static class Info {
        public int height;
        public int maxDis;
    }
}
