package org.clb.juc.thread.scheduled;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Classname MySechduled
 * @Date 2021/5/30 21:48
 * @Author clb
 */
public class MySechduled  extends ScheduledThreadPoolExecutor {
    public static void main(String[] args) {
        MySechduled mySechduled=new MySechduled(1);
        mySechduled.scheduleWithFixedDelay(()->{
                        try {
                            Thread.sleep(3000);
                            System.out.println(new Date());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    },0,2, TimeUnit.SECONDS);
    }
    public MySechduled(int corePoolSize) {
        super(corePoolSize);
    }

    public MySechduled(int corePoolSize, ThreadFactory threadFactory) {
        super(corePoolSize, threadFactory);
    }

    public MySechduled(int corePoolSize, RejectedExecutionHandler handler) {
        super(corePoolSize, handler);
    }

    public MySechduled(int corePoolSize, ThreadFactory threadFactory,
        RejectedExecutionHandler handler) {
        super(corePoolSize, threadFactory, handler);
    }

    @Override
    protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable,
        RunnableScheduledFuture<V> task) {
        System.out.println("调用钩子函数");
        return super.decorateTask(runnable, task);
    }

    @Override
    protected <V> RunnableScheduledFuture<V> decorateTask(Callable<V> callable,
        RunnableScheduledFuture<V> task) {
        System.out.println("调用钩子函数");
        return super.decorateTask(callable, task);
    }


}
