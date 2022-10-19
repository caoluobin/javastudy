package org.clb.thread.interrupt;

public class ThreadInterupptTest2 {
    public static void main(String[] args) {
        ThreadInterupptTest2 t2=new ThreadInterupptTest2();
        Thread t=new Thread(()->{
            synchronized (t2){
                long l = System.currentTimeMillis();
                while (System.currentTimeMillis()-l<1000){

                }
                try {
                    System.out.println("���"+Thread.interrupted());
//                    System.out.println("thread==>1"+Thread.currentThread().isInterrupted());
//                    t2.wait();
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (System.currentTimeMillis()-l<2000){

                }
//                System.out.println("thread==>2"+Thread.currentThread().isInterrupted());
//                System.out.println("thread==>3"+Thread.interrupted());
            }
        });
//        System.out.println("main=="+t.isInterrupted());
        t.start();
        t.interrupt();
        System.out.println("main=="+t.isAlive()+t.isInterrupted());
        System.out.println("main=="+t.isAlive()+t.isInterrupted());
        long now=System.currentTimeMillis();
        while (System.currentTimeMillis()-now<2000){

        }
        System.out.println("main=="+t.isAlive()+t.isInterrupted());
    }
}
