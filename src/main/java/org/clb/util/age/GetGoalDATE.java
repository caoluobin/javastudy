package org.clb.util.age;

import com.google.common.base.Splitter;
import org.clb.util.stringsplitter.SplitterUtil;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Description ���ڲ�����
 * @Classname GetGoalDATE
 * @Date 2021/5/10 14:56
 * @Author clb
 */
public class GetGoalDATE {
    public static String getGoaldate(String date,int a){
        Calendar cal=Calendar.getInstance();
        List<String> list = split(date, "-");
        cal.set(Integer.parseInt(list.get(0)),Integer.parseInt(list.get(1))-1,Integer.parseInt(list.get(2)));
        Date time = cal.getTime();
        System.out.println("��ǰָ�������ǣ�"+new SimpleDateFormat("yyyy-MM-dd").format(time));
        cal.add(Calendar.DAY_OF_MONTH,a);
        cal.getTime();
        System.out.println("ǰ����������� "+new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    /**
     * �鿴�Ƿ������һ��
     * @param a
     * @return
     */
    public static boolean nowIsLastDay(int a){
        Calendar cal=Calendar.getInstance();
        int b = cal.getActualMaximum(a);
        int c = cal.get(a);
        return b==c;
    }
    public static String getGoalMontLastDay(String date,int a){
        Calendar cal=Calendar.getInstance();
        List<String> list = SplitterUtil.get(date, "-");
        cal.set(Integer.parseInt(list.get(0)),Integer.parseInt(list.get(1))-1,Integer.parseInt(list.get(2)));
        for (int i = 0; i < a; i++) {
            int day=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            cal.add(Calendar.DAY_OF_MONTH,-day);
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }
    public static void main(String[] args) {
        //getGoaldate("2020-5-7",-10);
//        boolean b = nowIsLastDay(Calendar.DAY_OF_MONTH);
//        System.out.println(b);
        System.out.println(getGoalMontLastDay("2021-5-31",3));

    }
    public static List<String> split(String a,String b){
        String[] split = a.split(b);
        return Arrays.asList(split);
    }
}
