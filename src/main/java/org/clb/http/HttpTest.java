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
        map.put("userId","731869105312960512");
        httpHeader.add("token","eyJhbGciOiJIUzUxMiJ9.eyJ0eXBlIjoxLCJleHAiOjE2NzM1NzY4NzksInVzZXJJZCI6NzMxODY5MTA1MzEyOTYwNTEyLCJhY2NvdW50TmFtZSI6ImNhb2x1b2JpbiIsImlhdCI6MTY3MDk4NDg3OSwib3JnSWQiOjYzOTUzNjczMTQ1MTExNzU3MX0.Dz8CjHPagg1X44Ie-4NyEdVUzcyVGjU6JOwmcb8wMKMsXI0oOKtjKLxCj39Gor5NItBrA6Y1w6P6izLDpT6JFA");
        String s = HttpUtil.get("http://192.168.6.12:8097/ucenterGh/ysUsers-info/getInfoById", map, httpHeader, false);
        System.out.println(s);
    }
}
