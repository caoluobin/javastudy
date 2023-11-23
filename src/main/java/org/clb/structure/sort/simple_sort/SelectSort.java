package org.clb.structure.sort.simple_sort;

import org.clb.structure.sort.Sort;
import org.clb.structure.sort.SortType;

/**
 * @Description 选择排序
 * @Classname SelectSort
 * @Date 2021/6/30 15:30
 * @Author clb
 */
public class SelectSort extends Sort {
    public static void selectSort(int[] arr, SortType sortType){
        for (int i = 0; i < arr.length; i++) {//下一个需要排序的下标
            int num=arr[i];
            int flag=i;
            for (int j = i; j < arr.length; j++) {//选择最小（最大值）
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
