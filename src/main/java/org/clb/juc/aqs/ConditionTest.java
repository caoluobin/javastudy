package org.clb.juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        test();
    }

    public static void test() throws InterruptedException {

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "µÈ´ý1");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "µÈ´ý2");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "³å");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }, "ThreadB").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "111");
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "222");
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "333");
            } finally {
                lock.unlock();
            }
        }, "ThreadA").start();
    }
}
