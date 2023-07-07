package org.clb.LeetCode.HWCode;

import lombok.Data;

import java.util.*;

/**
 * 某银行将客户分为了若干个优先级，1 级最高，5 级最低，当你需要在银行办理业务时，优先级高的人随时可以插队到优先级低的人的前面。
 * 现在给出一个人员到来和银行办理业务的时间序列，请你在每次银行办理业务时输出客户的编号。
 * 如果同时有多位优先级相同且最高的客户，则按照先来后到的顺序办理。
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
