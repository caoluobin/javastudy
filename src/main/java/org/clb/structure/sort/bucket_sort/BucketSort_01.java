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
     * @param arr �Ǹ���������
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
     * @param L ���±�
     * @param R ���±�
     * @param digit arr��������������λ�� ��103 Ϊ3 ��arr�������digit������
     */
    private static void bucketSort(int[] arr, int L, int R, int digit) {
        int[] help=new int[R-L+1];
        for (int i = 0; i < digit; i++) {//�ֱ��10^digitλ�ϵ�����������
            int[] count=new int[10];//ʮ��λ�÷ֱ��¼0-9���ж��ٸ���
            for (int j =L; j < R+1; j++) {
                int index=arr[j]/((int)Math.pow(10,i))%10;//ȡarr�����и�ʮ��..λ���ϵ�ֵ
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
