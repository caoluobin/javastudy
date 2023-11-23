package org.clb.juc.thread.thread_pool;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyThreadPool extends ThreadPoolExecutor {

    public static ThreadLocal<String> tokenThreadLocal = new ThreadLocal<>();
    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public static MyThreadPool getInstance() {
        return   new MyThreadPool(4, 10,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10));
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        System.out.println("before  poolSize"+super.getPoolSize());
        if (r instanceof MyFutureTask) {
            MyFutureTask futureTask = (MyFutureTask) r;
            String token = futureTask.getToken();
            System.out.println("获取token"+token);
            tokenThreadLocal.set(token);
        }else {
            try {
                Class<?> aClass = Class.forName("java.util.concurrent.CompletableFuture$AsyncSupply");
                if (r.getClass().equals(aClass)){
                    Field fn = r.getClass().getDeclaredField("fn");
                    fn.setAccessible(true);
                    if (fn!=null){
                        Object task = fn.get(r);
                        if (task instanceof MySupplierTask){
                            MySupplierTask futureTask = (MySupplierTask)task ;
                            String token = futureTask.getToken();
                            System.out.println("获取token"+token);
                            tokenThreadLocal.set(token);
                        }
                    }
                }
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        tokenThreadLocal.remove();
//        r.run();
        System.out.println("after  poolSize"+super.getPoolSize());
        System.out.println("after 已完成任务==>"+super.getCompletedTaskCount());
    }

    public <T> Future<T> submit(MyFutureTask task) {
        if (task == null) throw new NullPointerException();
        execute(task);
        return task;
    }

    public static void main(String[] args) {
        String token ="eyJhbGciOiJIUzUxMiJ9.eyJ0eXBlIjoxLCJleHAiOjE2NzM1NzY4NzksInVzZXJJZCI6NzMxODY5MTA1MzEyOTYwNTEyLCJhY2NvdW50TmFtZSI6ImNhb2x1b2JpbiIsImlhdCI6MTY3MDk4NDg3OSwib3JnSWQiOjYzOTUzNjczMTQ1MTExNzU3MX0.Dz8CjHPagg1X44Ie-4NyEdVUzcyVGjU6JOwmcb8wMKMsXI0oOKtjKLxCj39Gor5NItBrA6Y1w6P6izLDpT6JFA";
        MyThreadPool threadPool = new MyThreadPool(2, 4,
                0L, TimeUnit.MILLISECONDS,
                new LinkedTransferQueue<>());
        List<String> list= new ArrayList<>();
        list.add("acc");
        list.add("add");
        list.add("aee");
        Callable callable =()->{
            int a=1/0;
            return 0;
        };
        Future future = threadPool.submit(callable);
        try {
            Object o = future.get();
            System.out.println("result======================"+o);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

//        Future<Object> future = threadPool.submit(new MyFutureTask(() -> {
//            String threadToken = threadPool.tokenThreadLocal.get();
//            System.out.println("threadToken==========================>" + threadToken);
//            ResultRes<List<EconomicSubEntity>> economicSubListAllData = userClient.getEconomicSubListAllData(2022);
//            System.out.println("result==============================> " + economicSubListAllData.toString());
//            return economicSubListAllData;
//        }, token));
//        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(new MySupplierTask(token,() -> {
//            String threadToken = threadPool.tokenThreadLocal.get();
//            System.out.println("threadToken==========================>" + threadToken);
//            System.out.println("result==============================> ");
//            return 10;
//        }), threadPool);
        CompletableFuture<Object> a = CompletableFuture.supplyAsync(() ->{
            return 1;
        });
        CompletableFuture<Object> b = CompletableFuture.supplyAsync(() ->{
            return 1;
        });
        CompletableFuture<Object> c = CompletableFuture.supplyAsync(() ->{
            return 1;
        });
        CompletableFuture<Void> f = CompletableFuture.allOf(a, b, c).whenComplete((dd, aa) -> {

        });
//        f.get();
        threadPool.shutdown();
    }

}
