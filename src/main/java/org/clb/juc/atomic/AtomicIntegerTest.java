package org.clb.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    private static AtomicInteger nextHashCode =
            new AtomicInteger();

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
//        int increment = nextHashCode.getAndIncrement();
//        System.out.println(increment);
//        increment = nextHashCode.getAndIncrement();
//        System.out.println(increment);
//        System.out.println(nextHashCode.get());

        for (long i = 0; i < 99999999; i++) {
            for (int j = 0; j < 10000000; j++) {

                int andIncrement = nextHashCode.getAndIncrement();
                if (andIncrement==1) {
                    System.out.println("sssssssssss");
                }

            }
        }
    }


}
