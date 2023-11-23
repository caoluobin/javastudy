package org.clb.juc.thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class ARunnable implements Runnable {
    public static final ReentrantLock lock = new ReentrantLock();
    public static final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    private static  Integer num =1;



    @Override
    public void run() {

        try {
//            lock.lock();
//            if (num==1) Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "==="+num++);
//            Thread.sleep(200);
        } catch (Exception e) {

        } finally {
//            lock.unlock();
        }

    }

    public static void main(String[] args) {

//        map.put("1","1");
//        System.out.println(map.putIfAbsent("1", "2"));
//        System.out.println(map.get("1"));
        for (int i = 0; i < 200; i++) {
            new Thread(new ARunnable()).start();
//            (new ARunnable()).run();
        }

        //1.将值放入redis setnx  如果成功就继续  失败则返回
        //2.取值查数据库 如果有就返回 没有就插入
    }
}
