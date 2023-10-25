package org.clb.juc.synchronize;

public class SyncDemo {
    int count=0;

    public static void main(String[] args) {
        SyncDemo syncDemo = new SyncDemo();
        SyncDemo syncDemo2 = new SyncDemo();

        new Thread(()->{
            try {
                syncDemo.add();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()->{
            try {
                syncDemo2.de();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public synchronized void add() throws InterruptedException {
        Thread.sleep(1000);
        count++;
        System.out.println("add");
    }
    public synchronized void de() throws InterruptedException {
        Thread.sleep(1000);
        count--;
        System.out.println("de");
    }
}
