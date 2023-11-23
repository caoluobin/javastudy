package org.clb.LeetCode.code1_10;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
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
        //选择当前节点
        sums[level-1][0] = sums[level][1]+nums[level-1];
        //不选当前节点则选则下一节点 选或不选的最大值
        sums[level-1][1] = Math.max(sums[level][0],sums[level][1]);
    }
}
