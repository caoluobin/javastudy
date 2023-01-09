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

    public static void test3() throws InterruptedException {
        //���ж��� ͬһ�߳�Ҳ���ܱ�д������

        new Thread(()->{
            String name = Thread.currentThread().getName();
            try {
                readLock.lock();
                System.out.println(name+"�Ӷ���");
                writeLock.lock();
                System.out.println(name+"��д��");
                TimeUnit.SECONDS.sleep(4);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                readLock.unlock();
                System.out.println(name+"�ͷŶ���");
                writeLock.unlock();
                System.out.println(name+"�ͷ�д��");
            }
        },"�߳�1").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            String name = Thread.currentThread().getName();
            try {
                readLock.lock();
                System.out.println(name+"�Ӷ���");
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                readLock.unlock();
                System.out.println(name+"�ͷŶ���");
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
