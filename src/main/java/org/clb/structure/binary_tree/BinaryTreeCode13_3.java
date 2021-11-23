package org.clb.structure.binary_tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.clb.pojo.list.BTreeNode;

/**
 * @Description �Ƿ�������������
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
        int max = 0;
        int min = 0;
        if (left != null && !left.isBST) {
            isBST = left.isBST;
            max = Math.max(left.max, Integer.parseInt(x.value));
            min = Math.max(left.min, Integer.parseInt(x.value));
        }
        if (right != null && !right.isBST) {
            isBST = right.isBST;
            max = Math.max(right.max, Integer.parseInt(x.value));
            min = Math.max(right.min, Integer.parseInt(x.value));
        }
        if (left != null && left.max >= Integer.parseInt(x.value)) {
            isBST = false;
        }
        if (right != null && right.max <= Integer.parseInt(x.value)) {
            isBST = false;
        }
        return new Info(isBST, max, min);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            if (isBST(BTreeUtil.generateBTree())) {
                System.out.println(true);
            }
        }
        System.out.println(isBST(BTreeUtil.getBTreeNode1_10()));

    }

    /**
     * @param
     * @description: ����1.�����������ֵС�ڵ�ǰ�ڵ� 2.����������Сֵ���ڵ�ǰ�ڵ�
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
