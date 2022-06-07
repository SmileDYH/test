package com.dyh.test.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;

public class DateConvertUtil {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        return localDateTime == null ? null : Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDateTime date2LocalDateTime(Date date) {
        return date == null ? null : LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * 时间转换成毫秒
     *
     * @param time
     *
     * @return
     */
    public static long localDateTime2MS(LocalDateTime time) {
        return localDateTime2MS(Optional.ofNullable(time));
    }

    /**
     * 时间转换成秒
     *
     * @param time
     *
     * @return
     */
    public static long localDateTime2Second(LocalDateTime time) {
        return localDateTime2MS(Optional.ofNullable(time)) / 1000;
    }

    /**
     * 时间转换成毫秒
     *
     * @param timeOptional
     *
     * @return
     */
    public static long localDateTime2MS(Optional<LocalDateTime> timeOptional) {
        return timeOptional.map(f -> f.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()).orElse(0L);
    }

    /**
     * 毫秒转换成时间
     *
     * @param date
     *
     * @return
     */
    public static LocalDateTime ms2LocalDateTime(Long date) {
        return date == null ? null : date2LocalDateTime(new Date(date));
    }

    /**
     * 时间相差分钟数
     *
     * @param startTime
     * @param endTime
     *
     * @return
     */
    public static int minusMinutes(Date startTime, Date endTime) {
        Duration duration = Duration.between(date2LocalDateTime(startTime), date2LocalDateTime(endTime));
        return Math.toIntExact(duration.toMinutes());
    }

    /**
     * 秒数转为h-min-s格式
     *
     * @param second
     *
     * @return
     */
    public static String second2HMS(Long second) {
        final long second2Min = 60;
        final long second2H = 3600;
        if (second == null) {
            return "0s";
        } else if (second < second2Min) {
            return second + "s";
        } else if (second < second2H) {
            return (second / second2Min) + "min-" + second % second2Min + "s";
        } else {
            return (second / second2H) + "h-" + ((second % second2H) / second2Min) + "min-" + (second % second2H) % second2Min + "s";
        }
    }

