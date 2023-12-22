package org.clb.LeetCode.code1_10;

public class Code_543 {

    public int diameterOfBinaryTree(TreeNode root) {

        return process(root).distance;
    }

    private Result process(TreeNode root) {
        if (root==null||(root.left==null&&root.right==null)) {
            return new Result(0,0,0);
        }
        Result left = process(root.left);
        Result right = process(root.right);
        int leftDeep = Math.max(left.leftDeep,left.rightDeep);
        int rightDeep = Math.max(right.leftDeep,right.rightDeep);
        if (root.left!=null) {
            leftDeep++;
        }
        if (root.right!=null) {
            rightDeep++;
        }
        return new Result(leftDeep,rightDeep,Math.max(Math.max(left.distance,right.distance),leftDeep+rightDeep));
    }

    private class Result{
        int leftDeep;
        int rightDeep;
        int distance;

        public Result(int leftDeep, int rightDeep, int distance) {
            this.leftDeep = leftDeep;
            this.rightDeep = rightDeep;
            this.distance = distance;
        }
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
