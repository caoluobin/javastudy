package org.clb.structure.sort.mergesort;

/**
 * @Description ����������С�ֱ�Ϊ m �� n �����򣨴�С�������� nums1 �� nums2�������ҳ���������������������� ��λ�� ��
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
    //ż�����
    if ((m/2==1&&n/2==1)||(m/2==0&&n/2==0)){
      while (count!=m+n/2){

      }
      return 0;
    }else {//�������

    }


    return 0;
  }

}
