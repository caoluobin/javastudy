package org.clb.LeetCode.code1_10;

import org.clb.LeetCode.entity.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class Code_199 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(10);
        list.set(1,1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        Integer[] a = new Integer[100];
        process(root,a,1);
        return Arrays.asList(a).stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    private void process(TreeNode node, Integer[] a,int level) {
        if (node == null) {
            return;
        }
        process(node.right,a,level+1);
        if (a[level]==null) {
            a[level]= node.val;
        }
        process(node.left,a,level+1);
    }
}
