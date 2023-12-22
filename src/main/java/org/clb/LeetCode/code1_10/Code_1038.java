package org.clb.LeetCode.code1_10;

import org.clb.LeetCode.entity.TreeNode;

public class Code_1038 {

    public TreeNode bstToGst(TreeNode root) {
        int[] a = new int[1];
        process(root,a);
        return root;
    }

    private void process(TreeNode root,int[] a) {
        if (root == null) {
            return;
        }
        process(root.right,a);
        a[0]+= root.val;
        root.val=a[0];
        process(root.left,a);
    }

}
