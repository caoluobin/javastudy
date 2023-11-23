package org.clb.juc.thread.scheduled;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Classname ScheduledThreadPoolTest
 * @Date 2021/5/30 21:15
 * @Author clb
 */
public class ScheduledThreadPoolTest {
    public static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(
            3);
    public static void main(String[] args) {
        scheduleTest();
    }
    public static void scheduleTest() {
        executor.schedule(()->{
            try {
                System.out.println(new Date());
                Thread.sleep(1000);
                System.out.println(new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },3, TimeUnit.SECONDS);
        executor.shutdown();
    }

    public static void scheduleAtFixedRateTest() {
        //固定时间间隔执行
        executor.scheduleAtFixedRate(()->{
            try {
                Thread.sleep(1000);
                System.out.println(new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },0,2, TimeUnit.SECONDS);
    }

    public static void scheduleWithFixedDelayTest() {
        //一个任务执行完后延迟delay时间执行
        executor.scheduleWithFixedDelay(()->{
            try {
                Thread.sleep(3000);
                System.out.println(new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },0,2, TimeUnit.SECONDS);
    }
}

