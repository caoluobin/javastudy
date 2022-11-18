package org.clb.aqs;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_YEAR,174);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.format(cal.getTime()));
//        System.out.println("123".substring(0,2));
//        Semaphore semaphore = new Semaphore(2);
//        try {
//            semaphore.acquire(2);
//            semaphore.acquire();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }

    public static void  test1(){
        Semaphore semaphore = new Semaphore(2);
        Map<Integer,Thread> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Thread thread = new Thread(()->{
                semaphore.acquireUninterruptibly();
                System.out.println(Thread.currentThread().getName()+"�õ���Դ");
            },"thread"+i);
            thread.start();
            map.put(i,thread);
        }
        Thread thread = map.get(2);
        System.out.println("���");
        thread.interrupt();

    }
    public static void  test2(){
        Semaphore semaphore = new Semaphore(2);
        Map<Integer,Thread> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Thread thread = new Thread(()->{
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+"�õ���Դ");
            },"thread"+i);
            thread.start();
            map.put(i,thread);
        }
        Thread thread = map.get(2);
        System.out.println("���");
        thread.interrupt();

    }

    public static void releaseTest(){
        Semaphore semaphore = new Semaphore(2);
        semaphore.release();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"��ȡ��Դ");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            },"thread"+i).start();
        }
    }
}
