package org.clb;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        whenCompleteTest();
//        thenApplyTest();
//        thenComposeTest();
//        System.out.println(advanceProbe(1));
//        System.out.println(10>>1);
//        System.out.println(10>>>1);
//        System.out.println(-10>>1);
//        System.out.println(-10>>>1);
        System.out.println(0x61c88647);
        Thread thread = new Thread();

    }
    static final int advanceProbe(int probe) {
        probe ^= probe << 13;   // 0000000000001   100000000001
        probe ^= probe >>> 17; //100000000001
        probe ^= probe << 5;
        return probe;
    }

    public void test(Thread thread) {

    }


    public static void test1() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> a = CompletableFuture.runAsync(() -> {
            System.out.println("aִ��");
        });//�첽���� ���׳��쳣
        CompletableFuture<String> g = CompletableFuture.supplyAsync(() -> {
            System.out.println("bִ��");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "aaaa";
        });
        System.out.println(g.join());//������ȡ���  ����Ҫ�����쳣
        System.out.println(g.get());//������ȡ���   ��Ҫ����ExecutionException, InterruptedException�쳣
    }
    public static void whenCompleteTest() throws InterruptedException {
        CompletableFuture<Void> a = CompletableFuture.runAsync(() -> {
            System.out.println("aִ��");
            int c =1/0;
        });
        CompletableFuture<String> g = CompletableFuture.supplyAsync(() -> {
            System.out.println("bִ��");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "aaaa";
        });
        a.whenComplete((result,exception)->{
            System.out.println(exception.getMessage());
            System.out.println(result);
        });//�첽������
        g.whenComplete((result,exception)->{
            System.out.println(result);
        });//�첽������
        TimeUnit.SECONDS.sleep(2);
    }
    public static void thenApplyTest() {
        CompletableFuture<Integer> c = CompletableFuture.supplyAsync(() -> {
            return 111;
        }).thenApply(a -> {
            return a + 10;
        });
        System.out.println(c.join());

    }

    public static void thenComposeTest() {
        CompletableFuture<Integer> c = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 111;
        }).thenCompose(a->CompletableFuture.supplyAsync(() -> {
            return a+1;
        }));//���ݵ�һ������Ľ�����ж��μ���
        System.out.println("aaaa");
        System.out.println(c.join());

    }
}
