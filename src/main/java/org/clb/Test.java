package org.clb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import lombok.var;
import org.clb.util.text.TextRead;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 8; i++) {
            int finalI = i;
            new Thread(()->{

                while (true) {
                    long now = System.currentTimeMillis();
                    System.out.println(finalI+""+finalI+finalI+finalI+finalI+finalI+finalI+finalI+finalI);

                    while (System.currentTimeMillis()-now<1000) {

                    }
                    if (System.currentTimeMillis()-start>5000) {
                        break;
                    }
                }
            }).start();
        }
    }

    public static String[] getDeal(String object,String emailss) {
        String[] res = new String[2];
        emailss=emailss.replace("[","");
        emailss=emailss.replace("]","");
        emailss=emailss.replace("\"","");
//        object=object.replace("_","");
        object=object.substring(0,object.lastIndexOf("/"));
        object=object.substring(0,object.length()-1);
        String[] emails = emailss.split(",");
        String gzipd ="gzip -d "+object+" ; ";
        String sed="";
        String grep="";
        for (String email : emails) {
            sed+="sed -i 's|"+email+"||g' "+object.replace(".gz","")+" ; ";
            grep+="grep '"+email+"' "+object.replace(".gz","")+" ; ";
        }

        String gzip="gzip "+object.replace(".gz","");
        String cd= "cd "+object.substring(0,object.lastIndexOf("/"))+" ; ";
        res[0]=gzipd+sed+cd+gzip;
        res[1]=gzipd+grep+cd+gzip;
        System.out.println(gzipd+sed+cd+gzip);
        System.out.println(gzipd+grep+cd+gzip);
        return res;
    }

    public static String[] getDeal2(String object,String emailss) {
        String[] res = new String[2];
        emailss=emailss.replace("[","");
        emailss=emailss.replace("]","");
        emailss=emailss.replace("\"","");
//        object=object.replace("_","");
        String[] emails = emailss.split(",");
        String sed="";
        String grep="";
        for (String email : emails) {
            sed+="sed -i 's|"+email+"||g' "+object+" ; ";
            grep+="grep '"+email+"' "+object+" ; ";
        }
        res[0]=sed;
        res[1]=grep;
        System.out.println(sed);
        System.out.println(grep);
        return res;
    }
}
