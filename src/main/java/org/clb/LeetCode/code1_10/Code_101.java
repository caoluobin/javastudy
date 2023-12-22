package org.clb.LeetCode.code1_10;

public class Code_101 {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left==null&&right==null) {
            return true;
        }
        if ((left==null)||(right==null)||(left.val!=right.val)) {
            return false;
        }
        if (!isSymmetric(left.left,right.right)||!isSymmetric(left.right,right.left)){
            return false;
        }
        return true;
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
