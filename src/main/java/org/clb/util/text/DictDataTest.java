package org.clb.util.text;

import java.util.HashMap;
import java.util.Map;

public class DictDataTest {

    public static void main(String[] args) {
        System.out.println(String.format("13%04d",  1));
//        System.out.println("123".substring(2,"123".length()));
//        test("0-一般社员1-成员代表2-理事长3-理事4-执行监事5-监事会成员");
    }
    public static void test(String text){
        String[] split = text.split("-");
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            if (i==0){
                String s = split[i + 1];
                map.put(split[i],s.substring(0,s.length()-1));
            } else if (i==(split.length-1)){

            } else {
                String s = split[i];
                String x = split[i + 1];
                map.put(s.substring(s.length()-1,s.length()),x.substring(0,x.length()-1));
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.print("\""+entry.getValue()+"_"+entry.getKey()+"\",");
        }
    }
}
