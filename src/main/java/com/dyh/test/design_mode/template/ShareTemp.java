package com.dyh.test.design_mode.template;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description:分享模板抽象类
 * author: dyh
 * date: 2021/5/31 10:22
 */
abstract class ShareTemp{

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH");

    private Date date;
    private String location;

    public void share(Date date,String location){
        //步骤1 首先预定时间和场地
        getTime(date,location);
        //步骤2 开始真正的分享
        shareContent();
        //步骤3 分享结束，讨论并关闭投影仪
        end();
    }

    /**
     * 步骤1 ，预定时间和地点 当然这些也可以作为抽象方法
     */
    private void getTime(Date date,String location){
        System.out.println("1. 我想在" + SIMPLE_DATE_FORMAT.format(date) + " ,在" + location + "发起分享，欢迎来看");
    }

    /**
     * 需要子类具体实现
     */
    abstract void shareContent();

    private void end(){
        System.out.println("3. 我今天的分享到这里，谢谢大家");
        System.out.println("*************关闭投影****************************");
    }
}
