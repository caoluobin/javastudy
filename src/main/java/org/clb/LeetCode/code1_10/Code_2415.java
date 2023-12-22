package org.clb.LeetCode.code1_10;

import org.clb.LeetCode.entity.TreeNode;

import java.util.*;

public class Code_2415 {
    public TreeNode reverseOddLevels3(TreeNode root) {
        Map<Integer,TreeNode> map = new HashMap<>();
        int index = 0;
        int start = 2;
        int end = 3;
        int mid = start+(end-start+1)/2;
        map.put(0,root);
        while (index<map.size()) {
            TreeNode fa = map.get(index);
            index++;
            //先添加
            if (fa.left != null) {
                map.put(index*2-1,fa.left);
            }
            if (fa.right != null) {
                map.put(index*2,fa.right);
            }
            //处理数据
            if (index >= mid && index <= end) {
                TreeNode ot = map.get(end - (index - start) - 1);
                int tem = ot.val;
                ot.val=fa.val;
                fa.val=tem;
                if (index == end) {
                    start = start * 4;
                    end = start * 2 - 1;
                    mid = start+(end-start+1)/2;
                }
            }
        }
        return root;
    }
    public TreeNode reverseOddLevels2(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        int index = 0;
        int start = 2;
        int end = 3;
        int mid = start+(end-start+1)/2;
        list.add(root);
        while (index<list.size()) {
            TreeNode fa = list.get(index);
            index++;
            //先添加
            if (fa.left != null) {
                list.add(fa.left);
            }
            if (fa.right != null) {
                list.add(fa.right);
            }
            //处理数据
            if (index >= mid && index <= end) {
                TreeNode ot = list.get(end - (index - start) - 1);
                int tem = ot.val;
                ot.val=fa.val;
                fa.val=tem;
                if (index == end) {
                    start = start * 4;
                    end = start * 2 - 1;
                    mid = start+(end-start+1)/2;
                }
            }
        }
        return root;
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode fa = queue.poll();
            list.add(fa.val);
            if (fa.left != null) {
                queue.add(fa.left);
            }
            if (fa.right != null) {
                queue.add(fa.right);
            }
        }
        int index = 0;
        int start = 2;
        int end = 3;
        queue.add(root);
        while (!queue.isEmpty()) {
            index++;
            TreeNode fa = queue.poll();
            if (index >= start && index <= end) {
                fa.val = list.get(end - (index - start) - 1);
                if (index == end) {
                    start = start * 4;
                    end = start * 2 - 1;
                }
            }
            list.add(fa.val);
            if (fa.left != null) {
                queue.add(fa.left);
            }
            if (fa.right != null) {
                queue.add(fa.right);
            }
        }
        return root;
    }
}
