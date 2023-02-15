package org.clb.juc.collection.queue;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * add �����������״�  offer �����������ʱ���������ز���ֵ  put ����
 *                  poll  �����������ʱ���������ز���ֵ  take ����   peek ֱ�ӷ���ͷ�ڵ㲻������
 */
public class ArrayBlockingQueueTest {

    private static final ArrayBlockingQueue queue = new ArrayBlockingQueue(10);

    public static void main(String[] args) {
        capacityTest();
    }
    public static void capacityTest() {

        for (int i = 0; i < 11; i++) {
            queue.offer(i);
        }
        queue.remove(5);
    }
}
