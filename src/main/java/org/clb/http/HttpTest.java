package org.clb.http;

import com.xkcoding.http.HttpUtil;
import com.xkcoding.http.support.HttpHeader;

import java.util.HashMap;
import java.util.Map;

public class HttpTest {

    public static void main(String[] args) {
        test1();
    }
    public static void test1(){
        HttpHeader httpHeader = new HttpHeader();
        Map<String,String> map = new HashMap<>();
//        map.put("userId","731869105312960512");
        httpHeader.add("Authorization","3f655d87112f4ae094bbaf70830e20aa");
        String s = HttpUtil.get("http://10.100.2.55:8077/api/ct/web/arena/arena/history", map, httpHeader, false);
        System.out.println(s);
    }
}
