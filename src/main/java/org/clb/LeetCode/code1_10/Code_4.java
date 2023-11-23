package org.clb.LeetCode.code1_10;

import org.clb.structure.sort.Sort;

/**
 * @Description 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * @Classname Code4
 * @Date 2021/7/1 10:07
 * @Author clb
 */
public class Code_4 extends Sort {
    /**
     *  1 3 5 7 11 23
     *  2 3 6
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return 1;
    }
    public static double fin(int[] nums1, int[] nums2){
        int index1=0;
        int index2=0;
        int a=0;
        double[] c=new double[2];
        while (a<(nums1.length+nums2.length+1)/2){
            if (index1<nums1.length&&index2<nums2.length) {
                c[0]=nums1[index1] < nums2[index2]?nums1[index1++]:nums2[index2++];
            } else if (index1>=nums1.length) {
                c[0]=nums2[index2++];
            } else if (index2>=nums2.length) {
                c[0]=nums1[index1++];
            }
            a++;
        }
        if (index1<nums1.length&&index2<nums2.length)
            c[1]=(nums1.length+nums2.length)%2==1?c[0]: Math.min(nums1[index1], nums2[index2]);
        if (index1>=nums1.length) c[1]=(nums1.length+nums2.length)%2==1?c[0]:nums2[index2];
        if (index2>=nums2.length) c[1]=(nums1.length+nums2.length)%2==1?c[0]:nums1[index1];
        return (c[0]+c[1])/2;
    }

    public static void main(String[] args) {
        int[] a=new int[]{3,4,5,6};
        int[] b=new int[]{1};
        System.out.println(fin(a,b));
    }

}
