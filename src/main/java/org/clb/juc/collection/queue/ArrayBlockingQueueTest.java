package org.clb.juc.collection.queue;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * add 不阻塞满了抛错  offer 不阻塞或根据时间阻塞返回布尔值  put 阻塞
 *                  poll  不阻塞或根据时间阻塞返回布尔值  take 阻塞   peek 直接返回头节点不出队列
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
