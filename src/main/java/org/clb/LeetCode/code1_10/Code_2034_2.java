package org.clb.LeetCode.code1_10;

import java.util.*;

public class Code_2034_2 {
    public static void main(String[] args) {
        Code_2034_3 code = new Code_2034_3();
        Code_2034 code2 = new Code_2034();
        code.update(1,4);
        code.update(2,2);
        code2.update(1,4);
        code2.update(2,2);
        if (code.current()!= code2.current()||code.maximum()!=code2.maximum()||code.minimum()!=code2.minimum()) {
            System.out.println(code.current());
            System.out.println(code.maximum());
            System.out.println(code.minimum());
            System.out.println(code2.current());
            System.out.println(code2.maximum());
            System.out.println(code2.minimum());
        }
        Code_2034_2.test();

    }

    public static void test() {

        Random random = new Random();
        Boolean flag = false;
        for (int i = 0; i < 100; i++) {
            Code_2034_3 code = new Code_2034_3();
            Code_2034 code2 = new Code_2034();
            List<Integer> timeList = new ArrayList<>();
            List<Integer> priceList = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                Integer time = random.nextInt(3)+1;
                Integer price = random.nextInt(10)+1;
                code.update(time,price);
                code2.update(time,price);
                timeList.add(time);
                priceList.add(price);
                if (code.current()!= code2.current()||code.maximum()!=code2.maximum()||code.minimum()!=code2.minimum()) {
                    timeList.forEach(System.out::println);
                    System.out.println("=====================");
                    priceList.forEach(System.out::println);
                    flag=true;
                    break;
                }
            }
            if (flag) break;
            timeList.clear();
            priceList.clear();
        }
    }
    public Map<Integer,Integer> map = new HashMap<>();
    public Integer now;

    private Boolean first = true;
    public Map<Integer,Integer> updateMap = new HashMap<>();

    private PriorityQueue<Integer> maxQueue=new PriorityQueue<>(Comparator.comparing(Integer::intValue).reversed());
    private PriorityQueue<Integer> minQueue=new PriorityQueue<>();
    public Code_2034_2() {

    }

    public void update(int timestamp, int price) {
//        map.put(timestamp, price);
        updateMap.put(timestamp, price);
        now=now==null||timestamp>now?timestamp:now;
    }

    public int current() {
        deal();
        return map.getOrDefault(now,0);
    }
    public void  deal() {
        for (Map.Entry<Integer, Integer> entry : updateMap.entrySet()) {
            Integer timestamp = entry.getKey();
            Integer price = entry.getValue();
            Integer value=map.get(timestamp);
            if (value != null&& !value.equals(price)) {
                maxQueue.remove(value);
                minQueue.remove(value);
            }
            if (value==null|| !Objects.equals(price, value)||first) {
                map.put(timestamp, price);
                maxQueue.add(price);
                minQueue.add(price);
            }
        }
        first=false;
        updateMap.clear();
    }

    public int maximum() {
        deal();
        return maxQueue.peek();
    }

    public int minimum() {
        deal();
        return minQueue.peek();
    }
}
