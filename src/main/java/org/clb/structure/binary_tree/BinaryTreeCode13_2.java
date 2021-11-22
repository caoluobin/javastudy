package org.clb.structure.binary_tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.clb.pojo.list.BTreeNode;

/**
 * @Description �Ƿ���ƽ�������
 * @Classname BinaryTreeCode13_1
 * @Date 2021/11/21 13:34
 * @Author clb
 */
public class BinaryTreeCode13_2 {
    public static boolean isBalanceTree(BTreeNode head) {
        return process(head).isBalanceTree;
    }

    public static Info process(BTreeNode head) {
        if (head == null) return new Info(true, 0);
        process(head.left);
        process(head.right);
        boolean isBalance = true;
        int height = 0;
        // ���㵱ǰ�ڵ�ĸ߶�
        height = Math.max(process(head.left).getHeight(), process(head.right).getHeight());
        // �жϵ�ǰ�ڵ��Ƿ���ƽ�������
        if (!process(head.left).isBalanceTree
                || !process(head.right).isBalanceTree
                || Math.abs(process(head.left).getHeight() - process(head.right).getHeight()) > 1) {
            isBalance = false;
        }
        return new Info(isBalance, height);
    }

    public static void main(String[] args) {
        System.out.println(isBalanceTree(BTreeUtil.getNotCompleteBTreeNode()));
        System.out.println(isBalanceTree(BTreeUtil.getBTreeNodeA_G()));
    }

    @Data
    @AllArgsConstructor
    static class Info {
        public boolean isBalanceTree;
        public int height;
    }


}
