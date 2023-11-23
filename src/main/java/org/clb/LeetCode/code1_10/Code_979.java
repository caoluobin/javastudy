package org.clb.LeetCode.code1_10;


/**
 * 给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。
 * 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。(移动可以是从父结点到子结点，或者从子结点移动到父结点。)。
 * 返回使每个结点上只有一枚硬币所需的移动次数。
 *     0
 *   1    0
 *  3  0 2 0
 *
 */
public class Code_979 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(0);
//        treeNode.left.left = new TreeNode(3);
//        treeNode.left.right = new TreeNode(0);
//        treeNode.right.left = new TreeNode(2);
//        treeNode.right.right = new TreeNode(0);
        System.out.println(new Code_979().distributeCoins(treeNode));
    }
    public int distributeCoins(TreeNode root) {

        return process(root)[2];

    }

    /**
     * 0:节点数 1:多余的硬币 2:移动次数
     * @param node
     * @return
     */
    private int[] process(TreeNode node) {
        if (node==null) {
            return new int[]{0,0,0};
        }
        if (node.left==null&&node.right==null) {
            return new int[]{1,node.val-1,0};
        }
        int[] left = process(node.left);//0 0 0
        int[] right = process(node.right);//1 2 0
        return new int[]{left[0]+right[0]+1,left[1]+right[1]+node.val-1,Math.abs(left[1])+Math.abs(right[1])+left[2]+right[2]};//2
    }

    public static class TreeNode {
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
