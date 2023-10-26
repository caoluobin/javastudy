package org.clb.LeetCode.code1_10;

/**
 * ����һ���������� nums �������ҳ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 * ������ �������е�һ���������֡�
 */
public class Code_53 {
    int count =0;

    public static void main(String[] args) {
        Code_53 code = new Code_53();
        code.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(code.count);
    }
    public int maxSubArray2(int[] nums) {

        int d = 0;//����ǰֵ�����ֵ
        int f= Integer.MIN_VALUE;//���ֵ

        for (int i = 0; i < nums.length; i++) {
            int now =nums[i];
            if (d>0) {
                d+=now;
            } else {
                d = now;
            }
            f = Math.max(f,d);
        }
        return f;
    }
    public int maxSubArray(int[] nums) {
        // 0: ����ǰֵ�����ֵ  ���ֵ
        Integer[][] maxs = new Integer[nums.length][2];
        dfs(nums,maxs,0);
        return maxs[0][1];
    }


    private void dfs(int[] nums, Integer[][] maxs, int i) {
        count++;
        if (i ==nums.length-1) {
            maxs[i][0] = nums[i];
            maxs[i][1] = nums[i];
            return ;
        }
        dfs(nums,maxs,i+1);
        maxs[i][0]=maxs[i+1][0]>0?maxs[i+1][0]+nums[i]:nums[i];
        maxs[i][1]=Math.max(maxs[i+1][1],maxs[i][0]);

    }
}
