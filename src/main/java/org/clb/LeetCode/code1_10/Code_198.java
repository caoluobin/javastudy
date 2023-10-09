package org.clb.LeetCode.code1_10;

/**
 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ��
 * ����������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ ����������װ�õ������ ��һҹ֮���ܹ�͵�Ե�����߽�
 */
public class Code_198 {

    public int rob(int[] nums) {
        int[][] sums = new int[nums.length][2];
        dfs(nums,sums,1);
        return Math.max(sums[0][0],sums[0][1]);
    }

    private void dfs(int[] nums, int[][] sums, int level) {
        if (level==nums.length) {
            //select
            sums[level-1][0] = nums[level-1];
            //not select
            sums[level-1][1] = 0;
            return ;
        }
        dfs(nums,sums,level+1);
        //ѡ��ǰ�ڵ�
        sums[level-1][0] = sums[level][1]+nums[level-1];
        //��ѡ��ǰ�ڵ���ѡ����һ�ڵ� ѡ��ѡ�����ֵ
        sums[level-1][1] = Math.max(sums[level][0],sums[level][1]);
    }
}
