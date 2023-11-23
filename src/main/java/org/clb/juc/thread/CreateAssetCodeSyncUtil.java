package org.clb.juc.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 鐢熸垚璧勪骇鏉＄爜澶氱嚎绋嬪伐鍏风被
 * Author jisai
 * Date 2022/2/17 11:15
 */
public class CreateAssetCodeSyncUtil {

    private static final Map<Long, ReentrantLock> MU_TEX_CACHE = new ConcurrentHashMap<>();

    private static Integer num=1;
    public static void exec(Long key, Runnable task){
        ReentrantLock newLock;
        ReentrantLock lock = null;
        do {
            if (lock != null){
                lock.unlock();
            }
            lock = MU_TEX_CACHE.computeIfAbsent(key, k -> new ReentrantLock());
            lock.lock();
            newLock = MU_TEX_CACHE.get(key);
        }while (newLock == null || newLock != lock);
        try {
            task.run();
        }finally {
            if (lock.getQueueLength() == 0){
                MU_TEX_CACHE.remove(key);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(()->{
                CreateAssetCodeSyncUtil.exec(Long.parseLong((finalI %2+1)+""),()-> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(num++);
                });
            }).start();
        }
    }
}
