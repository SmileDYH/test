package com.dyh.test.model.pojo;

import java.io.Serializable;
import java.util.List;


/**
 * 知识点、能力、方法等的基础数据信息
 *
 * Object的clone()方法是浅拷贝，需要重写，并且只有实现了Cloneable才可以调用该方法
 *
 * clone() 方法并不是 Cloneable 接口的方法，而是 Object 的一个 protected 方法。
 * Cloneable 接口只是规定，如果一个类没有实现 Cloneable 接口又调用了 clone() 方法，就会抛出 CloneNotSupportedException。
 */

public class KAMBaseDto implements Serializable,Cloneable {


    /**
     * 题型、难度、知识点的code，能力
     */
    private String code;


    private String name;

    /**
     * 试题总数
     */
    private Integer questionNumber ;

    private ExamScoreDto examScoreDto;

    private List<ExamScoreAvgDto> examScoreAvgDtoList;

    /**
     * 总分
     */
    private Double totalScore ;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public ExamScoreDto getExamScoreDto() {
        return examScoreDto;
    }

    public void setExamScoreDto(ExamScoreDto examScoreDto) {
        this.examScoreDto = examScoreDto;
    }

    @Override
    public KAMBaseDto clone() throws CloneNotSupportedException {
        KAMBaseDto kamBaseDto = (KAMBaseDto) super.clone();
        kamBaseDto.setExamScoreDto(this.examScoreDto.clone());
        return kamBaseDto;
    }

    public KAMBaseDto() {
    }

    public KAMBaseDto(String code, Integer questionNumber) {
        this.code = code;
        this.questionNumber = questionNumber;
    }

    public List<ExamScoreAvgDto> getExamScoreAvgDtoList() {
        return examScoreAvgDtoList;
    }

    public void setExamScoreAvgDtoList(List<ExamScoreAvgDto> examScoreAvgDtoList) {
        this.examScoreAvgDtoList = examScoreAvgDtoList;
    }
}
