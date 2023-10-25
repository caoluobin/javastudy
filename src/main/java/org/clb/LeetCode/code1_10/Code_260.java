package org.clb.LeetCode.code1_10;

/**
 * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 */
public class Code_260 {

    public static void main(String[] args) {
        System.out.println(10^10);
    }
    public int[] singleNumber(int[] nums) {
        int eor = 0;
        for (int i = 0; i < nums.length; i++) {
            eor ^= nums[i];
        }
        //获取最右侧的1
        int eor2 = eor & (-eor);//5: 0101 1011
        int resulta = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & eor2) != 0) {
                resulta ^= nums[i];
            }
        }
        int[] result = new int[2];
        result[0] = resulta;
        result[1] = resulta ^ eor;
        return result;
    }
}
