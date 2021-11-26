package com.dyh.test.demo;

import com.dyh.test.pojo.ExamScoreDto;
import com.dyh.test.pojo.KAMBaseDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Java 浅拷贝和深拷贝
 * description: dyh
 * author: Administrator
 * date: 2021/3/1 0001 15:47
 */
public class Copy {
    public static void main(String[] args) {
        List<KAMBaseDto> list = new ArrayList<>();
        KAMBaseDto kamBaseDto = new KAMBaseDto();
        kamBaseDto.setCode("0");//属性
        ExamScoreDto examScoreDto = new ExamScoreDto();
        kamBaseDto.setExamScoreDto(examScoreDto);//属性是对象

        list.add(kamBaseDto);

        for (KAMBaseDto dto : list){
            System.out.println("a-->"+dto);
            System.out.println("a1-->"+dto.getExamScoreDto());
        }

        List<KAMBaseDto> list1 = list;
        try {
            //属性为对象时，对象也得克隆，要不然还是浅拷贝
            KAMBaseDto kamBaseDto3 = kamBaseDto.clone();
            list1.add(kamBaseDto3);// add
            for (KAMBaseDto dto : list1){
                System.out.println("b-->"+dto);
                System.out.println("b1-->"+dto.getExamScoreDto());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    //对象拷贝
    @Override
    public Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }

    //对象里还有对象拷贝
    @Override
    public User clone() throws CloneNotSupportedException {
        User user = (User) super.clone();
        user.setAddress(this.address.clone());
        return user;
    }
    */
}
