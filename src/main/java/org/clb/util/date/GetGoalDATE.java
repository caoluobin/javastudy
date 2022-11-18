package org.clb.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.clb.util.stringsplitter.SplitterUtil;

/**
 * @Description ���ڲ�����
 * @Classname GetGoalDATE
 * @Date 2021/5/10 14:56
 * @Author clb
 */
public class GetGoalDATE {

    public static String getGoaldate(String date, int a) {
        Calendar cal = Calendar.getInstance();
        List<String> list = split(date, "-");
        cal.set(Integer.parseInt(list.get(0)), Integer.parseInt(list.get(1)) - 1,
            Integer.parseInt(list.get(2)));
        Date time = cal.getTime();
        //System.out.println("��ǰָ�������ǣ�"+new SimpleDateFormat("yyyy-MM-dd").format(time));
        cal.add(Calendar.DAY_OF_MONTH, a);
        cal.getTime();
        //System.out.println("ǰ����������� "+new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }


    /**
     * �鿴�Ƿ������һ��
     *
     * @param a
     * @return
     */
    public static boolean nowIsLastDay(int a) {
        Calendar cal = Calendar.getInstance();
        int b = cal.getActualMaximum(a);
        int c = cal.get(a);
        //return true;
        return a == 7 ? cal.get(a) == 1 : b == c;
    }

    /**
     * @param date
     * @param a    ��ǰ������
     * @return
     */
    public static String getGoalMontLastDay(String date, int a) {
        Calendar cal = Calendar.getInstance();
        List<String> list = SplitterUtil.get(date, "-");
        cal.set(Integer.parseInt(list.get(0)), Integer.parseInt(list.get(1)) - 1,
            Integer.parseInt(list.get(2)));
        for (int i = 0; i < a; i++) {
            int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            cal.add(Calendar.DAY_OF_MONTH, -day);
        }
        //System.out.println(cal.getTime());
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    public static void main(String[] args) {
        //getGoaldate("2020-5-7",-10);
        //        boolean b = nowIsLastDay(Calendar.DAY_OF_MONTH);
        //        System.out.println(b);
        Calendar cal = Calendar.getInstance();
        cal.setTime(getGoalDate("2022-1-06"));
        getNextQuarterFirstDay(cal);
        getNextQuarterFirstDay(cal);
        getNextQuarterFirstDay(cal);
        getNextQuarterFirstDay(cal);
    }
    public static String getDateStringByCal(Calendar cal){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(cal.getTime());
    }
    public static Date getGoalDate(String date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * ��ȡ����һ��
     * @param cal
     */
    public static String getNextMonthFirstDay(Calendar cal){
        System.out.println(getDateStringByCal(cal));
        cal.add(Calendar.MONTH,1);
        //����ʼ��������Ϊ���ܵ���һ
        cal.add(Calendar.DAY_OF_YEAR,-(cal.get(Calendar.DAY_OF_MONTH)-1));
        System.out.println(getDateStringByCal(cal));
        return getDateStringByCal(cal);
    }
    public static String getNextQuarterFirstDay(Calendar cal){
        int month = cal.get(Calendar.MONTH);
        int count = 3-month%3;
        //����ʼ������������
        cal.add(Calendar.MONTH,count);
        //����ʼ��������Ϊ���µ�һ��
        cal.add(Calendar.DAY_OF_YEAR,-(cal.get(Calendar.DAY_OF_MONTH)-1));
        System.out.println(getDateStringByCal(cal));
        return getDateStringByCal(cal);
    }
    /**
     * ��ȡ������һ
     * @param cal
     */
    public static String getNextWeekMonDay(Calendar cal){
        System.out.println(getDateStringByCal(cal));
        cal.add(Calendar.WEEK_OF_MONTH,1);
        if (cal.get(Calendar.DAY_OF_WEEK)==1){
            cal.add(Calendar.DAY_OF_MONTH,-1);
        }
        System.out.println("DayOfWeek"+cal.get(Calendar.DAY_OF_WEEK));
        cal.add(Calendar.DAY_OF_YEAR,-(cal.get(Calendar.DAY_OF_WEEK)-2));
        System.out.println(getDateStringByCal(cal));
        return getDateStringByCal(cal);
    }

    public static String GetLastMonthLastDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new Date());
        Calendar cal1 = Calendar.getInstance();
        int a = -cal1.get(Calendar.DAY_OF_MONTH);
        Calendar cal = Calendar.getInstance();
        List<String> list = split(date, "-");
        cal.set(Integer.parseInt(list.get(0)), Integer.parseInt(list.get(1)) - 1,
            Integer.parseInt(list.get(2)));
        Date time = cal.getTime();
        //System.out.println("��ǰָ�������ǣ�"+new SimpleDateFormat("yyyy-MM-dd").format(time));
        cal.add(Calendar.DAY_OF_MONTH, a);
        cal.getTime();
        //System.out.println("ǰ����������� "+new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
        return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
    }

    public static List<String> split(String a, String b) {
        String[] split = a.split(b);
        return Arrays.asList(split);
    }
}
