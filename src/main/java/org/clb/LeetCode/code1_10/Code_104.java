package org.clb.LeetCode.code1_10;

public class Code_104 {

    public int maxDepth(TreeNode root) {
        return process(root);
    }

    private int process(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int left = process(root.left);
        int right = process(root.right);
        return Math.max(left,right)+1;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
