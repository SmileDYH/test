package com.dyh.test.model.enums;

/**
 * description: 学科分类
 * date: 2020/12/15 18:30
 * @author Administrator
 */
public enum SubjectCategoryEnum implements IEnum {

    ALL(0,"全学科"),
    WEN_KE(1,"文科"),
    LI_KE(2,"理科");

    private int key;

    private String value;

    SubjectCategoryEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String key() {
        return String.valueOf(this.key);
    }

    @Override
    public String value() {
        return String.valueOf(value);
    }


    public int tokey() {
        return this.key;
    }
}
