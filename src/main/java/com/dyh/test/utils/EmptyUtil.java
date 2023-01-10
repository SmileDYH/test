package com.dyh.test.utils;

import org.nutz.lang.Mirror;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import static org.nutz.castor.Castors.me;

/**
 * 常用的工具类的集合
 * 包含最常用工具类，比如判空、判断相等等与具体对象无关的方法
 */
public class EmptyUtil {

    /**
     * 判断一个对象是否为空。它支持如下对象类型：
     * <ul>
     * <li>null : 一定为空
     * <li>字符串     : ""为空,多个空格也为空
     * <li>数组
     * <li>集合
     * <li>Map
     * <li>Optional
     * <li>其他对象 : 一定不为空
     * </ul>
     *
     * @param obj
     *            任意对象
     * @return 是否为空
     */
    public final static boolean isEmpty(final Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String) {
            return "".equals(String.valueOf(obj).trim());
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }
        if (obj instanceof Collection<?>) {
            return ((Collection<?>) obj).isEmpty();
        }
        if (obj instanceof Map<?, ?>) {
            return ((Map<?, ?>) obj).isEmpty();
        }
        if (obj instanceof Optional<?>) {
            Optional<?> result = (Optional<?>) obj;
            return !result.isPresent();
        }
        if (Mirror.me(obj).isInt()) {
            long value = obj2long(obj);
            return value <= 0;
        }
        return false;
    }

    /**
     * 对象转换成long值
     * @param o 对象
     * @return 对应值，如果转换异常或为null，则返回-1
     */
    public static long obj2long(final Object o) {
        if (o == null) {
            return -1;
        }
        Long re = null;
        try {
            re = me().castTo(o, Long.class);
            if (re == null) {
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
        return re;
    }
}
