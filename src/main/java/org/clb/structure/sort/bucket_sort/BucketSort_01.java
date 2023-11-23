package org.clb.structure.sort.bucket_sort;

import org.clb.structure.sort.Sort;

/**
 * @Description
 * @Classname BucketSort_01
 * @Date 2021/6/30 11:51
 * @Author clb
 */
public class BucketSort_01 extends Sort {

    /**
     * 
     * @param arr 非负整形数组
     */
    public static void sort(int[] arr){
        if (arr==null||arr.length<=1)return;
        bucketSort(arr,0,arr.length-1,digit(arr));
    }

    private static int digit(int[] arr) {
        int max=0;
        for (int a : arr) {
            max=Math.max(a,max);
        }
        int digit=1;
        while (max/10>0){
            max=max/10;
            digit++;
        }
        return digit;
    }

    /**
     *
     * @param arr
     * @param L 左下标
     * @param R 右下标
     * @param digit arr数组中最大的数的位数 如103 为3 对arr数组进行digit次排序
     */
    private static void bucketSort(int[] arr, int L, int R, int digit) {
        int[] help=new int[R-L+1];
        for (int i = 0; i < digit; i++) {//分别对10^digit位上的数进行排序
            int[] count=new int[10];//十个位置分别记录0-9上有多少个数
            for (int j =L; j < R+1; j++) {
                int index=arr[j]/((int)Math.pow(10,i))%10;//取arr数组中个十百..位数上的值
                count[index]=count[index]+1;
            }
            for (int j = 1; j < count.length; j++) {
                count[j]=count[j]+count[j-1];
            }
            for (int j = R; j > L-1; j--) {
                int index=arr[j]/((int)Math.pow(10,i))%10;
                help[count[index]-1]=arr[j];
                count[index]=count[index]-1;
            }
            for (int j = L; j < R + 1; j++) {
                arr[j]=help[j-L];
            }
        }
    }

    public static void main(String[] args) {
        int[] a=getIntArray(10,999);
        printArrary(a);
        sort(a);
        printArrary(a);
    }
}
