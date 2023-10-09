package org.clb.LeetCode.code1_10;

/**
 * ����һ���������� nums ���ҵ�������ϸ���������еĳ��ȡ�
 * ������ ���������������������У�ɾ������ɾ���������е�Ԫ��
 * �����ı�����Ԫ�ص�˳�����磬[3,6,2,7] ������ [0,3,1,6,2,2,7] �������С�
 */
public class Code_300 {

    public int lengthOfLIS(int[] nums) {
        int[] r = new int[nums.length];
        int last = nums[1];
        r[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int now = nums[i];
            if (now>last) {
                r[i] = r[i-1]+1;
            } else {
                int g = i-1;// 12345  2 4
                while (g>=0) {
                    g--;
                }

            }
        }

        return 1;
    }
    // 7  1 7 0 max
    // 5  2 5 1 7
    private void dfs(int[] nums, int[][] r, int index) {
        if (index==nums.length-1) {
            r[nums.length-1][0]=1;
            r[nums.length-1][1]=nums[nums.length-1];
            r[nums.length-1][2]=0;
            r[nums.length-1][3]=Integer.MAX_VALUE;
        }
        dfs(nums,r,index+1);
        int now = nums[index];
        r[index][0]=Math.max(now<r[index+1][1]?r[index][0]+1:r[index][0],//���ұ�ѡ��С
                now<r[index+1][3]?r[index][2]+1:r[index][2]);//���ұ�ûѡ��
//        r[index][1]=now>=r[index+1][1]&&now>=r[index+1][3]?Integer.MIN_VALUE:;
        r[index][2]=0;
        r[index][3]=Integer.MAX_VALUE;

    }
}
