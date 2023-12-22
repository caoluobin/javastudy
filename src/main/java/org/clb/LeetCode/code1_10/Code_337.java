package org.clb.LeetCode.code1_10;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Code_337 {

    private static AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) {
        //[1,null,4,3,null,null,2]
        TreeNode treeNode1 = new TreeNode(2, null, null);
        TreeNode treeNode2 = new TreeNode(3, null, treeNode1);
        TreeNode treeNode3 = new TreeNode(4, treeNode2, null);
        TreeNode treeNode = new TreeNode(1,null,treeNode3);
        Code_337 code = new Code_337();
        System.out.println(code.rob(treeNode));
        System.out.println(Runtime.getRuntime().availableProcessors());


    }
    public int rob(TreeNode root) {
        Map<TreeNode, Node> map = new HashMap<>();
        return dfs(root,false,map);
    }

    public int dfs(TreeNode root, boolean fatherSelect, Map<TreeNode, Node> map) {
        if (root == null) {
            return 0;
        }
        Node node = map.getOrDefault(root,new Node());
        int res = 0;
        if (fatherSelect) {
            if (node.noSelectNum == null) {
                node.noSelectNum = dfs(root.left, false, map) + dfs(root.right, false, map);
                count.addAndGet(1);
            }
            res = node.noSelectNum;
        } else {
            if (node.selectNum == null) {
                node.selectNum = dfs(root.left, true, map) + dfs(root.right, true, map) + root.val;
                count.addAndGet(1);
            }
            if (node.noSelectNum == null) {
                node.noSelectNum = dfs(root.left, false, map) + dfs(root.right, false, map);
                count.addAndGet(1);
            }
            res = Math.max(node.selectNum, node.noSelectNum);
        }
        return res;
    }

    public int rob2(TreeNode root) {
        Map<TreeNode, Node> map = new HashMap<>();
        Node node = dfs2(root, map);
        return Math.max(node.selectNum, node.noSelectNum);
    }

    public Node dfs2(TreeNode root, Map<TreeNode, Node> map) {
        if (root == null) {
            return new Node(0,0);
        }
        Node node = map.getOrDefault(root,new Node(0,0));
        Node node1 = dfs2(root.left, map);
        Node node2 = dfs2(root.right, map);
        count.addAndGet(1);
        node.selectNum = node1.noSelectNum+node2.noSelectNum+root.val;
        node.noSelectNum = Math.max(node1.selectNum,node1.noSelectNum)+Math.max(node2.selectNum,node2.noSelectNum);
        return node;
    }

    private class Node {
        Integer selectNum;
        Integer noSelectNum;

        public Node(Integer selectNum, Integer noSelectNum) {
            this.selectNum = selectNum;
            this.noSelectNum = noSelectNum;
        }

        public Node() {
        }
    }

    private static class TreeNode {
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
