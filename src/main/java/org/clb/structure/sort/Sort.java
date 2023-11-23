package org.clb.structure.sort;

/**
 * @Description
 * @Classname Sort
 * @Date 2021/6/30 15:42
 * @Author clb
 */
public class Sort {
    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static int[] getIntArray(int size,int max) {
        //数组的长度为0-100的随机数
        //int size=(int)(Math.random()*10)+90;
        int[] res = new int[size];
        int index = 0;
        while (index<size){
            res[index]=(int)(Math.random()*max)+1;
            index++;

        }
        return res;
    }
    public static void printArrary(int[] arr){
        for (int a : arr) {
            System.out.print(a+" ");
        }
        System.out.println();
    }


}
