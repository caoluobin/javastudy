package org.clb.LeetCode.code1_10;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Code_2034 {

    public Map<Integer,Integer> map = new HashMap<>();
    public Integer now;
    public Code_2034() {

    }

    public void update(int timestamp, int price) {
        map.put(timestamp,price);
        now=now==null||timestamp>now?timestamp:now;
    }

    public int current() {
        return map.getOrDefault(now,0);
    }

    public int maximum() {
        return map.values().stream().max(Integer::compareTo).get();
    }

    public int minimum() {
        return map.values().stream().min(Integer::compareTo).get();
    }
}
