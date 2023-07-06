package org.clb.LeetCode.HWCode;

import lombok.Data;

import java.util.*;

/**
 * ĳ���н��ͻ���Ϊ�����ɸ����ȼ���1 ����ߣ�5 ����ͣ�������Ҫ�����а���ҵ��ʱ�����ȼ��ߵ�����ʱ���Բ�ӵ����ȼ��͵��˵�ǰ�档
 * ���ڸ���һ����Ա���������а���ҵ���ʱ�����У�������ÿ�����а���ҵ��ʱ����ͻ��ı�š�
 * ���ͬʱ�ж�λ���ȼ���ͬ����ߵĿͻ������������󵽵�˳�����
 */
public class HW_Code1 {

    public static void main(String[] args) {
        Set set = new HashSet();
        StringBuffer str = new StringBuffer();
        Scanner in = new Scanner(System.in);
        PriorityQueue priorityQueue = new PriorityQueue<PConsumer>(new Comparator<PConsumer>() {
            @Override
            public int compare(PConsumer o1, PConsumer o2) {
                return o1.priority.compareTo(o2.priority);
            }
        });
        PConsumer pConsumer = new PConsumer();
        PConsumer pConsumer2 = new PConsumer();
        PConsumer pConsumer3 = new PConsumer();
        pConsumer.setPriority(2);
        pConsumer2.setPriority(3);
        pConsumer3.setPriority(1);
        priorityQueue.add(pConsumer);
        priorityQueue.add(pConsumer2);
        priorityQueue.add(pConsumer3);
        Iterator<PConsumer> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            PConsumer next = iterator.next();
            System.out.println(next.priority);
            iterator.remove();
        }

    }
    @Data
    static class PConsumer{
        Integer priority;
    }
}
