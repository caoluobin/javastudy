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
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(
            1);
//        executor.schedule(()->{
//            try {
//                Thread.sleep(1000);
//                System.out.println(new Date());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        },1, TimeUnit.SECONDS);
        //�̶�ʱ����ִ��
//        executor.scheduleAtFixedRate(()->{
//            try {
//                Thread.sleep(1000);
//                System.out.println(new Date());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        },0,2, TimeUnit.SECONDS);
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

