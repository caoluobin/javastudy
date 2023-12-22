package org.clb.LeetCode.code1_10;

import org.clb.LeetCode.entity.TreeNode;

public class Code_230 {
    public static void main(String[] args) {
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] a = new int[2];
        a[0]=k;
        process(root,a);
        return a[1];
    }

    private void process(TreeNode root, int[] a) {
        if (a[0]==0||root==null) {
            return;
        }
        process(root.left,a);
        if (a[0]==1) {
            a[0]=0;
            a[1]=root.val;
            return;
        }
        a[0]--;
        process(root.right,a);
    }
}
