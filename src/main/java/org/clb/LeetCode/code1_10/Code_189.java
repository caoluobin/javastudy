package org.clb.LeetCode.code1_10;

/**
 * ����һ���������� nums���������е�Ԫ��������ת k ��λ�ã����� k �ǷǸ�����
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
     * ÿ����k�� û����ĵݹ��´���
     * @param nums
     * @param k
     * @param end ��Ҫ�ƶ�������
     */
    public void rotate(int[] nums, int k,int end) {
        k = k%end;
        if (k==0) return;
        int i = 0;
        for (; i+k < end; i++) {
            // (i+k)%k  �� i+k ����
            int target = (i+k)%k;
            int now =nums[target];
            int a =(i+k)%end;
            nums[target] = nums[a];
            nums[a] = now;
        }
        rotate(nums,k-end%k,k);

    }
}
