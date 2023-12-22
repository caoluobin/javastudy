package org.clb.juc.thread.reference.phantom;

import sun.misc.Cleaner;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;

public class DirectT {

    private Cleaner cleaner;

    private static boolean flag = true;


    public DirectT() {
        this.cleaner = Cleaner.create(this, () -> {
            System.out.println("被回收了");
        });
    }


    public static void main(String[] args) throws InterruptedException {
        test3();
    }

    public static void test() {
        //当虚引用引用的对象被回收时  会把虚引用对象放入queue中
        new Thread(() -> {
            while (DirectT.flag) {
                DirectT directT = new DirectT();
                directT = null;
                try {
//                    Thread.sleep(1000);
                    System.gc();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        // 让虚引用对象被创建
        Reference<?> poll = CleanerT.dummyQueue.poll();
        while (poll == null) {
            poll = CleanerT.dummyQueue.poll();
            System.out.println("ccc");
        }
        DirectT.flag = false;
        System.out.println("poll===" + poll);
    }

    public static void test2() {
        CleanerT cleanerT1 = new CleanerT(new Object());
        cleanerT1 = null;
        System.gc();
        Reference<?> poll = CleanerT.dummyQueue.poll();
        while (poll == null) {
            poll = CleanerT.dummyQueue.poll();
            System.out.println("ccc");
        }
        System.out.println("poll===" + poll);
    }

    public static void test3() throws InterruptedException {
        DirectT directT = new DirectT();
        DirectT directT2 = new DirectT();
        directT= null;
        System.gc();
        Thread.sleep(4000);
    }
}
