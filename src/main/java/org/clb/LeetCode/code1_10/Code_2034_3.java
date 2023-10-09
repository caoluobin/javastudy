package org.clb.LeetCode.code1_10;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Code_2034_3 {
    public static void main(String[] args) {
        Code_2034_3 code =new Code_2034_3();
        code.update(3,3);
        code.update(2,8);
        code.update(2,8);
        code.update(2,2);
        System.out.println(code.current());
        System.out.println(code.maximum());
        System.out.println(code.minimum());
    }

    public Map<Integer,Integer> map = new HashMap<>();
    public TreeMap<Integer,Integer> prices = new TreeMap<>();
    public Integer now;
    public Code_2034_3() {

    }

    public void update(int timestamp, int price) {
        Integer oldPrice = map.put(timestamp, price);
        if (!Objects.equals(price,oldPrice)) {
            if (oldPrice!=null) {
                Integer count = prices.get(oldPrice);
                if (count==1) {
                    prices.remove(oldPrice);
                } else {
                    prices.put(oldPrice,count-1);
                }
            }
            prices.put(price,prices.getOrDefault(price,0)+1);
        }
        now=now==null||timestamp>now?timestamp:now;
    }

    public int current() {
        return map.getOrDefault(now,0);
    }

    public int maximum() {
        return prices.lastKey();
    }

    public int minimum() {
        return prices.firstKey();
    }
}
