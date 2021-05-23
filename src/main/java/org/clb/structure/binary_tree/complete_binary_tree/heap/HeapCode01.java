package org.clb.structure.binary_tree.complete_binary_tree.heap;

/**
 * @Description ����һ������ �γ�һ������� ���ڵ�λ�� (i-1)/2 i:��ǰ�ڵ������±� �ӽڵ�λ�� 2i+1 2i+2
 * ���һ��λ�õ�����ͻȻ�ı� ֻ��Ҫ�ֱ����add():���ϱȽ��Ƿ������󽻻� �� heapify():�Ƿ������С���� �������ܱ����ȷ�Ķ�
 * ���Ӷȣ�O(logN)
 * @Classname HeapCode01
 * @Date 2021/5/22 19:02
 * @Author clb
 */
public class HeapCode01 {

    /**
     * �����������arr��ɴ����
     * ���Ӷ� O(n*logn)
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
     * ������: �Ƚ����������� Ȼ�������Ƴ�ͷ��㵽β�� ���õ��ľ���һ�����������
     * ʱ�临�Ӷ� O(N*logN)
     * @param arr
     */
    public static void heapSort(int[] arr){
        //�������½��� ʱ�临�Ӷ� O(N*logN)
        //heapMax(arr);
        //�������Ͻ��� ʱ�临�Ӷ�O(N)
        for (int i = arr.length-1; i >0 ; i--) {
            heapify(arr,arr.length,i);
        }
        int heapSize=arr.length;
        while (heapSize>0){
            removeMax(arr,--heapSize);
        }
    }

    //�͸��ڵ�Ƚ� ����ȸ��ڵ���򽻻� �����͸��ڵ�Ƚ�
    //ֱ���ȸ��ڵ�С
    public static void add(int[] arr, int index,int value) {
        arr[index]=value;
        while (arr[index] > arr[(index - 1) / 2]) {//��ǰ�ڵ�ȸ��ڵ���Ҵ���0
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * ɾ�����ֵ ��arr[0]:���ֵ ��arr[heapsize]:���һ������ Ȼ��heapsize--
     * Ȼ����ʱ��ͷ�ڵ� arr[0] �������ӽڵ��нϴ�Ľ��� ֱ�����ӽڵ㶼��Ϊֹ
     * @param arr
     * @param heapsize ��ǰ���±�
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
    //��indexλ�õ��������ƶ�����ȷ��λ��
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
