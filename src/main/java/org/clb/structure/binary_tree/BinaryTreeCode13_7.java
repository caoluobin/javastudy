package org.clb.structure.binary_tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.clb.pojo.list.BTreeNode;

/**
 * @Description �ж϶������Ƿ�����ȫ������
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


    /*1.���� ���� ��ߵ����Ҹ�
     * 2.���� ���� ��ߵ����Ҹ�+1
     * 3. ���� ���� ��ߵ����Ҹ�+1
     * 4.���� ���� ��ߵ����Ҹ�
     * */

    @Data
    @AllArgsConstructor
    private static class Info {
        public boolean isFull;
        public boolean isComplete;
        public int height;
    }
}
