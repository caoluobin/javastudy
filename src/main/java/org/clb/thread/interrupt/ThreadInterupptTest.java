package org.clb.thread.interrupt;

public class ThreadInterupptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
//            try {
//                Thread.sleep(1000*10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            long l = System.currentTimeMillis();
            while (System.currentTimeMillis()-l<10000){

            }
            System.out.println("��һ��");


        });
        thread.start();
        thread.interrupt();//�ж��߳�ʹ���λΪtrue
        //Thread.currentThread().sleep(1000*3);
        //System.out.println(Thread.currentThread().getName());
        thread.interrupted();//������λ ʹ���λΪfalse
        thread.isInterrupted();//�鿴���λ
        //System.out.println(thread.interrupted());

        System.out.println(thread.isInterrupted());
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
