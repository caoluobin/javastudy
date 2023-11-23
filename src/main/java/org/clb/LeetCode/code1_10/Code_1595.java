package org.clb.LeetCode.code1_10;

import java.util.List;

/**
 * 给你两组点，其中第一组中有 size1 个点，第二组中有 size2 个点，且 size1 >= size2 。
 * 任意两点间的连接成本 cost 由大小为 size1 x size2 矩阵给出，其中 cost[i][j] 是第一组中的点 i
 * 和第二组中的点 j 的连接成本。如果两个组中的每个点都与另一组中的一个或多个点连接，则称这两组点是连通的。
 * 换言之，第一组中的每个点必须至少与第二组中的一个点连接，且第二组中的每个点必须至少与第一组中的一个点连接。
 * 返回连通两组点所需的最小成本。
 */
public class Code_1595 {

    public int connectTwoGroups(List<List<Integer>> cost) {
        Integer size1 = cost.size();
        Integer size2 = cost.get(0).size();
        return dfs(cost,size2,size1,0);
    }

    /**
     *
     * @param cost
     * @param size2 第二组长度
     * @param size1
     * @param index
     * @return
     */
    private int dfs(List<List<Integer>> cost, Integer size2, Integer size1, Integer index) {

        return 0;
    }
}
