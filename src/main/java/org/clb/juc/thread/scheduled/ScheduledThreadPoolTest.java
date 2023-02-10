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
        scheduleWithFixedDelayTest();
    }
    public static void scheduleTest() {
                executor.schedule(()->{
            try {
                Thread.sleep(1000);
                System.out.println(new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },1, TimeUnit.SECONDS);
    }

    public static void scheduleAtFixedRateTest() {
        //�̶�ʱ����ִ��
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
        //һ������ִ������ӳ�delayʱ��ִ��
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

