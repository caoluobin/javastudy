package org.clb.juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static Integer a = 0;

    public static void main(String[] args) throws InterruptedException {
        unLockTest();
    }

    public static void unLockTest() {
        lock.unlock();
    }

    /**
     * 测试公平锁当队列中有线程等待时需要需要进入队列等待
     */
    public static void fairTest1() throws InterruptedException {
        ReentrantLock fairLock = new ReentrantLock(true);
        for (int i = 1; i < 40; i++) {
            //睡10ms保证前面是按序
            if (i <= 20)
                Thread.sleep(10);
            int finalI = i;
            new Thread(() -> {
                try {
                    fairLock.lock();
                    if (finalI == 1) {
                        while (fairLock.getQueueLength() <= 20) {//保证有至少10个数据是在队列中等待的
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + "执行,等待数量" + fairLock.getQueueLength());
                } finally {
                    fairLock.unlock();
                }
            }, "thread" + i).start();
        }
    }

    /**
     * 测试非公平锁当队列中的数据会按序执行
     */
    public static void fairTest2() throws InterruptedException {
        ReentrantLock fairLock = new ReentrantLock();
        for (int i = 1; i < 21; i++) {
            //睡10ms保证按序进入队列
            Thread.sleep(10);
            int finalI = i;
            new Thread(() -> {
                try {
                    fairLock.lock();
                    if (finalI == 1) {
                        while (fairLock.getQueueLength() < 19) {//保证另外19个线程都在队列中等待
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + "执行,等待数量" + fairLock.getQueueLength());
                } finally {
                    fairLock.unlock();
                }
            }, "thread" + i).start();
        }
    }

    /**
     * 测试非公平锁当队列中有数据时后续新进入的线程可以和头结点进行竞争
     */
    public static void fairTest3() throws InterruptedException {
        ReentrantLock fairLock = new ReentrantLock();
        for (int i = 1; i < 40; i++) {
            //睡10ms保证前面是按序
            if (i <= 10)
                Thread.sleep(20);
            int finalI = i;
            new Thread(() -> {
                try {
                    fairLock.lock();
                    if (finalI == 1) {
                        while (fairLock.getQueueLength() <= 20) {//保证有至少10个数据是在队列中等待的
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + "执行,等待数量" + fairLock.getQueueLength());
                } finally {
                    fairLock.unlock();
                }
            }, "thread" + i).start();
        }
    }

    public static void tryLockTest() throws InterruptedException {
        new Thread(() -> {
            try {
                lock.lock();
                System.out.println(Thread.currentThread() + "加锁");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread() + "释放锁");
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        String flag = lock.tryLock() ? "成功" : "失败";
        System.out.println("获取锁" + flag);
    }


    static class RLRunnable implements Runnable {
        @Override
        public void run() {
            try {
//                lock.lock();
                a++;
            } finally {
//                lock.unlock();
            }

        }
    }
}
