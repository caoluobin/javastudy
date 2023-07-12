package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.List;

/**
 * һ���±�� 0 ��ʼ������� ����� ����Ϊ ż�� �±괦Ԫ��֮�ͼ�ȥ�����±괦Ԫ��֮�� ��
 * �ȷ�˵������ [4,2,5,3] �Ľ����Ϊ (4 + 5) - (2 + 3) = 4 ��
 * ����һ������ nums �����㷵�� nums �����������е� ������ �������е��±� ���� �� 0 ��ʼ��ţ���
 * һ������� ������ �Ǵ�ԭ������ɾ��һЩԪ�غ�Ҳ����һ��Ҳ��ɾ����ʣ��Ԫ�ز��ı�˳����ɵ����顣�ȷ�˵��[2,7,4] �� [4,2,3,7,2,1,4] ��һ�������У��Ӵ�Ԫ�أ������� [2,4,2] ���ǡ�
 */
public class Code_1911 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,2,1,9,5, 3,1};
        System.out.println(maxAlternatingSum(nums));
    }

    public static long maxAlternatingSum(int[] nums) {
        //l��ʾż���±�����ֵ
        long l = 0;
        //f��ʾ�����±�����ֵ
        long f = 0;

        for (int i = 0; i < nums.length; i++) {
            l = Math.max(l, f + nums[i]);
            f = Math.max(f, l - nums[i]);
        }
        return Math.max(l, f);
    }

    public static long maxAlternatingSum2(int[] nums) {
        return dfs(nums, new ArrayList<>(), 0);
    }
    public static long dfs(int[] nums, List<Integer> dfs, int index) {
        if (index==nums.length) {
            long sum = 0;
            for (int i = 0; i < dfs.size(); i++) {
                if (i%2==0){
                    sum+=dfs.get(i);
                } else {
                    sum-=dfs.get(i);
                }
            }
            if (dfs.size()%2==0) {
                return sum+nums[index-1];
            }
            return sum;
        }
        long sum = dfs(nums, dfs, index + 1);
        dfs.add(nums[index]);
        long sum1 = dfs(nums, dfs, index + 1);
        dfs.remove(dfs.size()-1);
        return Math.max(sum,sum1);
    }
}
