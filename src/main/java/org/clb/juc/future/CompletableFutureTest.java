package org.clb.juc.future;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @Description
 * @Classname CompletableFuture
 * @Date 2022/11/18 5:27
 * @Author clb
 */
public class CompletableFutureTest {

    private static final Map<String, BigDecimal> map = new HashMap() {
        {
            put("mysql", new BigDecimal(111));
            put("jvm", new BigDecimal(50));
        }
    };

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList() {
            {
                add("mysql");
                add("jvm");
                add("jvm2");
            }
        };
//        test1(list);
//        test2(list);
//        CompletableFuture<BigDecimal> cf = CompletableFuture.supplyAsync(() -> taskGetPrice("11"));
//        Thread.sleep(2000);
//        System.out.println(cf.complete(new BigDecimal(22)));
//        System.out.println(cf.join());
        poolTest();
    }

    /**
     * 正常串式调用
     */
    public static void test1(List<String> products) {
        long start = System.currentTimeMillis();
        List<BigDecimal> list = products.stream().map(a -> taskGetPrice(a)).collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println(System.currentTimeMillis() - start);
    }

    /**
     * CompletableFuture并行调用
     */
    public static void test2(List<String> products) {
        long start = System.currentTimeMillis();
        List<BigDecimal> list = products.stream().map(a -> CompletableFuture.supplyAsync(() -> taskGetPrice(a))).collect(Collectors.toList()).stream().map(a -> a.join()).collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println(System.currentTimeMillis() - start);
    }


    public static BigDecimal taskGetPrice(String product) {
        try {
            //模拟查询时间
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map.getOrDefault(product, new BigDecimal(0));
    }

    public static void thenApply() {
        long start = System.currentTimeMillis();
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> 1).thenApply(a -> a + 1);
        System.out.println(cf.join());
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void handle() {
        long start = System.currentTimeMillis();
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
            return 1;
        }).handle((a, e) -> {
            int i = 1 / 0;
            System.out.println("111");
            return a + 1;
        }).handle((a, e) -> {
            System.out.println("222");
            return a + 1;
        }).handle((a, e) -> {
            System.out.println("333");
            return a + 1;
        }).handle((a, e) -> {
            if (e != null) {
                return 44;
            } else {
                return 222;
            }
        });
        System.out.println(cf.join());
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void poolTest() {
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "aa";
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        });
    }

    public static void applyToEither() {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "aa";
        });
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "aa";
        });
        CompletableFuture<String> cf3 = cf1.applyToEither(cf2, b -> {
            return b;
        });
        System.out.println(cf3.join());
    }

    public static void thenCombine() {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "aa";
        });
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "aa";
        });
        CompletableFuture<String> cf3 = cf1.thenCombine(cf2, (a, b) -> {
            return a + b;
        });
        System.out.println(cf3.join());
    }
}
