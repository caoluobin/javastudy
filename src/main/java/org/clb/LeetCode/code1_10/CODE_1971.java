package org.clb.LeetCode.code1_10;

import java.util.HashMap;
import java.util.Map;

/**
 * 有一个具有 n 个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。图中的边用一个二维整数数组 edges 表示，
 * 其中 edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。 每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。
 * 请你确定是否存在从顶点 source 开始，到顶点 destination 结束的 有效路径 。
 * 给你数组 edges 和整数 n、source 和 destination，如果从 source 到 destination 存在 有效路径 ，则返回 true，否则返回 false 。
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
