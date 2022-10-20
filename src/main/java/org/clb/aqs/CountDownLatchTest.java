package org.clb.aqs;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) {
        test1();
    }
    /**
     * ����CountDownLatch  await���߳��Ǳ���̻��ѵ�
     */
    public static void test1(){
        CountDownLatch count=new CountDownLatch(1);
        Thread thread1 = new Thread(()->{
            try {
                Thread.sleep(100);
                System.out.println("thread1��ʼ�ȴ�");
                count.await();
                System.out.println("thread1�ȴ�����");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"thread1");
        Thread thread2 = new Thread(()->{
            try {
                Thread.sleep(500);
                System.out.println("thread2��ʼ�ȴ�");
                count.await();
                System.out.println("thread2�ȴ�����");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"thread2");
        Thread thread3 = new Thread(()->{
            try {
                Thread.sleep(900);
                System.out.println("thread3��ʼ�ȴ�");
                count.await();
                System.out.println("thread3�ȴ�����");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"thread3");
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            Thread.sleep(2000);
            count.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
