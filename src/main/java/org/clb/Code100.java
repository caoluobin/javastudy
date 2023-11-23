package org.clb;

import com.google.common.collect.Lists;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code100 {


    public static void main(String[] args) throws IOException {
        Double a = 1.0;
        Integer b =1;
        System.out.println(a.equals(b));
    }

    // 1 5 95 98 2  范围-100 ~ 100
    public static int getSum100(List<Integer> list) {
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> map2= new HashMap<>();
        //获得 每个数有多少个
        for (Integer integer : list) {
                map.put(integer,map.getOrDefault(integer,0)+1);

        }
        int count = 0;
        for (Integer integer : list) {
            if (integer!=50)
                count+=map.getOrDefault(100-integer,0);//获得
        }
        count = count/2;
        Integer count2 = map.getOrDefault(50, 0);
        if (count2>1) {
            for (int i = 0; i < count2; i++) {
                count+=i;
            }
        }
        return count;
    }

}
