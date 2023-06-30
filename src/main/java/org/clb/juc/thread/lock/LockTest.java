package org.clb.juc.thread.lock;

import org.clb.pojo.User;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;

public class LockTest {
    private  DefaultLockFactory factory=new DefaultLockFactory();
    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                LockTest test = new LockTest();
                test.test();
            }).start();

        }

    }

    public void test(){
    }
}
