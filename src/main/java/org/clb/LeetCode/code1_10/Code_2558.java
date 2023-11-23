package org.clb.LeetCode.code1_10;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_2558 {

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparing(Integer::intValue).reversed());
        for (int gift : gifts) {
            queue.offer(gift);
        }

        while (k>0) {
            int sqrt = (int)Math.sqrt(queue.poll());
            queue.offer(sqrt);
            k--;
        }
        long res = 0 ;
        while (!queue.isEmpty()) {
            res+=queue.poll();
        }
        return res;
    }
}
