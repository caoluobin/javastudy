package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Code_102 {

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        process(root,result,0);
        return result;
    }

    private void process(TreeNode node, List<List<Integer>> result, Integer index) {
        if (node==null) {
            return;
        }
        if (result.size()<index+1) {
            result.add(new ArrayList<>());
        }
        List<Integer> list = result.get(index);
        list.add(node.val);
        process(node.left,result,index+1);
        process(node.right,result,index+1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<LevelNode> stack = new LinkedList<>();
        stack.add(new LevelNode(1, root));
        List<Integer> now = new ArrayList<>();
        int level = 1;
        while (!stack.isEmpty()) {
            LevelNode poll = stack.poll();
            if (level != poll.level) {
                result.add(now);
                now = new ArrayList<>();
                level = poll.level;
            }
            TreeNode node = poll.node;
            now.add(node.val);
            if (node.left != null) {
                stack.add(new LevelNode(level + 1, node.left));
            }
            if (node.right != null) {
                stack.add(new LevelNode(level + 1, node.right));
            }
        }
        result.add(now);
        return result;
    }

    private class LevelNode {
        int level;
        TreeNode node;

        public LevelNode(int level, TreeNode node) {
            this.level = level;
            this.node = node;
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
