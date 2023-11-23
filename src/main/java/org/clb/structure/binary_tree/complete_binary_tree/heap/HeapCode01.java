package org.clb.structure.binary_tree.complete_binary_tree.heap;

/**
 * @Description 给出一个数组 形成一个大根堆 父节点位置 (i-1)/2 i:当前节点数组下标 子节点位置 2i+1 2i+2
 * 如果一个位置的数据突然改变 只需要分别调用add():向上比较是否比上面大交换 和 heapify():是否比下面小交换 方法既能变成正确的堆
 * 复杂度：O(logN)
 * @Classname HeapCode01
 * @Date 2021/5/22 19:02
 * @Author clb
 */
public class HeapCode01 {

    /**
     * 将传入的数组arr变成大根堆
     * 复杂度 O(n*logn)
     * @param arr
     */
    public static void heapMax(int[] arr) {
        if (arr==null||arr.length<2) return;
        int index=0;
        int[] p=arr;
        while (index<=arr.length-1){
            add(arr,index,arr[index]);
            index++;
        }
    }

    /**
     * 堆排序: 先将数组变成最大堆 然后依次移除头结点到尾部 最后得到的就是一个升序的数组
     * 时间复杂度 O(N*logN)
     * @param arr
     */
    public static void heapSort(int[] arr){
        //从上往下建堆 时间复杂度 O(N*logN)
        //heapMax(arr);
        //从下往上建堆 时间复杂度O(N)
        for (int i = arr.length-1; i >0 ; i--) {
            heapify(arr,arr.length,i);
        }
        int heapSize=arr.length;
        while (heapSize>0){
            removeMax(arr,--heapSize);
        }
    }

    //和父节点比较 如果比父节点大则交换 继续和父节点比较
    //直到比父节点小
    public static void add(int[] arr, int index,int value) {
        arr[index]=value;
        while (arr[index] > arr[(index - 1) / 2]) {//当前节点比父节点大且大于0
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 删除最大值 将arr[0]:最大值 与arr[heapsize]:最后一个交换 然后heapsize--
     * 然后将这时的头节点 arr[0] 不断与子节点中较大的交换 直到比子节点都大为止
     * @param arr
     * @param heapsize 当前的下标
     * @return
     */
    public static int removeMax(int[] arr, int heapsize) {
        int max = arr[0];
        swap(arr, heapsize--, 0);
        int index = 0;
        while (index * 2 + 1 <=heapsize) {
            swap(arr, index, index * 2 + 2 > heapsize ? index * 2 + 1
                : (arr[index * 2 + 1] > arr[index * 2 + 2] ? index * 2 + 1 : index * 2 + 2));
            index=index * 2 + 2 > heapsize ? arr[index * 2 + 1]
                : (arr[index * 2 + 1] > arr[index * 2 + 2] ? index * 2 + 1 : index * 2 + 2);
        }
        return max;
    }
    //将index位置的数往下移动到正确的位置
    public static void heapify(int[] arr, int heapsize,int index) {
//        int max = arr[0];
//        swap(arr, heapsize--, 0);
        while (index * 2 + 1 < heapsize) {
            swap(arr, index, index * 2 + 2 > heapsize ? arr[index * 2 + 1]
                : (arr[index * 2 + 1] > arr[index * 2 + 2] ? index * 2 + 1 : index * 2 + 2));
            index=index * 2 + 2 > heapsize ? arr[index * 2 + 1]
                : (arr[index * 2 + 1] > arr[index * 2 + 2] ? index * 2 + 1 : index * 2 + 2);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
//         int[] a=new int[10];
//         add(a,0,3);
//         add(a,1,5);
//         add(a,2,1);
//         add(a,3,9);
//         removeMax(a,3);
//         removeMax(a,2);
//        for (int i = 0; i < 2; i++) {
//            System.out.println(a[i]);
//        }
        int[] a=new int[]{1,3,8,2,7};
        heapSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
}
