package org.clb.juc.thread.threadLocal;

import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->10);

    public static void main(String[] args) throws InterruptedException {

    }

    /**
     * threadLocal set����Ҫ��ʱremove  ��ֹ�ڴ�й©
     */
    public static void test1() {
        threadLocal.set(10);
        try {

        } finally {
            threadLocal.remove();
        }
    }
}
