package org.clb.LeetCode.code1_10;


/**
 * ����һ���� N �����Ķ������ĸ���� root�����е�ÿ������϶���Ӧ�� node.val öӲ�ң������ܹ��� N öӲ�ҡ�
 * ��һ���ƶ��У����ǿ���ѡ���������ڵĽ�㣬Ȼ��һöӲ�Ҵ�����һ������ƶ�����һ����㡣(�ƶ������ǴӸ���㵽�ӽ�㣬���ߴ��ӽ���ƶ�������㡣)��
 * ����ʹÿ�������ֻ��һöӲ��������ƶ�������
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
     * 0:�ڵ��� 1:�����Ӳ�� 2:�ƶ�����
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
