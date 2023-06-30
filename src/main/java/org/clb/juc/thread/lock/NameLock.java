package org.clb.juc.thread.lock;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class NameLock implements MyLock{
    private ConcurrentHashMap<Integer, ReentrantLock> lockMap = new ConcurrentHashMap<>();
    private ReentrantLock lock = new ReentrantLock();
    private Integer lockCount=16;
    public NameLock() {
        for (int i = 0; i < 16; i++) {
            lockMap.put(i,new ReentrantLock());
        }
    }

    @Override
    public void lock() {
        lock.lock();
    }

    /**
     *
     * @param name
     */
    @Override
    public void lock(String name) {
        ReentrantLock lock =lockMap.get(Math.abs(System.identityHashCode(name)%lockCount));
        lock.lock();
    }

    @Override
    public void unlock() {
        lock.unlock();
    }

    @Override
    public void unlock(String name) {
        ReentrantLock lock = this.lockMap.get(Math.abs(System.identityHashCode(name)%lockCount));
        lock.unlock();
    }

}
