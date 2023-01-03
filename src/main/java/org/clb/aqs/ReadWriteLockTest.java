package org.clb.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    public static void main(String[] args) throws InterruptedException {
        test2();
    }

    public static void test1() {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        new Thread(()->{
            try {
                System.out.println("��ȡд��");
                writeLock.lock();
                TimeUnit.SECONDS.sleep(2);
                System.out.println("�ͷ�д��");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                writeLock.unlock();
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    System.out.println("����"+Thread.currentThread().getName()+"����");
                    readLock.lock();
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("����"+Thread.currentThread().getName()+"��ȡ");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    readLock.unlock();
                }
            },"thread"+i).start();
        }
    }

    public static void test2() throws InterruptedException {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    readLock.lock();
                    System.out.println("����"+Thread.currentThread().getName()+"��ȡ");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println("����"+Thread.currentThread().getName()+"�ͷ�");
                    readLock.unlock();
                }
            },"thread"+i).start();
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(()->{
            try {
                writeLock.lock();
                System.out.println("��ȡд��");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("�ͷ�д��");
                writeLock.unlock();
            }
        }).start();
        for (int i = 10; i < 20; i++) {
            new Thread(()->{
                try {
                    readLock.lock();
                    System.out.println("����"+Thread.currentThread().getName()+"��ȡ");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println("����"+Thread.currentThread().getName()+"�ͷ�");
                    readLock.unlock();
                }
            },"thread"+i).start();
        }
    }
}
