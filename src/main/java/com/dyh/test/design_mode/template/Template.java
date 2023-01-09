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
        xiaojieShare.share(calendar.getTime(),"三楼接待室【jie】");

        ShareTemp xiaochenshare = new XiaoChenShare();
        calendar.set(Calendar.DAY_OF_MONTH,10);
        xiaochenshare.share(calendar.getTime(),"总裁办公室【chen】");

        ShareTemp xiaolongShare = new XiaoLongShare();
        calendar.set(Calendar.HOUR_OF_DAY,23);
        xiaolongShare.share(calendar.getTime(),"宇宙中心【long】");

        /* -------------------------匿名内部类方式---------------------------*/
        AShare aShare = new AShare();
        aShare.bond(new ShareTemp() {
            //匿名内部类实现回调
            @Override
            void shareContent() {
                System.out.println("2. 我是新来的小a，我今天分享的内容是...");
            }
            /**
             * 重构钩子方法
             */
            @Override
            public void hookMethod(){
                //子类可以在父类钩子方法实现的基础上进行扩展
                System.out.println("我是插队进来的小a");
            }
        },calendar.getTime(),"中科宏一【a】");
    }
}
