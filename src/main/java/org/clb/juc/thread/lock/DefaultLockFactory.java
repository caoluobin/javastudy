package org.clb.juc.thread.lock;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DefaultLockFactory implements LockFactory {


    private  final ConcurrentMap<String, MyLock> lockMap = new ConcurrentHashMap<>();

    @Override
    public MyLock getLock(String key) {
        if (lockMap.containsKey(key)) {
            return lockMap.get(key);
        } else {
            if ("nameLock".equals(key))
                lockMap.putIfAbsent(key, new NameLock());
            return lockMap.get(key);
        }
    }
}
