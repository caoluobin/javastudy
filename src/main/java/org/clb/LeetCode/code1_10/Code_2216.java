package org.clb.LeetCode.code1_10;

import java.util.Random;

public class Code_2216 {
    public int minDeletion2(int[] nums) {
        int n = nums.length;
        int ans = 0;
        boolean check = true;
        for (int i = 0; i + 1 < n; ++i) {
            if (nums[i] == nums[i + 1] && check) {
                ++ans;
            } else {
                check = !check;
            }
        }
        if ((n - ans) % 2 != 0) {
            ++ans;
        }
        return ans;
    }


    public int minDeletion3(int[] nums) {
        int res=0;
        int i = 0;
        for (; i < nums.length-1;) {//5 4
            if (nums[i]!=nums[i+1]) {
                i+=2;
            } else {
                i++;
                res++;
            }
        }
        if (i==nums.length-1) {
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Code_2216 code= new Code_2216();
        for (int i = 0; i < 10000; i++) {
            int[] a =new int[6];

            for (int j = 0; j < 6; j++) {
                a[j]= random.nextInt(5);
            }
            if (code.minDeletion(a)!=code.minDeletion3(a)) {
                for (int num : a) {
                    System.out.print(num+"  ");
                }
                break;
            }
        }
//        System.out.println(code.minDeletion(new int[]{0,0,2,2,2,0}));
//        System.out.println(code.minDeletion2(new int[]{0,0,2,2,2,0}));
    }

    public int minDeletion(int[] nums) {//123224
        if (nums.length<2) {
            return nums.length;
        }
        Integer[] df = new Integer[nums.length];
        return dfs(nums,0,0,df);
    }

    /**
     * 返回index下标之后的结果
     * @param nums
     * @param index
     * @param beforeNum
     * @return
     */
    private int dfs(int[] nums, int index, int beforeNum,Integer[] df) {
        if (index>nums.length-1) {
            return beforeNum;
        }
        if (df[index]!=null) {
            return df[index]+beforeNum;
        }
        int a = index;
        int min= 0;
        for (; index <nums.length-1 ;) {
            if (nums[index]!=nums[index+1]) {
                index+=2;
            } else {
                //两种策略取最小值
                //1.直接去除两个
                min = dfs(nums,index+2,2,df);// 12
                //2.去除一个
                min = Math.min(min,dfs(nums,index+1,1,df));
                break;
            }
        }
        if (index == nums.length-1) {
            min+=1;
        }
        df[a]=min;
        return min+beforeNum;
    }
}
