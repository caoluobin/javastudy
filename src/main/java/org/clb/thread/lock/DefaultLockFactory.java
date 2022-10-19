package org.clb.thread.lock;

import org.apache.ibatis.reflection.Reflector;
import org.apache.ibatis.util.MapUtil;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DefaultLockFactory implements LockFactory {


    private  final ConcurrentMap<String, Lock> lockMap = new ConcurrentHashMap<>();

    @Override
    public Lock getLock(String key) {
        if (lockMap.containsKey(key)) {
            return lockMap.get(key);
        } else {
            if ("nameLock".equals(key))
                lockMap.putIfAbsent(key, new NameLock());
            return lockMap.get(key);
        }
    }
}
