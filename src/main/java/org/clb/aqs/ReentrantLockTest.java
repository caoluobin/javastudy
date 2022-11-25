package org.clb.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private static final ReentrantLock lock =new ReentrantLock();
    private static final Condition condition =lock.newCondition();
    private static Integer a = 0;
    public static void main(String[] args) throws InterruptedException {
        fairTest2();
    }

    /**���Թ�ƽ�������������̵߳ȴ�ʱ��Ҫ��Ҫ������еȴ�*/
    public static void fairTest1() throws InterruptedException {
        ReentrantLock fairLock = new ReentrantLock(true);
        for (int i = 1; i < 40; i++) {
            //˯10ms��֤ǰ���ǰ���
            if (i<=20)
                Thread.sleep(10);
            int finalI = i;
            new Thread(()->{
                try {
                    fairLock.lock();
                    if (finalI==1){
                        while (fairLock.getQueueLength()<=20){//��֤������10���������ڶ����еȴ���
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+"ִ��,�ȴ�����"+fairLock.getQueueLength());
                } finally {
                    fairLock.unlock();
                }
            },"thread"+i).start();
        }
    }
    /**���Էǹ�ƽ���������е����ݻᰴ��ִ��*/
    public static void fairTest2() throws InterruptedException {
        ReentrantLock fairLock = new ReentrantLock();
        for (int i = 1; i < 21; i++) {
            //˯10ms��֤����������
            Thread.sleep(10);
            int finalI = i;
            new Thread(()->{
                try {
                    fairLock.lock();
                    if (finalI==1){
                        while (fairLock.getQueueLength()<19){//��֤����19���̶߳��ڶ����еȴ�
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+"ִ��,�ȴ�����"+fairLock.getQueueLength());
                } finally {
                    fairLock.unlock();
                }
            },"thread"+i).start();
        }
    }
    /**���Էǹ�ƽ����������������ʱ�����½�����߳̿��Ժ�ͷ�����о���*/
    public static void fairTest3() throws InterruptedException {
        ReentrantLock fairLock = new ReentrantLock();
        for (int i = 1; i < 40; i++) {
            //˯10ms��֤ǰ���ǰ���
            if (i<=10)
                Thread.sleep(20);
            int finalI = i;
            new Thread(()->{
                try {
                    fairLock.lock();
                    if (finalI==1){
                        while (fairLock.getQueueLength()<=20){//��֤������10���������ڶ����еȴ���
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+"ִ��,�ȴ�����"+fairLock.getQueueLength());
                } finally {
                    fairLock.unlock();
                }
            },"thread"+i).start();
        }
    }
    public static void tryLockTest() throws InterruptedException {
        new Thread(()->{
            try {
                lock.lock();
                System.out.println(Thread.currentThread()+"����");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread()+"�ͷ���");
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        String flag = lock.tryLock()?"�ɹ�":"ʧ��";
        System.out.println("��ȡ��"+flag);
    }


    static class RLRunnable implements Runnable{
        @Override
        public void run() {
            try {
//                lock.lock();
                a++;
            }finally {
//                lock.unlock();
            }

        }
    }
}
