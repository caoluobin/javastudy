package org.clb.LeetCode.code1_10;

import java.util.List;

/**
 * ��������㣬���е�һ������ size1 ���㣬�ڶ������� size2 ���㣬�� size1 >= size2 ��
 * �������������ӳɱ� cost �ɴ�СΪ size1 x size2 ������������� cost[i][j] �ǵ�һ���еĵ� i
 * �͵ڶ����еĵ� j �����ӳɱ�������������е�ÿ���㶼����һ���е�һ�����������ӣ���������������ͨ�ġ�
 * ����֮����һ���е�ÿ�������������ڶ����е�һ�������ӣ��ҵڶ����е�ÿ��������������һ���е�һ�������ӡ�
 * ������ͨ������������С�ɱ���
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
     * @param size2 �ڶ��鳤��
     * @param size1
     * @param index
     * @return
     */
    private int dfs(List<List<Integer>> cost, Integer size2, Integer size1, Integer index) {

        return 0;
    }
}
