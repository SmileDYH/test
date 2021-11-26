package com.dyh.test.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * description: 比较枚举
 * author: dyh
 * date: 2021/10/11 13:21
 */
@Getter
@AllArgsConstructor
public enum CompareEnum {

    GT(1, "大于"),
    LT(2, "小于"),
    GTE(3, "大于等于"),
    LTE(4, "小于等于");

    final private Integer type;
    private String name;
}
