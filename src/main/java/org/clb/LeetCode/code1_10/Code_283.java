package org.clb.LeetCode.code1_10;

public class Code_283 {

    public void moveZeroes(int[] nums) {
        if (nums.length==1) {
            return;
        }
        //��¼��ǰ��0��λ��
        int index=-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0) {
                index = i;
                break;
            }
        }
        if (index==-1) return;
        for (int i = index; i < nums.length; i++) {
            if (nums[i]!=0) {
                nums[index] = nums[i];
                nums[i]=0;
                index++;
            }
        }
    }
}
