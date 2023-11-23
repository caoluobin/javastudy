package org.clb.structure.sort.simple_sort;

/**
 * @Description 冒泡排序
 * @Classname BubbleSort
 * @Date 2021/6/13 16:40
 * @Author clb
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 2, 10, 9, 7};
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void sort(int[] arr) {
        for (int i = arr.length; i > 0; i--) {
            for (int j = 0; j < (i - 1); j++) {
                if (arr[j] > arr[j + 1]) {
                    int a = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = a;
                }
            }
        }
    }
}
