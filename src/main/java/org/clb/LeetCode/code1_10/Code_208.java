package org.clb.LeetCode.code1_10;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 */
public class Code_208 {
    private Node head;
    public Code_208() {
        head = new Node();
    }

    public void insert(String word) {
        Node last = head;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(0)-'a';
            if (last.children[index]==null) {
                last.children[index]=new Node();
            }
            last = last.children[index];
        }
        last.setEnd(true);
    }

    public boolean search(String word) {
        Node now = head;
        for (int i = 0; i < word.length(); i++) {
            int index =word.charAt(0)-'a';
            if (now.children[index]==null) {
                return false;
            }
            now = now.children[index];
        }
        if (now.isEnd) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {

        Node now = head;
        for (int i = 0; i < prefix.length(); i++) {
            int index =prefix.charAt(0)-'a';
            if (now.children[index]==null) {
                return false;
            }
            now = now.children[index];
        }
        return true;
    }
    class Node {
        private Node[] children;
        private boolean isEnd;
        public Node() {
            this.children = new Node[26];
            this.isEnd = false;
        }
        public void setEnd(boolean end) {
            isEnd = end;
        }
    }
}
