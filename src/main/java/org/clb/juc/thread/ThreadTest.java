package org.clb.juc.thread;

import java.util.concurrent.TimeUnit;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        joinTest();
    }
    public static void joinTest() throws InterruptedException {
        Thread thread =new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thread 结束");
        });
        thread.start();
        thread.join();
        System.out.println("join");
    }

    public static void yeildTest() throws InterruptedException {
        Thread thread =new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thread 结束");
        });
        thread.start();

        System.out.println("join");
    }
}
