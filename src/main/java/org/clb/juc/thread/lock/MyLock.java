package org.clb.juc.thread.lock;

public interface MyLock {
    public void lock();

    public void lock(String name);

    public void unlock();

    public void unlock(String name);
}
