package org.clb.structure.sort.simple_sort;

import org.clb.structure.sort.Sort;
import org.clb.structure.sort.SortType;

/**
 * @Description ѡ������
 * @Classname SelectSort
 * @Date 2021/6/30 15:30
 * @Author clb
 */
public class SelectSort extends Sort {
    public static void selectSort(int[] arr, SortType sortType){
        for (int i = 0; i < arr.length; i++) {//��һ����Ҫ������±�
            int num=arr[i];
            int flag=i;
            for (int j = i; j < arr.length; j++) {//ѡ����С�����ֵ��
                flag=sortType.getType()==1?num>arr[j]?j:flag
                        :num>arr[j]?flag:j;
                num=sortType.getType()==1?Math.min(arr[j],num):Math.max(arr[j],num);
            }
            swap(arr,flag,i);
        }
    }

    public static void main(String[] args) {
        int[] a=getIntArray(10,10);
        printArrary(a);
        selectSort(a,SortType.DESC);
        printArrary(a);
    }
}
