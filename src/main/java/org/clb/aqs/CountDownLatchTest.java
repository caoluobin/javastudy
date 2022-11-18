package org.clb.aqs;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) {
//        test1();
        test2();
    }
    public static void test2(){
        CountDownLatch count=new CountDownLatch(1);
        try {
            count.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * ����CountDownLatch  await���߳��Ǳ���̻��ѵ�
     */
    public static void test1(){
        CountDownLatch count=new CountDownLatch(1);
        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Thread thread = new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"��ʼ�ȴ�");
                    count.await();
                    System.out.println(Thread.currentThread().getName()+"�ȴ�����");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            },"thread"+i);
            thread.start();
        }

        try {
//            count.await();
            Thread.sleep(1100);
            count.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
