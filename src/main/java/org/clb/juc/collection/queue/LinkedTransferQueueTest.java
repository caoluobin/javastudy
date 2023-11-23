package org.clb.juc.collection.queue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class LinkedTransferQueueTest {

    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    public static void test() {
        LinkedTransferQueue<Integer> queue = new LinkedTransferQueue<>();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                ThreadLocalRandom current = ThreadLocalRandom.current();
                int seed = current.nextInt();
                try {
                    queue.transfer(seed);
                    System.out.println("往queue中加入:"+seed);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    Integer take = queue.take();
                    System.out.println("获取数据:"+take);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    public static void test1() throws InterruptedException {
        LinkedTransferQueue<Integer> queue = new LinkedTransferQueue<>();
        queue.add(1);
        queue.add(2);
        queue.take();
        queue.take();
    }
}
