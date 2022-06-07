package com.dyh.test.model.enums;

/**
 * 档位枚举
 */
public enum ReviewType {

    SINGLE("one", "单评"),
    DOUBLE("tow", "双评"),
    ;

    // 场景对应的编码
    private String code;

    // 业务场景描述
    private String desc;

    ReviewType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }
    // 省略 get set 方法
}