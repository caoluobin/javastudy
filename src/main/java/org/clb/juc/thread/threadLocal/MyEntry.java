package org.clb.juc.thread.threadLocal;

import org.clb.pojo.User;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyEntry extends WeakReference<ThreadLocal<?>> {

    Object value;

    MyEntry(ThreadLocal<?> k, Object v) {
        super(k);
        value = v;
    }

    public static void main(String[] args) throws InterruptedException {
        weakReferenceTest();
    }

    public static void weakTest() {
        User user = User.getDefaultUser();
        WeakReference reference = new WeakReference(user);
        System.gc();
        int a = 0;
        List<User> list = new ArrayList<>();
        while (true) {
            if (reference.get() != null) {
//                System.out.println(reference.get());
            } else {
                System.out.println("结束====>" + a);
                break;
            }
            list.add(User.getDefaultUser());
            a++;
//            TimeUnit.SECONDS.sleep(1);
//            System.gc();
        }
    }

    public static void weakReferenceTest() throws InterruptedException {
        ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        MyEntry entry =new MyEntry(new ThreadLocal<>(), 10);
        MyEntry entry2 =new MyEntry(threadLocal, 10);
        System.out.println(entry.get());
        System.out.println(entry2.get());
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(entry.get());
        System.out.println(entry2.get());
    }
}
