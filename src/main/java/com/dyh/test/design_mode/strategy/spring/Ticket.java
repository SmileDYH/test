package com.dyh.test.design_mode.strategy.spring;

public class Ticket {
    private String desc;

    public Ticket(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
