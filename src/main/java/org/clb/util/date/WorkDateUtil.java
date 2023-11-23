package org.clb.util.date;

import java.util.*;

/**
 * @Description
 * @Classname WorkDateUtil
 * @Date 2021/8/9 11:47
 * @Author clb
 */
public class WorkDateUtil {
    public static HashMap<Integer,String> thisYearWorkDayMap=new HashMap<>();
    public String calFinishTime(String acceptTime,String workdays){
        if (!thisYearWorkDayMap.get(0).equals("当前年")){
            thisYearWorkDayMap.put(0,"当前年");
            //获取工作天
            List<String> workDayList=new ArrayList();
//            workDayList.stream().sorted(Comparator.comparing(a));

        }

        //

        return "";
    }

    public static void main(String[] args) {
        String a="2021-07-08 12:22:11".substring(10, 19);
        System.out.println("2021-07-08"+a);
        ArrayList list=new ArrayList();
    }
}
