package com.dyh.test.enums;


public enum TopicPackSubject implements IEnum {
    /**
     * 理数
     */
    SCIENCE(1,"理数"),
    /**
     * 文数
     */
    LIBERAL_ARTS(2,"文数"),
    ;
    private int key;

    private String value;

    TopicPackSubject(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String key()  {
        return String.valueOf(this.key);
    }

    @Override
    public String value() {
        return this.value;
    }

    public static String getValue(int key) {
        TopicPackSubject[] values = values();
        for (TopicPackSubject type : values) {
            if (type.key().equals(String.valueOf(key))) {
                return type.value();
            }
        }
        return null;
    }

    public static Integer getKey(String value) {
        TopicPackSubject[] values = values();
        for (TopicPackSubject type : values) {
            if (type.value().equals(value)) {
                return Integer.parseInt(type.key());
            }
        }
        return null;
    }
}
