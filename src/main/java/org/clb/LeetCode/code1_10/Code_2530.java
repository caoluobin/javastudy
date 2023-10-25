package org.clb.LeetCode.code1_10;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_2530 {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(2);
        queue.add(4);
        System.out.println(queue.poll());
    }
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparing(Integer::intValue).reversed());
        for (int num : nums) {
            queue.add(num);
        }
        long sum = 0;
        while (k>0) {
            Integer poll = queue.poll();
            sum+=poll;
            queue.add((poll+2)/3);
            k--;
        }
        return sum;
    }
    public long maxKelements2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparing(Integer::intValue).reversed());
        for (int num : nums) {
            queue.add(num);
        }
        long sum = 0;
        while (k>0) {
            Integer poll = queue.poll();
            sum+=poll;
            queue.add((poll+2)/3);
            k--;
        }
        return sum;
    }
}
