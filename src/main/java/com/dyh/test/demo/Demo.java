package com.dyh.test.demo;

import com.alibaba.fastjson.JSONArray;
import com.dyh.test.exception.LambdaException;
import com.dyh.test.enums.SubjectCategoryEnum;
import com.dyh.test.enums.TopicPackSubject;
import com.dyh.test.pojo.ExamScoreAvgDto;
import com.dyh.test.pojo.ExamScoreDto;
import com.dyh.test.pojo.KAMBaseDto;
import com.google.common.util.concurrent.AtomicDouble;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * demo留存
 * description:dyh
 * author: Administrator
 * date: 2020/11/25 0025 11:52
 */
public class Demo {
    static double totalSoore = 0.0;

    public static void main(String[] args) {

//        demo1();
//        demo2();
//        demo3();
//        addAll();
        //demo4();
        //demo5();
//        finalDemo();
//        listDemo();
//        lambdaListDemo();
//        demo6();
//        subListDemo();
//        toCharArray();
//        fileter();
//        atomic();
        //Object... objects
//        object();
//        switchCase();
//        sortGroup();
        lambdaReturn();

//        AtomicInteger i = new AtomicInteger();
//        valuePropagation(i);
//        System.out.println("i-->"+i);

//        String s = "";
//        Double a = 0.0;
//        Long b = 10000111L;
//        b.floatValue();
//        System.out.println("aaaa--->"+b.floatValue());
    }

    static void demo1() {

        System.out.println(TopicPackSubject.values());
    }

    static void demo2() {
        String str = "[1,2,333]";
        JSONArray jsonArray = JSONArray.parseArray(str);
        System.out.println(jsonArray);
        System.out.println(jsonArray.size());

    }

    static void demo3() {
        List<KAMBaseDto> target = new ArrayList<>();
        KAMBaseDto dto = new KAMBaseDto();
        dto.setTotalScore(11.0);
        dto.setCode("1");
        KAMBaseDto dto1 = new KAMBaseDto();
        dto1.setTotalScore(12.0);
        dto1.setCode("2");
        target.add(dto);
        target.add(dto1);


        System.out.println("code--->" + target.get(0));
        List<KAMBaseDto> targetParam = target;
        //targetParam.addAll(target);

        //target.get(0).setTotalScore(20.0);
        //targetParam.stream().forEach(p -> System.out.println("targetParam--->"+p.getTotalScore()));


        target.stream().collect(Collectors.groupingBy(KAMBaseDto::getCode)).entrySet().forEach(entry -> {
            System.out.println("code--->" + entry.getValue().get(0).getTotalScore());
            //entry.getValue().get(0).setTotalScore(20.0);
            totalSoore = target.stream().collect(Collectors.summingDouble(KAMBaseDto::getTotalScore));
        });
        System.out.println(totalSoore);
    }

    static void addAll() {
        //基本类型拷贝
        List<Integer> list = new ArrayList<>();
        Integer a = 1;
        Integer b = 2;
        list.add(a);
        list.add(b);
        list.stream().forEach(p -> System.out.println("list--->" + p));
        List<Integer> list1 = new ArrayList<>();
        list1.addAll(list);
        //list.set(0,3);
        list1.set(0, 3);
        a = 3;
        list1.stream().forEach(p -> System.out.println("list1--->" + p));
        list.stream().forEach(p -> System.out.println("listX--->" + p));

        List<KAMBaseDto> listDto = new ArrayList<>();
        KAMBaseDto c = new KAMBaseDto();
        c.setTotalScore(10.0);
        listDto.add(c);
        listDto.stream().forEach(p -> System.out.println("list--->" + p.getTotalScore()));
        List<KAMBaseDto> listDto1 = new ArrayList<>();
        listDto1.addAll(listDto);
        c.setTotalScore(12.0);
        listDto1.stream().forEach(p -> System.out.println("list1--->" + p.getTotalScore()));
        listDto.stream().forEach(p -> System.out.println("listX--->" + p.getTotalScore()));

        List<Integer> newList = Arrays.asList(new Integer[list.size()]);
        System.out.println("size--->" + newList.size());
        Collections.copy(newList, list);
        System.out.println("newList--->" + newList);

        List<KAMBaseDto> newList1 = Arrays.asList(new KAMBaseDto[listDto.size()]);
        System.out.println("size--->" + newList1.size());
        Collections.copy(newList1, listDto);
        c.setTotalScore(14.0);
        System.out.println("newList--->" + newList1.get(0).getTotalScore());
        listDto.stream().forEach(p -> System.out.println("listX--->" + p.getTotalScore()));
    }

