package com.dyh.test.demo;

import java.text.MessageFormat;
import java.util.Locale;

/**
 * description: 消息格式化类
 * author: dyh
 * date: 2021/7/22 10:36
 */
public class MessageFormatDemo {

    public static void main(String[] args) {
        //获取当前的语言环境（可用于格式化文字）
        System.out.println(Locale.getDefault());

        //替换{0}，返回拼接的字符串
        Long l = 10000L;
        System.out.println(format(Locale.getDefault(), "用户id：{0}", l));

        //替换message例子
        String message = "oh, {0} is a pig";
        MessageFormat messageFormat = new MessageFormat(message);
        Object[] array = new Object[]{"ZhangSan"};
        String value = messageFormat.format(array);

        System.out.println(value);
    }

    public static String format(final Locale locale, final String format, final Object... args) {
        if (format == null) {
            return "";
        }
        if (args == null) {
            return format;
        }
        try {
            MessageFormat formart = new MessageFormat(format, locale);
            return formart.format(args);
        }
        catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
