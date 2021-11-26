/**
 * ExamScoreDto.java
 * net.tfedu.report.dto
 * Copyright (c) 2020, 知好乐教育集团版权所有.
 */
package com.dyh.test.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 考试数据看板-分数Dto
 *
 * @author liujn
 * @Date 2020-12-14
 */

public class ExamScoreDto implements Serializable,Cloneable {

    /**
     * id
     */
    private long id;
    /**
     * exam_subject_id
     */
    private long examSubjectId;
    /**
     * 考试id
     */
    private long examId;
    /**
     * 考试name
     */
    private String examName;
    /**
     * 学科id
     */
    private int subjectId;
    /**
     * 题包id
     */
    private long topicPackId;
    /**
     * 学校id
     */
    private long schoolId;
    /**
     * 学校名称
     */
    private String schoolName;
    /**
     * 班级id
     */
    private long classId;
    /**
     * 班级名称
     */
    private String className;
    /**
     * 考生姓名
     */
    private String studentName;
    /**
     * 学生号
     */
    private String studentNumber;
    /**
     * 考号
     */
    private long examNumber;
    /**
     * 总分
     */
    private double totalScore;
    /**
     * 创建人
     */
    private long createrId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * appId
     */
    private long appId;
    /**
     * 删除标识
     */
    private boolean deleteMark;
	/**
	 * 学校区域编码
	 */
	private String areaCode;
    /**
     * 学科分类，1：文科，2：理科
     */
	private int subjectCategory;
    /**
     * 省名称
     */
    private String provinceName;
    /**
     * 市名称
     */
    private String cityName;
    /**
     * 区县名称
     */
    private String districtName;
    /**
     * 学生总分（学生各科总分相加）
     */
    private double studentScore;

    public ExamScoreDto() {}

    public ExamScoreDto(double studentScore,int subjectCategory) {
        this.studentScore = studentScore;
        this.subjectCategory = subjectCategory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getExamSubjectId() {
        return examSubjectId;
    }

    public void setExamSubjectId(long examSubjectId) {
        this.examSubjectId = examSubjectId;
    }

    public long getExamId() {
        return examId;
    }

    public void setExamId(long examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public long getTopicPackId() {
        return topicPackId;
    }

    public void setTopicPackId(long topicPackId) {
        this.topicPackId = topicPackId;
    }

    public long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(long schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public long getExamNumber() {
        return examNumber;
    }

    public void setExamNumber(long examNumber) {
        this.examNumber = examNumber;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public long getCreaterId() {
        return createrId;
    }

    public void setCreaterId(long createrId) {
        this.createrId = createrId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    public boolean isDeleteMark() {
        return deleteMark;
    }

    public void setDeleteMark(boolean deleteMark) {
        this.deleteMark = deleteMark;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public int getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(int subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public double getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(double studentScore) {
        this.studentScore = studentScore;
    }

    @Override
    public ExamScoreDto clone() throws CloneNotSupportedException {
        return (ExamScoreDto) super.clone();
    }
}