    static void demo4() {
        List<ExamScoreDto> examScoreDtoList = new ArrayList<>();
        ExamScoreDto examScoreDto = new ExamScoreDto();
        examScoreDto.setStudentScore(10);
        examScoreDtoList.add(examScoreDto);
        System.out.println(examScoreDtoList.stream().filter(p -> p.getStudentScore() >= 10).count());
    }

    static void demo5() {
        List<String> strList1 = new ArrayList<>();
        strList1.add("d");
        strList1.add("e");
        strList1.add("f");
        strList1.add("g");
        System.out.println(strList1.toString());

        List<String> strList2 = new ArrayList<>();
        strList2.add("a");
        strList2.add("b");
        strList2.add("c");
        strList1.addAll(0, strList2);
        strList1.add(0, "0");
        System.out.println(strList1.toString());
    }

    static void finalDemo() {
        final int i = 0;
        final Integer ii = 0;
        final AtomicInteger iii = new AtomicInteger();
        System.out.println(i);
        System.out.println(ii);
        System.out.println(iii);
        //i = 1;   编译失败
        //ii = 1;   编译失败
        //iii = new AtomicInteger(1);   编译失败
        System.out.println(i);
        System.out.println(ii);
        System.out.println(iii.incrementAndGet());

        AtomicInteger a = new AtomicInteger();
        System.out.println(a.incrementAndGet());
        a = new AtomicInteger(10);
        System.out.println(a);
    }

    static void listDemo() {
        List<ExamScoreDto> list = new ArrayList<>();
        System.out.println("list.size--->" + list.size());
        System.out.println("list.get--->" + list.get(0));
    }

    static void lambdaListDemo() {
        List<ExamScoreDto> list = new ArrayList<>();
        list.add(new ExamScoreDto(10.0, 1));
        list.add(new ExamScoreDto(20.0, 2));
        list.add(new ExamScoreDto(11.0, 1));

        long liberalArtsCount = list.stream().filter(p -> p.getSubjectCategory() == SubjectCategoryEnum.WEN_KE.tokey()).count();
        double min = list.stream().filter(p -> p.getSubjectCategory() == SubjectCategoryEnum.WEN_KE.tokey())
                .sorted(Comparator.comparing(ExamScoreDto::getStudentScore).reversed()).collect(Collectors.toList())
                .subList(0, (int) Math.round(liberalArtsCount * 100 / 100))
                .stream().findFirst().orElse(new ExamScoreDto()).getStudentScore();
        System.out.println("min--->" + min);
    }

    static void demo6() {
        List<ExamScoreAvgDto> examScoreAvgDtoList = new ArrayList<>();
        ExamScoreAvgDto a = new ExamScoreAvgDto(10, "");
        ExamScoreAvgDto b = new ExamScoreAvgDto(20, "");
        examScoreAvgDtoList.add(a);
        examScoreAvgDtoList.add(b);
        examScoreAvgDtoList.add(new ExamScoreAvgDto(20, ""));
        examScoreAvgDtoList.add(new ExamScoreAvgDto(40, ""));

        examScoreAvgDtoList.stream().forEach(p -> System.out.println(p.getLanguage() + " " + p.getLanguageOrder()));

        AtomicInteger i1 = new AtomicInteger();
        AtomicDouble d = new AtomicDouble();
        AtomicInteger iX = new AtomicInteger();
        examScoreAvgDtoList.stream().sorted(Comparator.comparing(ExamScoreAvgDto::getLanguage).reversed())
                .forEachOrdered(p -> {
                    i1.incrementAndGet();
                    if (d.doubleValue() != p.getLanguage()) {
                        iX.set(i1.intValue());
                    }
                    p.setLanguageOrder(String.valueOf(iX));
                    d.set(p.getLanguage());
                });
//        examScoreAvgDtoList.stream().sorted(Comparator.comparing(ExamScoreAvgDto::getLanguage).reversed())
//                .forEach(p -> p.setLanguageOrder(String.valueOf(i1.incrementAndGet())));

        examScoreAvgDtoList.stream().forEach(p -> System.out.println(p.getLanguage() + " " + p.getLanguageOrder()));
    }

