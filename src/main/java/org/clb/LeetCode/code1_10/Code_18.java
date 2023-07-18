package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ���� n ��������ɵ����� nums ����һ��Ŀ��ֵ target ��
 * �����ҳ���������������ȫ�������Ҳ��ظ�����Ԫ�� [nums[a], nums[b], nums[c], nums[d]] ����������Ԫ��Ԫ��һһ��Ӧ������Ϊ������Ԫ���ظ�����
 * 0 <= a, b, c, d < n
 * a��b��c �� d ������ͬ
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * ����԰� ����˳�� ���ش� ��
 */
public class Code_18 {

    public static void main(String[] args) {
        int[] nums = {0,0,0,-1000000000,-1000000000,-1000000000,-1000000000};
        Code_18 code = new Code_18();
        System.out.println(code.fourSum(nums,-1000000000));
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            threeSum(nums,target-nums[i],i+1,result);
            while (i<nums.length-1&&nums[i]==nums[i+1]){
                i++;
            }
        }

        return result;
    }

    public List<List<Integer>> threeSum(int[] nums,int target,int index,List<List<Integer>> result) {
        for (int i = index; i < nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;
            //����nums[i]+nums[i+1]+nums[i+2]����Խ������
            if (Long.valueOf(nums[i])+Long.valueOf(nums[i+1])+Long.valueOf(nums[i+2])>target){
                break;
            }
            while (left<right){
                if(nums[i]+nums[left]+nums[right]==target){
                    List<Integer> temp = new ArrayList<>();
                    int leftNum = nums[left];
                    int rightNum = nums[right];
                    temp.add(nums[index-1]);
                    temp.add(nums[i]);
                    temp.add(leftNum);
                    temp.add(rightNum);
                    result.add(temp);
                    left++;
                    right--;

                    while (left<right-1&&nums[left]==nums[left-1]) {
                        left++;
                    }

                    while (left<right-1&&nums[right]==nums[right+1])  {
                        right--;
                    }
                    if (left==right-1&&nums[left]==leftNum&&rightNum==nums[right]){
                        break;
                    }
                }else if(nums[i]+nums[left]+nums[right]>target){
                    right--;
                }else {
                    left++;
                }
            }
            while (i<nums.length-1&&nums[i]==nums[i+1]){
                i++;
            }
        }
        return result;
    }
}
