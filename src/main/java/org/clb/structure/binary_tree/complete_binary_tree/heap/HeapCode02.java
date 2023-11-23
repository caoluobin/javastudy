package org.clb.structure.binary_tree.complete_binary_tree.heap;

import java.util.PriorityQueue;

/**
 * @Description 给定一个无序的数组，但是每个数字和排完序后的数组的位置 下标距离不超过k
 * 将该数组升序   利用堆排序分别对前k+1个数字最小堆排序 将最小的放在头结点 然后对第二个位置开始的k+1个数字排序
 * 复杂度O(n*logk)
 * @Classname HeapCode02
 * @Date 2021/5/23 16:05
 * @Author clb
 */
public class HeapCode02 {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.add(1);
        queue.add(5);
        queue.add(3);

        for (int i = 0; i < 3; i++) {
            System.out.println(queue.poll());
        }
    }
    public void sort(int[] arr){

    }
}
