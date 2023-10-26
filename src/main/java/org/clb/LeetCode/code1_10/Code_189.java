package org.clb.LeetCode.code1_10;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class Code_189 {
    public static void main(String[] args) {//   4 5 3 1 2
        Code_189  code = new Code_189();
        int[] a =new int[]{1,2,3,4,5,6};
        code.rotate(a,4);
        for (int i : a) {
            System.out.print(i);
        }
    }
    public void rotate(int[] nums, int k) {
        rotate(nums,k,nums.length);
    }

    /**
     * 每次移k个 没移完的递归下次移
     * @param nums
     * @param k
     * @param end 需要移动的数据
     */
    public void rotate(int[] nums, int k,int end) {
        k = k%end;
        if (k==0) return;
        int i = 0;
        for (; i+k < end; i++) {
            // (i+k)%k  与 i+k 交换
            int target = (i+k)%k;
            int now =nums[target];
            int a =(i+k)%end;
            nums[target] = nums[a];
            nums[a] = now;
        }
        rotate(nums,k-end%k,k);

    }
}
