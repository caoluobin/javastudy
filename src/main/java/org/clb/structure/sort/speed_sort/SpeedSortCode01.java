package org.clb.structure.sort.speed_sort;

/**
 * @Description
 * @Classname SpeedSortCode01
 * @Date 2021/5/19 21:07
 * @Author clb
 */
public class SpeedSortCode01 {

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int[] a = speedSort(arr, l, r);
        process(arr, l, a[0]);
        process(arr, a[1], r);

    }

    /**
     * 快速排序 1 8 5 10 7 12 9 8
     * 以最右边的8位标记将所有<8的数放在左边 >8的数放在右边 =8放中间
     * int less标记<8的下标 初始为l-1  0
     * int more标记>8的下标 初始为 r-1  6
     * int index 当前数下标 l 0
     * 8>1 arr[less++:0] 与arr[index++:0]交换位置 index:1 less:1 more:6
     * 8=8 不动 index++ index:2 less:1 more:6
     * 8>5 arr[less++:1] 与arr[index++:2]交换位置 index++ less:2 index:3 more:6
     * 8<10 arr[index:3]与arr[more--:6]交换 index不变 more-- less:2 index:3 more:5   1 5 8 9 7 12 10 8
     * 8<9 arr[index:3]与arr[more--:5]交换 index不变 more-- less:2 index:3 more:4   1 5 8 12 7 9 10 8
     * 8<12 arr[index:3]与arr[more--:4]交换 index不变 more-- less:2 index:3 more:3   1 5 8 7 12 9 10 8
     * 8>7 arr[less++:2]与arr[index++:3]交换 less:3 index:4 more:3  1 5 7 8 12 9 10 8
     * 12与7交换
     * p不变 q-- 1 5 7 7 12 10 8 8>7 p++ 8>7 p++ p=q 8与arr[q]交换
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int[] speedSort(int[] arr, int l, int r) {
        if (l == r) {
            return new int[]{l, r};
        }
        if (l > r) {
            return new int[]{-1, -1};
        }
        //通过随机获取中间值 降低时间复杂度
        swap(arr, (int) (Math.random() * (r - l + 1))+l, r);
        int less = l;
        int index = l;
        int more = r - 1;
        while (index <=more) {
            if (arr[r] > arr[index]) {
                swap(arr, index++, less++);
            } else if (arr[index] == arr[r]) {
                index++;
            } else {
                swap(arr, index, more--);
            }

        }
        swap(arr, index, r);
        return new int[]{less-1, index + 1};
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {//1 4 5 6 8 8 9 10
        int[] arr = new int[]{1, 8, 5, 10, 4, 6, 9, 8,23};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
//        int r=9;
//        int l=4;
//        int i = (int) (Math.random() * (r - l + 1)) + l;
//        System.out.println(i);
    }
}
