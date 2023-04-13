package com.dyh.test.design_mode.template;

import java.util.Date;

/**
 * description: 小a分享，新增分享
 * author: dyh
 * date: 2023/1/9 12:37
 */
public class AShare {
    public void bond(ShareTemp abstractClass, Date date, String location) {
        abstractClass.share(date,location);
    }
}
