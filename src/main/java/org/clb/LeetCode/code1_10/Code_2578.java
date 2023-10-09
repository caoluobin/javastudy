package org.clb.LeetCode.code1_10;

import java.util.PriorityQueue;

public class Code_2578 {

    public static void main(String[] args) {
        Code_2578 code =new Code_2578();
        System.out.println(code.splitNum(4325));
    }

    public int splitNum(int num) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while (num>0) {
            int now = num%10;
            if (now!=0) {
                queue.add(now);
            }
            num=num/10;
        }
        boolean flag =true;
        int a =0;
        int b = 0;
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            if (flag) {
                a=a*10+now;
            } else {
                b=b*10+now;
            }
            flag = !flag;
        }

        return a+b;
    }
}
