package org.clb.util.age;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateCalSub {
    private static Calendar calS = Calendar.getInstance();

    private static Pattern p = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");//����������ʽ

    /**

     * ����ʣ��ʱ��

     *

     * @param startDateStr yyyy-MM-dd

     * @param endDateStr yyyy-MM-dd

     * @return ���ꣿ���£���

     */

    public static String remainDateToString(String startDateStr, String endDateStr) {
        java.util.Date startDate = null;

        java.util.Date endDate = null;

        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateStr);

        } catch (ParseException e) {
            e.printStackTrace();

            return "";

        }

        try {
            endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateStr);

        } catch (ParseException e) {
            e.printStackTrace();

            return "";

        }

        calS.setTime(startDate);

        int startY = calS.get(Calendar.YEAR);

        int startM = calS.get(Calendar.MONTH);

        int startD = calS.get(Calendar.DATE);

        int startDayOfMonth = calS.getActualMaximum(Calendar.DAY_OF_MONTH);

        calS.setTime(endDate);

        int endY = calS.get(Calendar.YEAR);

        int endM = calS.get(Calendar.MONTH);

//����2011-01-10��2011-01-10����Ϊ����Ϊһ��

        int endD = calS.get(Calendar.DATE) + 1;

        int endDayOfMonth = calS.getActualMaximum(Calendar.DAY_OF_MONTH);

        StringBuilder sBuilder = new StringBuilder();

        if (endDate.compareTo(startDate) < 0) {
            return sBuilder.append("����").toString();

        }

        int lday = endD - startD;

        if (lday < 0) {
            endM = endM - 1;

            lday = startDayOfMonth + lday;

        }

//�����������⣬�磺2011-01-01 ��2013-12-31 2��11����31�� ʵ���Ͼ���3��

        if (lday == endDayOfMonth) {
            endM = endM + 1;

            lday = 0;

        }

        int mos = (endY - startY) * 12 + (endM - startM);

        int lyear = mos / 12;

        int lmonth = mos % 12;

        if (lyear > 0) {
            sBuilder.append(lyear + "��");

        }

        if (lmonth > 0) {
            sBuilder.append(lmonth + "����");

        }

// if(lyear==0)//������Ŀ���� ��һ�겻��ʾ����

        if (lday > 0) {
            sBuilder.append(lday + "��");

        }

        return sBuilder.toString();

    }

    /*

     * ת�� dataAndTime 2013-12-31 23:59:59 ��

     * date 2013-12-31

     */

    public static String getDate(String dateAndTime) {
        if (dateAndTime != null && !"".equals(dateAndTime.trim())) {
            Matcher m = p.matcher(dateAndTime);

            if (m.find()) {
                return dateAndTime.subSequence(m.start(), m.end()).toString();

            }

        }

        return "data error";

    }

    public static void main(String[] args) {
        System.out.println(remainDateToString("2020-06-05","2021-11-01"));
    }
}