    /**
     * localDate 转 date
     *
     * @param localDate
     *
     * @return
     */
    public static Date localDate2Date(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * date 转localdate
     *
     * @param date
     *
     * @return
     */
    public static LocalDate date2LocalDate(Date date) {
        return date == null ? null : date2LocalDateTime(date).toLocalDate();
    }

    /**
     * 时间格式转字符串
     *
     * @param time
     *
     * @return
     */
    public static String localDateTimeToString(LocalDateTime time) {
        if (time == null) {
            return "";
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localTime = df.format(time);
        return localTime;
    }

    /**
     * 时间格式转字符串
     *
     * @param time
     *
     * @return
     */
    public static String dateToString(Date time) {
        if (time == null) {
            return "";
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(time);
    }

    /**
     * 字符串转时间格式
     *
     * @param time
     *
     * @return
     */
    public static LocalDateTime stringToLocalDateTime(String time) {
        LocalDateTime localDateTime = LocalDateTime.now();
        if (StringUtils.isBlank(time)) {
            return localDateTime;
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            localDateTime = LocalDateTime.parse(time, df);
        } catch (Exception e) {
            return localDateTime;
        }
        return localDateTime;
    }

    public static LocalDateTime stringToLocalDateTimeOfDate(String time) {
        if (StringUtils.isBlank(time)) {
            return null;
        }
        LocalDateTime localDateTime;
        DateTimeFormatter df = new DateTimeFormatterBuilder().appendPattern(
                "yyyy-MM-dd[['T'HH][:mm][:ss]").parseDefaulting(ChronoField.HOUR_OF_DAY, 0).parseDefaulting(
                ChronoField.MINUTE_OF_HOUR, 0).parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0).parseDefaulting(
                ChronoField.MILLI_OF_SECOND, 0).toFormatter();
        try {
            localDateTime = LocalDateTime.parse(time, df);
        } catch (Exception e) {
            return null;
        }
        return localDateTime;
    }

    /**
     * 将带有/的字符串转时间格式
     *
     * @param time
     *
     * @return
     */
    public static LocalDateTime stringTimeToLocalDateTime(String time) {
        LocalDateTime localDateTime = LocalDateTime.now();
        time = time.replaceAll("/", "-");
        if (StringUtils.isBlank(time)) {
            return localDateTime;
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            localDateTime = LocalDateTime.parse(time, df);
        } catch (Exception e) {
            return localDateTime;
        }
        return localDateTime;
    }

    /**
     * LocalDateTime转年月日
     *
     * @param time
     *
     * @return
     */
    public static String LocalDateTimetoYearMonthDay(LocalDateTime time) {
        if (time == null) {
            return "";
        }
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String strDate2 = dtf2.format(time);
        return strDate2;
    }

    /**
     * LocalDateTime转年月日
     *
     * @param time
     *
     * @return
     */
    public static String LocalDateTimeToDay(LocalDateTime time) {
        if (time == null) {
            return "";
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String strDate = dtf.format(time);
        return strDate;
    }

    /**
     * 毫秒转时分秒
     *
     * @param millSeconds
     *
     * @return
     */
    public static String millSecond2HMS(long millSeconds) {
        int transfer = 1000;
        return second2HMS(millSeconds / transfer);
    }

    /**
     * 毫秒级时间戳 转整数分级时间戳（向下取）
     */
    public static long millSecStamp2MinuteStamp(long millSeconds) {
        // ex: 1576220947012  =>     15762209 47 012
        //                                    秒 毫米
        //                           15762209 47 000
        //                           15762209 4      =>x
        // while(x%6 != 0){x --；}
        if (millSeconds < 10000) {
            return 0L;
        }
        long temp = millSeconds / 10000;
        while (temp % 6 != 0) {
            temp--;
        }
        return temp * 10000;
    }

    public static long nextDayValueClockMillSecStamp(long value) {
        LocalDateTime thisDay = LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0, 0));
        LocalDateTime nextDayValueClock = thisDay.plusDays(1).plusHours(value);
        return localDateTime2MS(nextDayValueClock);
    }

    public static long getTodayZeroClockMillsTimeStamp() {
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0, 0));
        return localDateTime2MS(localDateTime);
    }

    /**
     * 在范围内获取时间浮动值
     *
     * @param waveRangeMillSecond 浮动的范围 单位毫秒
     *
     * @return 浮动值
     */
    public static long timeWave(int waveRangeMillSecond) {
        return new Random().nextInt(waveRangeMillSecond) + 1;
    }

    public static long getNextValueDayZeroClockMillsTimeStamp(int value) {
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0, 0));
        LocalDateTime nextDay = localDateTime.plus(value, ChronoUnit.DAYS);
        return localDateTime2MS(nextDay);
    }

    public static long date2ms(Date date) {
        return Objects.isNull(date) ? null : date.getTime();
    }

    public static Date ms2Date(long date) {
        return Objects.isNull(date) ? null : new Date(date);
    }

    public static Integer localDateTime2Year(LocalDateTime time) {
        if (time == null) {
            return 0;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
        String strDate = dtf.format(time);
        return Integer.parseInt(strDate);
    }

    /**
     * 时间格式转字符串 年-月-日
     *
     * @param time
     *
     * @return
     */
    public static String localDateTimeToDayString(LocalDateTime time) {
        if (time == null) {
            return "";
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return df.format(time);
    }

    /**
     * 时间格式转字符串 时：分
     *
     * @param time
     *
     * @return
     */
    public static String localDateTimeToMinusString(LocalDateTime time) {
        if (time == null) {
            return "";
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
        return df.format(time);
    }

    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 获取当天日期（yyyy-MM-dd）
     *
     * @return 当天日期
     */
    public static String getTodayDate() {
        return DATE_FORMAT.format(new Date());
    }
}
