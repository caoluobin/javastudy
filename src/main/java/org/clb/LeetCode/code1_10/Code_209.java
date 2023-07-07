package org.clb.LeetCode.code1_10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ����һ������ n ���������������һ�������� target ��
 * �ҳ���������������� �� target �ĳ�����С��
 * ���������� [numsl, numsl+1, ..., numsr-1, numsr] ���������䳤�ȡ���������ڷ��������������飬���� 0 ��
 */
public class Code_209 {
    public static void main(String[] args) {
        Code_209 code209 = new Code_209();
        System.out.println(code209.minSubArrayLen2(15, new int[]{1,2,3,4,5}));
    }
    public int minSubArrayLen(int target, int[] nums) {
        if (target>Arrays.stream(nums).sum()) {
            return 0;
        }
        for (int i = 1; i <=nums.length; i++) {
            int max=max1(nums,i);
            if(max>=target){
                return i;
            }
        }
        return 0;
    }
    public int minSubArrayLen1(int target, int[] nums) {
        if (target>Arrays.stream(nums).sum()) {
            return 0;
        }
        for (int i = 1; i <=nums.length; i++) {
            int max=max1(nums,i);
            if(max>=target){
                return i;
            }
        }
        return 0;
    }
    public int max1(int[] nums,int count) {
        //��ȡnums��count��������������
        int max=0;
        for (int i = 0; i < nums.length-count+1; i++) {
            int sum=0;
            for (int j = i; j < i+count; j++) {
                sum+=nums[j];
            }
            if(sum>max){
                max=sum;
            }
        }
        return max;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        if (target>Arrays.stream(nums).sum()) {
            return 0;
        }
        Map<String,Integer> map = new HashMap<>();
        for (int i = 1; i <=nums.length; i++) {
            int max=max2(nums,i,map,target);
            if(max>=target){
                return i;
            }
        }
        return 0;
    }

    public int max2(int[] nums,int count,Map<String,Integer> map,int target) {
        //��ȡnums��count��������������
        int max=0;
        for (int i = 0; i < nums.length-count+1; i++) {
            Integer lastSum = map.getOrDefault((i+1)+"-"+(i+count-1), 0);
            int sum=lastSum+nums[i];
            map.put(i+"-"+(i+count-1),sum);
            if(sum>max){
                max=sum;
            }
            if (max>=target) {
                return max;
            }
        }
        return max;
    }
}
