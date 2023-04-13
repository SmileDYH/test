package com.dyh.test.design_mode.template;

/**
 * description:小臣分享
 * author: dyh
 * date: 2021/5/31 10:32
 */
class XiaoChenShare extends ShareTemp{

    @Override
    void shareContent() {
        System.out.println("2. 我今天分享的内容是变成规范之我见");
    }

//    @Override
//    public Boolean hookMethod(){
//        return true;
//    }
}