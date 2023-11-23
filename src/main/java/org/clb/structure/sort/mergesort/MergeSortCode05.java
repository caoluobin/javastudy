package org.clb.structure.sort.mergesort;

/**
 * @Description 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * @Classname MergeSortCode05
 * @Date 2021/5/18 13:34
 * @Author clb
 */
public class MergeSortCode05 {

  /** 3 2
   *  1 3 5 7  9 11     8 10 12 14  16 20
   * @param nums1
   * @param nums2
   * @return
   */
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m=nums1.length;
    int n=nums2.length;
    int[] a=new int[m+n];
    int result=0;
    int count=0;
    //偶数情况
    if ((m/2==1&&n/2==1)||(m/2==0&&n/2==0)){
      while (count!=m+n/2){

      }
      return 0;
    }else {//奇数情况

    }


    return 0;
  }

}
