package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.List;

public class Code_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        process(root,list);

        return list;
    }

    private void process(TreeNode root, List<Integer> list) {
        if (root ==null) {
            return;
        }
        process(root.left,list);
        list.add(root.val);
        process(root.right,list);

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
