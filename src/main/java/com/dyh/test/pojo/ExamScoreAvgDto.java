package com.dyh.test.pojo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 学科平均分dto
 * description: dyh
 * author: Administrator
 * date: 2020/12/18 0018 9:28
 */
@Data
@Builder
@AllArgsConstructor
public class ExamScoreAvgDto implements Serializable {

    /**
     * 区域名称（市）
     */
    private String areaName;

    /**
     * 学校名称（区县 学校）
     */
    private String schoolName;

    /**
     * 班级名称
     */
    private String className;

    /**
     * 总分
     */
    private double total;

    /**
     * 语文
     */
    private double language;

    /**
     * 数学
     */
    private double mathematics;

    /**
     * 英语
     */
    private double english;

    /**
     * 政治
     */
    private double politics;

    /**
     * 历史
     */
    private double history;

    /**
     * 地理
     */
    private double geography;

    /**
     * 物理
     */
    private double physics;

    /**
     * 化学
     */
    private double chemistry;

    /**
     * 生物
     */
    private double biology;

    /**
     * 总分排名
     */
    private String totalOrder;

    /**
     * 语文排名
     */
    private String languageOrder;

    /**
     * 数学排名
     */
    private String mathematicsOrder;

    /**
     * 英语排名
     */
    private String englishOrder;

    /**
     * 政治排名
     */
    private String politicsOrder;

    /**
     * 历史排名
     */
    private String historyOrder;

    /**
     * 地理排名
     */
    private String geographyOrder;

    /**
     * 物理排名
     */
    private String physicsOrder;

    /**
     * 化学排名
     */
    private String chemistryOrder;

    /**
     * 生物排名
     */
    private String biologyOrder;

    /**
     * 序号
     */
    private String no;

    public ExamScoreAvgDto() {
    }
    public ExamScoreAvgDto(double language, String languageOrder) {
        this.language = language;
        this.languageOrder = languageOrder;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getLanguage() {
        return language;
    }

    public void setLanguage(double language) {
        this.language = language;
    }

    public double getMathematics() {
        return mathematics;
    }

    public void setMathematics(double mathematics) {
        this.mathematics = mathematics;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public double getPolitics() {
        return politics;
    }

    public void setPolitics(double politics) {
        this.politics = politics;
    }

    public double getHistory() {
        return history;
    }

    public void setHistory(double history) {
        this.history = history;
    }

    public double getGeography() {
        return geography;
    }

    public void setGeography(double geography) {
        this.geography = geography;
    }

    public double getPhysics() {
        return physics;
    }

    public void setPhysics(double physics) {
        this.physics = physics;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public double getBiology() {
        return biology;
    }

    public void setBiology(double biology) {
        this.biology = biology;
    }

    public String getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(String totalOrder) {
        this.totalOrder = totalOrder;
    }

    public String getLanguageOrder() {
        return languageOrder;
    }

    public void setLanguageOrder(String languageOrder) {
        this.languageOrder = languageOrder;
    }

    public String getMathematicsOrder() {
        return mathematicsOrder;
    }

    public void setMathematicsOrder(String mathematicsOrder) {
        this.mathematicsOrder = mathematicsOrder;
    }

    public String getEnglishOrder() {
        return englishOrder;
    }

    public void setEnglishOrder(String englishOrder) {
        this.englishOrder = englishOrder;
    }

    public String getPoliticsOrder() {
        return politicsOrder;
    }

    public void setPoliticsOrder(String politicsOrder) {
        this.politicsOrder = politicsOrder;
    }

    public String getHistoryOrder() {
        return historyOrder;
    }

    public void setHistoryOrder(String historyOrder) {
        this.historyOrder = historyOrder;
    }

    public String getGeographyOrder() {
        return geographyOrder;
    }

    public void setGeographyOrder(String geographyOrder) {
        this.geographyOrder = geographyOrder;
    }

    public String getPhysicsOrder() {
        return physicsOrder;
    }

    public void setPhysicsOrder(String physicsOrder) {
        this.physicsOrder = physicsOrder;
    }

    public String getChemistryOrder() {
        return chemistryOrder;
    }

    public void setChemistryOrder(String chemistryOrder) {
        this.chemistryOrder = chemistryOrder;
    }

    public String getBiologyOrder() {
        return biologyOrder;
    }

    public void setBiologyOrder(String biologyOrder) {
        this.biologyOrder = biologyOrder;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
