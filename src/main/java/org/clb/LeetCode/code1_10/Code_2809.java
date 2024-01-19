package org.clb.LeetCode.code1_10;

import lombok.Data;

import java.util.*;

/**
 * 给你两个长度相等下标从 0 开始的整数数组 nums1 和 nums2 。每一秒，对于所有下标 0 <= i < nums1.length ，nums1[i] 的值都增加 nums2[i] 。
 * 操作 完成后 ，你可以进行如下操作：
 * 选择任一满足 0 <= i < nums1.length 的下标 i ，并使 nums1[i] = 0 。
 * 同时给你一个整数 x 。
 * 请你返回使 nums1 中所有元素之和 小于等于 x 所需要的 最少 时间，如果无法实现，那么返回 -1 。
 */
public class Code_2809 {
    public static void main(String[] args) {
        List<Integer> nums1 = Arrays.asList(10,4,1,10,7,5,6,3,2,10);//2
        List<Integer> nums2 = Arrays.asList(4,0,4,0,3,4,3,0,0,3);//18 15 12 12 8 4
        int x = 50;
        System.out.println(new Code_2809().minimumTime(nums1, nums2, x));
    }

    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        //全部清空一轮的回合数 如果nums2升序前n-1个相加大于等于x则不能清空
        //1 10 20 30
        int sum1 = 0;
        for (Integer num1 : nums1) {
            sum1+=num1;
        }
        if (sum1<=x) {
            return 0;
        }
        int sum2 = 0;
        int sum3 = 0;
        ArrayList<Integer> nums3 = new ArrayList<>(nums2);
        nums3.sort(Comparator.comparing(Integer::intValue).reversed());
        for (int i = 0; i < nums3.size(); i++) {
            sum2+=nums3.get(i);
            if (i!=0) {
                sum3+=nums3.get(i)*i;
            }

        }

        int n = nums1.size();
        Map<Integer,List<Data>> map = new HashMap<>();
        List<Data> list = getMuList(nums1,nums2,1,map);
        //假设第i轮解决
        for (int i = 0; i < n; i++) {
            int res=sum1+sum2*(i+1)-calDiv(nums1,nums2,i+1,list,map);
            if(res<=x){
                return i+1;
            }
        }//24 -12 -4-2
        if (sum3<=x) {
            return n;
        }
        return -1;
    }

    private int calDiv(List<Integer> nums1, List<Integer> nums2, int mul,List<Data> list,Map<Integer,List<Data>> map) {
        if (mul==1) {
            return list.get(0).getSum();
        } else {
            List<Data> muList = getMuList(nums1, nums2, mul,map);
            Data data = muList.get(0);
            int index = data.index;
            int sum = data.sum;
            Set<Integer> set =new HashSet<>();
            set.add(index);
            for (int j = mul-1; j >0; j--) {
                List<Data> muList2 = getMuList(nums1, nums2, j,map);
                int i = 0;
                while (set.contains(muList2.get(i).index)) {
                    i++;
                }
                sum+=muList2.get(i).sum;
                set.add(muList2.get(i).index);
            }
            return sum;
        }

    }
    private List<Data> getMuList(List<Integer> nums1, List<Integer> nums2, int mul,Map<Integer,List<Data>> map) {
        if (map.containsKey(mul)) {
            return map.get(mul);
        }
        List<Data> list = new ArrayList<>();
        for (int i = 0; i < nums1.size(); i++) {
            list.add(new Data(i,nums1.get(i)+nums2.get(i)*mul));
        }
        list.sort(Comparator.comparing(Data::getSum).reversed());
        map.put(mul,list);
        return list;
    }
    private class Data{
        private Integer index;
        private Integer sum;

        public Data(Integer index, Integer sum) {
            this.index = index;
            this.sum = sum;
        }

        public Integer getSum() {
            return sum;
        }
    }
}
