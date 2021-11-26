package com.dyh.test.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Description
 * @Author zhumh
 * @Date 9/23/21 5:51 PM
 */
@Getter
@AllArgsConstructor
public enum OrderEnum {
    ASC(1, "顺序"),
    DESC(2, "逆序"),
    ;

    private Integer code;
    private String desc;

    public static Set<Integer> orderCodeSet(){
        Set<Integer> orderCodeSet = new HashSet<>();
        for (OrderEnum e: OrderEnum.values()) {
            orderCodeSet.add(e.getCode());
        }
        return orderCodeSet;
    }

    public static OrderEnum getByCode(Integer code){
        OrderEnum[] orderEnums = OrderEnum.values();
        for (OrderEnum orderEnum: orderEnums){
            if(Objects.equals(orderEnum.getCode(), code)){
                return orderEnum;
            }
        }
        return null;
    }
}
