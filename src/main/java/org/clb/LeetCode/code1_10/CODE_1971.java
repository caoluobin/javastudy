package org.clb.LeetCode.code1_10;

import java.util.HashMap;
import java.util.Map;

/**
 * ��һ������ n ������� ˫�� ͼ������ÿ�������Ǵ� 0 �� n - 1������ 0 �� n - 1����ͼ�еı���һ����ά�������� edges ��ʾ��
 * ���� edges[i] = [ui, vi] ��ʾ���� ui �Ͷ��� vi ֮���˫��ߡ� ÿ��������� ���һ�� �����ӣ�����û�ж�����������������ıߡ�
 * ����ȷ���Ƿ���ڴӶ��� source ��ʼ�������� destination ������ ��Ч·�� ��
 * �������� edges ������ n��source �� destination������� source �� destination ���� ��Ч·�� ���򷵻� true�����򷵻� false ��
 */
public class CODE_1971 {

    public static void main(String[] args) {
        int[][] edges = new int[][] {{0,1},{0,2},{3,5},{5,4},{4,3}};
        boolean b = validPath(3, edges, 0, 5);
        System.out.println(b);
    }


    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer,Node> map = new HashMap<>();
        for (int[] edge : edges) {
            int first = edge[0];
            int second = edge[1];
            Node firstNode = map.computeIfAbsent(first, Node::new);
            Node secondNode = map.computeIfAbsent(second, Node::new);
            firstNode.nextNodeMap.putIfAbsent(second,secondNode);
            secondNode.nextNodeMap.putIfAbsent(first,firstNode);
        }
        Node node = map.get(source);

        return isAble(node,destination);
    }

    public static boolean isAble(Node node,int destination) {
        for (Map.Entry<Integer, Node> next : node.nextNodeMap.entrySet()) {
            if (next.getKey()==destination) {
                return true;
            }
            Node nextNode = next.getValue();
            Boolean isValidate = nextNode.isValidateMap.put(node.value, true);
            if (isValidate!=null&&isValidate) continue;
            return isAble(nextNode,destination);
        }
        return false;
    }

    static class Node {
        private int value;
        private Map<Integer,Node> nextNodeMap = new HashMap<>();
        private Map<Integer,Boolean> isValidateMap = new HashMap<>();

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
