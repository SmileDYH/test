package com.dyh.test.model.pojo;

import java.io.Serializable;
import java.util.List;


/**
 * 知识点、能力、方法等的基础数据信息
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
