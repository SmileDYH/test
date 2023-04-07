package com.dyh.test.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dyh.test.utils.MathUtil;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.LockSupport;

/**
 * description:
 * author: dyh
 * date: 2021/11/2 14:00
 */
public class Test1 {

    public static void main(String[] args) {
//        List<LevelSetBean> levelSet = ConfigConstant.ReprotCommonConfig.LEVEL_SET;
//        System.out.println(levelSet);
        Integer a = 1;
        System.out.println(a.hashCode());

        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        System.out.println(        map.get("key"));
        System.out.println(       map.get("value") == null);

        String b = "{\"0\":{\"130000\":\"初中\",\"140000\":\"高中\",\"120000\":\"小学\"},\"1\":{\"11\":\"高二\",\"12\":\"高三\",\"1\":\"一年级\",\"2\":\"二年级\",\"3\":\"三年级\",\"4\":\"四年级\",\"5\":\"五年级\",\"6\":\"六年级\",\"7\":\"初一\",\"8\":\"初二\",\"9\":\"初三\",\"10\":\"高一\"},\"2\":{\"100001\":\"语文\",\"100002\":\"数学\",\"100003\":\"物理\",\"100004\":\"化学\",\"100015\":\"道德与法治\",\"100016\":\"英语\",\"100005\":\"生物\",\"100006\":\"历史\",\"100007\":\"政治\",\"100008\":\"地理\"}}";
//        JSONObject jsonObject = JSON.parseObject(b);
        Map<Integer, Map<Long, String>> bMap =  (Map)JSON.parse(b);
        Map<Long, String> stageMap = bMap.get("0");
        Map<Long, String> subjectMap = bMap.get("2");
        System.out.println(stageMap);
        System.out.println(subjectMap);




    }

    public static String accuracyToDouble(double num, double total, int scale) {

        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        //可以设置精确几位小数
        df.setMaximumFractionDigits(scale);
        //模式 例如四舍五入
        df.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println(num+ " " + total);
        double accuracy_num = num / total;
        System.out.println("accuracy_num"+accuracy_num);
        return df.format(accuracy_num);
    }
}
