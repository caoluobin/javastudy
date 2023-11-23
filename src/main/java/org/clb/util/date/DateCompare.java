package org.clb.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description
 * @Classname DateCompare
 * @Date 2021/7/19 9:46
 * @Author clb
 */
public class DateCompare {
    /**
     *
     * @param workTime 上班时间
     * @return
     */
    public static boolean compare(String workTime,String quitTime) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new Date());
        SimpleDateFormat formatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date workDateTime = formatTime.parse(date+" "+workTime);
        Date quitDateTime = formatTime.parse(date+" "+quitTime);

        Date now=new Date();
        return now.compareTo(workDateTime)>0&&now.compareTo(quitDateTime)<0;
    }

    public static boolean comDate(String date) throws ParseException {
        SimpleDateFormat formatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date2 = formatTime.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE,-10);
        Date now = cal.getTime();
        return now.compareTo(date2)>0;
    }

    public static int getComDate(String date) throws ParseException {
        SimpleDateFormat formatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date2 = formatTime.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE,-10);
        Date now = cal.getTime();
        return now.compareTo(date2);
    }
    public static void main(String[] args) throws ParseException {
        System.out.println(comDate("2021-09-02 19:58:22"));
    }
}
