package org.clb.structure.binary_tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.clb.pojo.list.BTreeNode;

/**
 * @Description ����һ�Ŷ�������ͷ���x, ��ȡ����������Ϊ�����������������Ľڵ���
 * @Classname BinaryTreeCode13_1
 * @Date 2021/11/21 13:34
 * @Author clb
 */
public class BinaryTreeCode13_6 {
    public static int isFull(BTreeNode head) {
        return 1;
    }

    public static Info process(BTreeNode x) {
        if (x == null) return null;
        Info left = process(x.left);
        Info right = process(x.right);
        boolean isBST = false;

        return null;
    }

    public static void main(String[] args) {
        System.out.println(isFull(BTreeUtil.getBTreeNode1_10()));

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
