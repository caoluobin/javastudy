package org.clb.LeetCode.code1_10;

import java.util.*;

public class Code_1488 {

    public static void main(String[] args) {
        Code_1488 code = new Code_1488();
        code.avoidFlood(new int[]{1,0,2,0,3,0,2,0,0,0,1,2,3});
        //1,0,2,0,3,0,2,0,0,0,1,2,3
        //1,c,2,c,3,0,2,c,0,0,1,2,3

    }

    public int[] avoidFlood(int[] rains) {//1,2,0,1,2   -1 -1 0 -1 -1
        int[] res = new int[rains.length];
        //key : 池子 value:day
        Map<Integer,Integer> map = new HashMap<>();
        //key:可抽取湖水的时间
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < rains.length; i++) {
            int rain = rains[i];
            if (rain > 0) {
                if (map.containsKey(rain)) { //如果已经满了
                    if (!list.isEmpty()) {
                        int day = map.get(rain);
                        Iterator<Integer> iterator = list.iterator();
                        boolean flag = true;
                        while (iterator.hasNext()) {
                            Integer next = iterator.next();
                            if (next>day) {
                                res[next] = rain;
                                iterator.remove();
                                flag = false;
                                map.put(rain,i);
                                break;
                            }
                        }
                        if (flag) {
                            return new int[0];
                        }
                    } else {
                        return new int[0];
                    }
                } else {
                    map.put(rain,i);
                }
                res[i]=-1;
            } else {
                list.add(i);
                res[i] =1;
            }
        }
        return res;
    }
    private class Rain {
        int day;


    }

}
