package org.clb.juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    public static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public static final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    public static final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    public static Integer count = 0;

    public static Integer getCount() {
        try {
            readLock.lock();
            return count;
        } finally {
            readLock.unlock();
        }
    }

    public static void countAdd() {
        try {
            writeLock.lock();
            count++;
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        test4();

    }

    public static void test1() {
        new Thread(()->{
            try {
                System.out.println("获取写锁");
                writeLock.lock();
                TimeUnit.SECONDS.sleep(2);
                System.out.println("释放写锁");
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
                    System.out.println("读锁"+Thread.currentThread().getName()+"进入");
                    readLock.lock();
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("读锁"+Thread.currentThread().getName()+"获取");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    readLock.unlock();
                }
            },"thread"+i).start();
        }
    }

    public static void test2() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    readLock.lock();
                    System.out.println("读锁"+Thread.currentThread().getName()+"获取");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println("读锁"+Thread.currentThread().getName()+"释放");
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
                System.out.println("获取写锁");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("释放写锁");
                writeLock.unlock();
            }
        }).start();
        for (int i = 10; i < 20; i++) {
            new Thread(()->{
                try {
                    readLock.lock();
                    System.out.println("读锁"+Thread.currentThread().getName()+"获取");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println("读锁"+Thread.currentThread().getName()+"释放");
                    readLock.unlock();
                }
            },"thread"+i).start();
        }
    }

    public static void test3() throws InterruptedException {
        //先有读锁 同一线程也不能被写锁重入

        new Thread(()->{
            String name = Thread.currentThread().getName();
            try {
                readLock.lock();
                System.out.println(name+"加读锁");
                writeLock.lock();
                System.out.println(name+"加写锁");
                TimeUnit.SECONDS.sleep(4);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                readLock.unlock();
                System.out.println(name+"释放读锁");
                writeLock.unlock();
                System.out.println(name+"释放写锁");
            }
        },"线程1").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            String name = Thread.currentThread().getName();
            try {
                readLock.lock();
                System.out.println(name+"加读锁");
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                readLock.unlock();
                System.out.println(name+"释放读锁");
            }
        }).start();
    }


    public static void test4() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                ReadWriteLockTest.countAdd();
            }).start();
        }
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                ReadWriteLockTest.getCount();
            }).start();
        }

        TimeUnit.SECONDS.sleep(5);
        System.out.println(ReadWriteLockTest.getCount());
    }
}
