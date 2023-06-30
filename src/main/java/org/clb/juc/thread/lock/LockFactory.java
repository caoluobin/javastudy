package org.clb.juc.thread.lock;

public interface LockFactory {
     MyLock getLock(String key);
}
