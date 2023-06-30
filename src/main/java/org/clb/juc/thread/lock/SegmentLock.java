package org.clb.juc.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SegmentLock {

    private int defaultSegmentCount = 16;
    private final Lock[] locks;

    public SegmentLock() {
        this.locks = new ReentrantLock[defaultSegmentCount];
        for (int i = 0; i < defaultSegmentCount; i++) {
            locks[i] = new ReentrantLock();
        }
    }

    private int getSegment(Object key) {
        return Math.abs(key.hashCode() % defaultSegmentCount);
    }

    public Lock lock(Object key) {
        int segment = getSegment(key);
        return locks[segment];
    }

}
