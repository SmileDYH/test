package com.dyh.test.utils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期工具类
 *
 */
public class DateUtils {

    public static enum Type {
        Year, Month, Week, Day, Hour, Minutes, Seconds;
    }

    /**
     * <b>获取当前时间</b><br>
     * y 年 M 月 d 日 H 24小时制 h 12小时制 m 分 s 秒
     *
     * @param format 日期格式
     * @return String
     */
    public static String getCurrentDate(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    /**
     * 获取制定日期的格式化字符串
     *
     * @param date   Date 日期
     * @param format String 格式
     * @return String
     */
    public static String getFormatedDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 判断哪个日期在前 如果日期一在日期二之前，返回true,否则返回false
     *
     * @param date1 日期一
     * @param date2 日期二
     * @return boolean
     */
    public static boolean isBefore(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date1);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date2);

        if (c1.before(c2))
            return true;

        return false;
    }

    /**
     * 将字符串转换成日期
     *
     * @param date String 日期字符串
     * @return Date
     * @throws ParseException
     */
    public static Date parseDateFromString(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return sdf.parse(date);
    }

    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    public static Date parseDateFromStringByCmq(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(date);
    }

    public static Date parseDateFromString(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取指定日期当月的最后一天
     *
     * @param date
     * @return
     */
    public static Date lastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    /**
     * 获取指定日期当月的第一天
     *
     * @param date
     * @return
     */
    public static Date firstDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 是否是闰年
     *
     * @param year 年份
     * @return boolean
     */
    public static boolean isLeapYear(int year) {
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.isLeapYear(year);
    }

    /**
     * 获取指定日期之前或者之后多少天的日期
     *
     * @param day    指定的时间
     * @param offset 日期偏移量，正数表示延后，负数表示天前
     * @return Date
     */
    public static Date getDateByOffset(Date day, int offset) {
        Calendar c = Calendar.getInstance();
        c.setTime(day);
        c.add(Calendar.DAY_OF_MONTH, offset);
        return c.getTime();
    }

    /**
     * 获取一天开始时间 如 2014-12-12 00:00:00
     *
     * @return
     */
    public static Date getDayStart() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取一天结束时间 如 2014-12-12 23:59:59
     *
     * @return
     */
    public static Date getDayEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 时间分段 比如：2014-12-12 10:00:00 ～ 2014-12-12 14:00:00 分成两段就是 2014-12-12
     * 10：00：00 ～ 2014-12-12 12：00：00 和2014-12-12 12：00：00 ～ 2014-12-12 14：00：00
     *
     * @param start  起始日期
     * @param end    结束日期
     * @param pieces 分成几段
     */
    public static Date[] getDatePieces(Date start, Date end, int pieces) {

        Long sl = start.getTime();
        Long el = end.getTime();

        Long diff = el - sl;

        Long segment = diff / pieces;

        Date[] dateArray = new Date[pieces + 1];

        for (int i = 1; i <= pieces + 1; i++) {
            dateArray[i - 1] = new Date(sl + (i - 1) * segment);
        }

        // 校正最后结束日期的误差，可能会出现偏差，比如14:00:00 ,会变成13:59:59之类的
        dateArray[pieces] = end;

        return dateArray;
    }

    /**
     * 获取某个日期的当月第一天
     *
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 获取某个日期的当月最后一天
     *
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 0);
        return cal.getTime();
    }

    /**
     * 获取某个日期的当月第一天
     *
     * @return
     */
    public static Date getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 获取某个日期的当月最后一天
     *
     * @return
     */
    public static Date getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 0);
        return cal.getTime();
    }

    /**
     * 获取两个日期的时间差，可以指定年，月，周，日，时，分，秒
     *
     * @param date1 第一个日期
     * @param date2 第二个日期<font color="red">此日期必须在date1之后</font>
     * @param type  DateUtils.Type.X的枚举类型
     * @return long值
     * @throws Exception
     */
    public static long getDiff(Date date1, Date date2, Type type) throws Exception {

        if (!isBefore(date1, date2))
            throw new Exception("第二个日期必须在第一个日期之后");

        long d = Math.abs(date1.getTime() - date2.getTime());
        switch (type) {
            case Year: {
                Calendar cal1 = Calendar.getInstance();
                Calendar cal2 = Calendar.getInstance();

                cal1.setTime(date1);
                int year1 = cal1.get(Calendar.YEAR);
                int month1 = cal1.get(Calendar.MONTH);
                int day1 = cal1.get(Calendar.DAY_OF_MONTH);
                int hour1 = cal1.get(Calendar.HOUR_OF_DAY);
                int minute1 = cal1.get(Calendar.MINUTE);
                int second1 = cal1.get(Calendar.SECOND);

                cal2.setTime(date2);
                int year2 = cal2.get(Calendar.YEAR);
                int month2 = cal2.get(Calendar.MONTH);
                int day2 = cal2.get(Calendar.DAY_OF_MONTH);
                int hour2 = cal2.get(Calendar.HOUR_OF_DAY);
                int minute2 = cal2.get(Calendar.MINUTE);
                int second2 = cal2.get(Calendar.SECOND);

                int yd = year2 - year1;

                if (month1 > month2) {
                    yd -= 1;
                } else {
                    if (day1 > day2) {
                        yd -= 1;
                    } else {
                        if (hour1 > hour2) {
                            yd -= 1;
                        } else {
                            if (minute1 > minute2) {
                                yd -= 1;
                            } else {
                                if (second1 > second2) {
                                    yd -= 1;
                                }
                            }
                        }
                    }
                }
                return (long) yd;
            }
            case Month: {
                // 获取年份差
                long year = getDiff(date1, date2, Type.Year);

                Calendar cal1 = Calendar.getInstance();
                Calendar cal2 = Calendar.getInstance();

                cal1.setTime(date1);
                int month1 = cal1.get(Calendar.MONTH);
                int day1 = cal1.get(Calendar.DAY_OF_MONTH);
                int hour1 = cal1.get(Calendar.HOUR_OF_DAY);
                int minute1 = cal1.get(Calendar.MINUTE);
                int second1 = cal1.get(Calendar.SECOND);

                cal2.setTime(date2);
                int month2 = cal2.get(Calendar.MONTH);
                int day2 = cal2.get(Calendar.DAY_OF_MONTH);
                int hour2 = cal2.get(Calendar.HOUR_OF_DAY);
                int minute2 = cal2.get(Calendar.MINUTE);
                int second2 = cal2.get(Calendar.SECOND);

                int md = (month2 + 12) - month1;

                if (day1 > day2) {
                    md -= 1;
                } else {
                    if (hour1 > hour2) {
                        md -= 1;
                    } else {
                        if (minute1 > minute2) {
                            md -= 1;
                        } else {
                            if (second1 > second2) {
                                md -= 1;
                            }
                        }
                    }
                }
                return (long) md + year * 12;
            }
            case Week: {
                return getDiff(date1, date2, Type.Day) / 7;
            }
            case Day: {
                long d1 = date1.getTime();
                long d2 = date2.getTime();
                return (int) ((d2 - d1) / (24 * 60 * 60 * 1000));
            }
            case Hour: {
                long d1 = date1.getTime();
                long d2 = date2.getTime();
                return (int) ((d2 - d1) / (60 * 60 * 1000));
            }
            case Minutes: {
                long d1 = date1.getTime();
                long d2 = date2.getTime();
                return (int) ((d2 - d1) / (60 * 1000));
            }
            case Seconds: {
                long d1 = date1.getTime();
                long d2 = date2.getTime();
                return (int) ((d2 - d1) / 1000);
            }
            default:
                throw new Exception("请指定要获取的时间差的类型：年，月，天，周，时，分，秒");
        }
    }

    /**
     * Annotation:
     * 将时间字符串加三个月
     *
     * @param
     * @return
     * @author zly
     * @date 2018/11/20
     */
    public static String monthAddThree(String time) {
        SimpleDateFormat dateStrFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ct = Calendar.getInstance();
        try {
            ct.setTime(dateStrFormatter.parse(time));
            ct.add(Calendar.MONTH, +3);
            return dateStrFormatter.format(ct.getTime());
        } catch (ParseException e) {
            ct.setTime(new Date());
            ct.add(Calendar.MONTH, +3);
            return dateStrFormatter.format(ct.getTime());
        }
    }

    /**
     * Annotation: 根据出生日期计算年龄
     *
     * @param birthday
     * @return int
     * @author zhaolong
     * @date 2018/11/21
     */
    public static int getAgeByBirth(Date birthday) {
        int age = 0;
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date()); // 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday); // 传入的时间

            //如果传入的时间，在当前时间的后面，返回0岁
            if (birth.after(now)) {
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 取得指定日期所在周的第一天
     */
    public static String getFirstDayOfWeek(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date time = sdf.parse(date);
            Calendar c = new GregorianCalendar();
            c.setFirstDayOfWeek(Calendar.MONDAY);
            c.setTime(time);
            c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
            return sdf.format(c.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 取得指定日期所在周的最后一天
     */
    public static String getLastDayOfWeek(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date time = sdf.parse(date);
            Calendar c = new GregorianCalendar();
            c.setFirstDayOfWeek(Calendar.MONDAY);
            c.setTime(time);
            c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
            return sdf.format(c.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getFirstDayOfMonth(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date time = sdf.parse(date);
            Calendar c = new GregorianCalendar();
            c.setTime(time);
            c.set(Calendar.DAY_OF_MONTH, 1); // Monday
            return sdf.format(c.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getLastDayOfMonth(String date) {
        //获取Calendar
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date time = sdf.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(time);
            //设置日期为本月最大日期
            calendar.set(Calendar.DATE, calendar.getActualMaximum(calendar.DATE));
            //设置日期格式
            return sdf.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getPreDateTime() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.DATE, -1);
        date = calendar.getTime();
        String dayBefore = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
        System.out.println(dayBefore);
        return dayBefore;
    }

    public static String getTodayDateStart() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        Date beginOfDate = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return formatter.format(beginOfDate);
    }

    public static boolean isBetween(Date startTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(new Date());

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isBetween(Date curTime, Date startTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(curTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    public static Date lastYear(Date date, int year) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        //过去一年
        c.setTime(date);
        c.add(Calendar.YEAR, -year);
        return c.getTime();
    }

    public static Date getThisWeek(Date date) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd 00:00:00");//设置日期格式
        Calendar cld = Calendar.getInstance(Locale.CHINA);
        cld.setFirstDayOfWeek(Calendar.MONDAY);//以周一为首日
        cld.setTime(date);//当前时间
        cld.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);//周一
        return parseDateFromStringByCmq(df.format(cld.getTime()));
    }

    //获取当前时间前一天date
    public static Date getBeforeDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }

    public static void main1(String[] args) throws ParseException {

        Set<Date> set = new HashSet<>();
        Calendar cal = Calendar.getInstance();
        cal.set(2020, 1, 1);
        for (int i = 0; i < 365; i++) {
            int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if (week == 1) {
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                System.out.println(cal.getTime());
                set.add(cal.getTime());
            }
            cal.add(Calendar.DATE, 1);//DATE=日

            if (cal.getTime().compareTo(new Date()) == 1) {
                break;
            }
        }

        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.parse("1989-4-18"));

        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        System.out.println(sdf.parse("1989-4-18"));*/

        //System.out.println(isBetween(DateUtils.parseDateFromString("2019-12-01 01:00:00"),DateUtils.parseDateFromString("2019-12-31 01:00:00")));
        //System.out.println(isBefore(DateUtils.parseDateFromString("2019-12-01 01:00:00"), DateUtils.parseDateFromString("2019-12-31 01:00:00")));
       /* int num = 4;
        switch (num) {
            case 0:
                System.out.println("0");
                break;
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("default");
                break;
        }*/
//        System.out.println(getAgeByBirth(parseDateFromString("1988-01-24")));


    }


    /**
     * 计算时间
     * @param startTime ： 开始时间
     * @param endTime  ： 结束时间
     * @return
     */
    public static int caculateTotalTime(String startTime,String endTime) {
        SimpleDateFormat formatter =   new SimpleDateFormat( "yyyy-MM-dd");
        Date date1=null;
        Date date = null;
        Long l = 0L;
        try {
            date = formatter.parse(startTime);
            long ts = date.getTime();
            date1 =  formatter.parse(endTime);
            long ts1 = date1.getTime();

            l = (ts - ts1) / (1000 * 60 * 60 * 24);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return l.intValue();
    }

    public static int caculateTotalHourTime(String startTime,String endTime) {
        SimpleDateFormat formatter =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        Date date1=null;
        Date date = null;
        Long l = 0L;
        try {
            date = formatter.parse(startTime);
            long ts = date.getTime();
            date1 =  formatter.parse(endTime);
            long ts1 = date1.getTime();
            l = (ts - ts1) / (1000*60*60);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return l.intValue();
    }

    public static int caculateTotalMinTime(String startTime,String endTime) {
        SimpleDateFormat formatter =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        Date date1=null;
        Date date = null;
        Long l = 0L;
        try {
            date = formatter.parse(startTime);
            long ts = date.getTime();
            date1 =  formatter.parse(endTime);
            long ts1 = date1.getTime();
            l = (ts - ts1) / (1000*60);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return l.intValue();
    }

    /*
     * 将时间戳转换为时间
     */
    public static Date stampToDate(String s) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        Date dateTime = simpleDateFormat.parse(simpleDateFormat.format(date));
        return dateTime;
    }
}
