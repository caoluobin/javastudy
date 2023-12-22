package org.clb.LeetCode.code1_10;

public class Code_226 {


    public TreeNode invertTree(TreeNode root) {
        process(root);
        return root;
    }

    private void process(TreeNode root) {
        if (root==null) {
            return;
        }
        TreeNode tmp =root.left;
        root.left = root.right;
        root.right = tmp;
        process(root.left);
        process(root.right);
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
