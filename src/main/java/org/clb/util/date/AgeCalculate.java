package org.clb.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AgeCalculate {
    public  static int getAgeByBirth(Date birthday) {
        int age = 0;
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间
            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);
            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR)-1;
                if (now.get(Calendar.MONTH) >= birth.get(Calendar.MONTH)){
                    if (now.get(Calendar.DAY_OF_MONTH) >= birth.get(Calendar.DAY_OF_MONTH)) {
                        age += 1;
                    }
                }

            }
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
            return 0;
        }
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date bithday = format.parse("1938-05-06");
        System.out.println(getAgeByBirth(bithday));
//        Calendar now = Calendar.getInstance();
//        System.out.println(now.get(Calendar.DAY_OF_MONTH));
        String formatNowTime = getFormatNowTime();
        formatNowTime="%-"+formatNowTime+"%";
        System.out.println("PK_YL_BSLR".toLowerCase());
    }
    public static int getNowAge() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date bithday = format.parse(String.valueOf(System.currentTimeMillis()));
        return getAgeByBirth(bithday);
    }
    public  static String getFormatNowTime(){
        Calendar now = Calendar.getInstance();
        int day = now.get(Calendar.DAY_OF_MONTH);
        int month = now.get(Calendar.MONTH) + 1;
        String time="";
        if (month<10){
            time+="0"+month;
        }else {
            time+=month+"";
        }
        if (day<10){
            time+="-0"+day;
        }else {
            time+=day+"";
        }
        return time;
    }

}
