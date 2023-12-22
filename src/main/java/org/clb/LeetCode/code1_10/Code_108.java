package org.clb.LeetCode.code1_10;

import org.clb.LeetCode.entity.TreeNode;

public class Code_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return process(nums,0,nums.length-1);
    }

    private TreeNode process(int[] nums, int left, int right) {
        if (left>right) {
            return null;
        }
        if (left==right) {
            return new TreeNode(nums[left]);
        }
        int mid = left+(right-left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = process(nums,left,mid-1);
        node.right = process(nums,mid+1,right);
        return node;
    }
}
