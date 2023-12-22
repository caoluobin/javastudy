package org.clb.LeetCode.code1_10;

import org.clb.LeetCode.entity.TreeNode;

public class Code_98 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(32);
        TreeNode node1 = new TreeNode(26);
        root.left=node1;
        TreeNode left = new TreeNode(19);
        TreeNode right = new TreeNode(27);
        node1.left=left;
        left.right=right;
        //
        TreeNode node2 = new TreeNode(47);
        root.right = node2;
        Code_98 code = new Code_98();
        System.out.println(code.isValidBST(root));

    }
    public boolean isValidBST(TreeNode root) {
        return process(root).isBST;
    }

    private Validate process(TreeNode node) {
        if (node == null) {
            return null;
        }
        Validate left = process(node.left);
        Validate right = process(node.right);
        boolean isBST = true;
        if (left != null) {
            isBST = left.isBST && left.max < node.val;
        }
        if (right != null) {
            isBST =isBST&& right.isBST && node.val < right.min;
        }

        return new Validate(right == null ? node.val : right.max, left == null ? node.val : left.min, isBST);
    }

    private class Validate {
        private int max;
        private int min;
        private boolean isBST;

        public Validate(int max, int min, boolean isBST) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }
}
