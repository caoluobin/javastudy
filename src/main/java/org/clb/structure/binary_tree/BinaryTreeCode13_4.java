package org.clb.structure.binary_tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.clb.pojo.list.BTreeNode;

/**
 * @Description ����һ�Ŷ�������ͷ���x, �κ������ڵ�֮�䶼���ھ���, �������Ŷ�������������
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
     * @description: ����1.�����������ֵС�ڵ�ǰ�ڵ� 2.����������Сֵ���ڵ�ǰ�ڵ�
     * @return:
     */
    @Data
    @AllArgsConstructor
    public static class Info {
        public int height;
        public int maxDis;
    }
}
