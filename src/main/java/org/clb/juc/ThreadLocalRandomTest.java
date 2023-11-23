package org.clb.juc;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ThreadLocalRandomTest {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
    }
    private static final long GAMMA = 0x9e3779b97f4a7c15L;
    public static void test() {
        MetaObject metaObject = SystemMetaObject.forObject(Thread.currentThread());
        ThreadLocalRandom current = ThreadLocalRandom.current();
        long seed = (long)metaObject.getValue("threadLocalRandomSeed");
        System.out.println("threadLocalRandomSeed"+seed);
        System.out.println("seed+GAMMA:"+(seed+GAMMA));
        System.out.println("mixSeed:"+mix32(seed));
        System.out.println("mixSeed+GAMMA:"+mix32(seed+GAMMA));
        for (int i = 0; i < 3; i++) {
            System.out.println("============================================");
            System.out.println(current.nextInt());
            seed = (long)metaObject.getValue("threadLocalRandomSeed");
            System.out.println("threadLocalRandomSeed:"+seed);
            System.out.println("seed+GAMMA:"+(seed+GAMMA));
            System.out.println("mixSeed:"+mix32(seed));
            System.out.println("mixSeed+GAMMA:"+mix32(seed+GAMMA));
        }

    }
    private static int mix32(long z) {
        z = (z ^ (z >>> 33)) * 0xff51afd7ed558ccdL;
        return (int)(((z ^ (z >>> 33)) * 0xc4ceb9fe1a85ec53L) >>> 32);
    }
    public static void test1() throws InterruptedException {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        MetaObject metaObject = SystemMetaObject.forObject(Thread.currentThread());
        System.out.println("threadLocalRandomSeed"+metaObject.getValue("threadLocalRandomSeed"));
        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            new Thread(() ->{
                //因为当前子线程的seed值没有被初始化  所以都是从0开始新增 因此都一样
                MetaObject metaObject2 = SystemMetaObject.forObject(Thread.currentThread());
                System.out.println(current.nextInt());
                System.out.println("threadLocalRandomSeed"+metaObject2.getValue("threadLocalRandomSeed"));
//                System.out.println(current.nextInt());
            }).start();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println("==========================================");
        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                ThreadLocalRandom localRandom = ThreadLocalRandom.current();
                MetaObject ra = SystemMetaObject.forObject(localRandom);
                System.out.println(ra.getValue("seed"));
                System.out.println(localRandom.nextInt());
            }).start();
        }
    }
}
