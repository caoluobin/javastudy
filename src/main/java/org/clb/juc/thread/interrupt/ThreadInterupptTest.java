package org.clb.juc.thread.interrupt;

public class ThreadInterupptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
//            try {
//                Thread.sleep(1000*10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            long l = System.currentTimeMillis();
            while (System.currentTimeMillis() - l < 1) {

            }
            System.out.println("第一次");


        });
        thread.start();
        thread.interrupt();//中断线程使标记位为true
        //Thread.currentThread().sleep(1000*3);
        //System.out.println(Thread.currentThread().getName());
        Thread.interrupted();//清除标记位 使标记位为false
        thread.isInterrupted();//查看标记位
        //System.out.println(thread.interrupted());
        for (int i = 0; i < 1000; i++) {

            System.out.println(thread.isAlive() + "==" + thread.isInterrupted());
        }

//        Thread.sleep(1000*1);
//        System.out.println("====");
//        thread.interrupt();
        //Thread.sleep(1000*1);
//        thread.interrupted();
//        System.out.println(thread.isInterrupted());
//        Thread.sleep(1000*1);
//        System.out.println("====");
//        thread.interrupt();
//        System.out.println(thread.isInterrupted());


    }
}
