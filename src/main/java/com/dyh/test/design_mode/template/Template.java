package com.dyh.test.design_mode.template;

import java.util.Calendar;

/**
 * description: 模板方法模式
 * author: dyh
 * date: 2021/5/31 10:20
 */
public class Template {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        //季度分享电影短片开始 顺序回顾每个人的分享流程
        ShareTemp xiaojieShare = new XiaoJieShare();
        xiaojieShare.share(calendar.getTime(),"三楼接待室");

        ShareTemp xiaochenshare = new XiaoChenShare();
        calendar.set(Calendar.DAY_OF_MONTH,10);
        xiaochenshare.share(calendar.getTime(),"总裁办公室");

        ShareTemp xiaolongShare = new XiaoLongShare();
        calendar.set(Calendar.HOUR_OF_DAY,23);
        xiaolongShare.share(calendar.getTime(),"宇宙中心");
    }
}
