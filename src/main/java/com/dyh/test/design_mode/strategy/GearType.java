package com.dyh.test.design_mode.strategy;

/**
 * 档位枚举
 */
enum GearType {

    ONE("one", "一档"),
    TOW("tow", "二档"),
    THREE("three", "三挡");

    // 场景对应的编码
    private String code;

    // 业务场景描述
    private String desc;

    GearType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }
    // 省略 get set 方法
}