package org.clb.LeetCode.code1_10;

/**
 * Trie���������� "try"������˵ ǰ׺�� ��һ���������ݽṹ�����ڸ�Ч�ش洢�ͼ����ַ������ݼ��еļ�����һ���ݽṹ���൱���Ӧ���龰�������Զ������ƴд��顣
 * ����ʵ�� Trie �ࣺ
 * Trie() ��ʼ��ǰ׺������
 * void insert(String word) ��ǰ׺���в����ַ��� word ��
 * boolean search(String word) ����ַ��� word ��ǰ׺���У����� true�������ڼ���֮ǰ�Ѿ����룩�����򣬷��� false ��
 * boolean startsWith(String prefix) ���֮ǰ�Ѿ�������ַ��� word ��ǰ׺֮һΪ prefix ������ true �����򣬷��� false ��
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