    static void subListDemo() {
        List<ExamScoreAvgDto> examScoreAvgDtoList = new ArrayList<>();
        examScoreAvgDtoList.add(new ExamScoreAvgDto(10, ""));
        examScoreAvgDtoList.add(new ExamScoreAvgDto(20, ""));
        examScoreAvgDtoList.add(new ExamScoreAvgDto(30, ""));
        examScoreAvgDtoList.add(new ExamScoreAvgDto(40, ""));

        examScoreAvgDtoList.stream().forEach(p -> System.out.println(p.getLanguage()));
        examScoreAvgDtoList = examScoreAvgDtoList.subList(1, examScoreAvgDtoList.size());
        examScoreAvgDtoList.stream().forEach(p -> System.out.println(p.getLanguage()));
    }

    static void toCharArray() {
        String s = "1234";
        char[] ch = s.toCharArray();
        System.out.println(ch);
    }

    static void fileter() {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
        list = list.stream().filter(p -> p == 1).collect(Collectors.toList());
        list.stream().forEach(p -> System.out.println(p));
    }

    static void atomic() {
        AtomicInteger i = new AtomicInteger(3);
        for (i.intValue(); i.intValue() > 0; i.decrementAndGet()) {
            System.out.println(i);
        }
    }

    static void valuePropagation(AtomicInteger i) {
        for (i.intValue(); i.intValue() < 10; ) {
            System.out.println(i.getAndIncrement());
        }
    }

    static void object() {
        System.out.println("Test");
        obj();
        obj(new Integer(1));
        Integer[] i = {1, 2, 3};
        obj(i);
        int a = 0;
        int b = 1;
        obj(a, b);
    }

    //object()调用
    private static void obj(Object... objects) {
        System.out.println("objects--->" + objects);
    }

    static void switchCase(){
        int a = 0;
        switch (a){
            case 0://常量（final）或者字面常量（0、1、2）
                a = 2;
                System.out.println(2);
                a=1;
                System.out.println(1);
            case 1:
                a = 2;
                System.out.println(2);
                //break;
            default:
                System.out.println(3);
        }
    }

    //lambda排序分组
    static void sortGroup(){
        List<KAMBaseDto> list = new ArrayList<>();
        list.add(new KAMBaseDto("002",5));
        list.add(new KAMBaseDto("002",1));
        list.add(new KAMBaseDto("001",2));
        list.add(new KAMBaseDto("001",1));
        //list.add(new KAMBaseDto("002",5));
        list.add(new KAMBaseDto("001",3));

        list.parallelStream().sorted(Comparator.comparing(KAMBaseDto::getQuestionNumber)).collect(Collectors.groupingBy(KAMBaseDto::getCode)).entrySet().forEach(p -> {
            p.getValue().forEach(value -> System.out.println("code-->"+ value.getQuestionNumber()));
        });
    }

    //lambda跳出循环(快速创建数组)
    static void lambdaReturn(){
        String[] array = {"一","二","三","四","五"};
        List<String> stringList = new ArrayList<>(Arrays.asList(array));
        try {
            stringList.stream().forEach(p -> {
                if ("三".equals(p)){
                    System.out.println("跳出循环！");
                    int i =1/0;
                    throw new LambdaException("终止for循环", 0);
                }
                System.out.println(p);
            });
        }catch (Exception e){
            //e.printStackTrace();
            System.out.println(e.getMessage());
//            System.out.println("throw 跳出循环！");
        }
    }
}
