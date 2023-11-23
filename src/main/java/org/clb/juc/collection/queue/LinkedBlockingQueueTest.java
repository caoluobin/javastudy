package org.clb.juc.collection.queue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingQueueTest {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        LinkedBlockingQueue queue =  new LinkedBlockingQueue(10);

        new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                try {
                    queue.put("cc"+i);
                    System.out.println("放入cc"+i);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"threadA").start();
        new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                try {
                    Object take = queue.take();
                    System.out.println("取出"+take);
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"threadB").start();
    }
}
