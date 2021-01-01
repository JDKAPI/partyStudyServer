package com.zcy.party.domain;

public class Student {
    private String stu_id;
    private String stu_pass;
    private String stu_name;
    private String stu_grade;
    private int stu_school;
    private int stu_orgamem;
    private int AnswerTimes;
    private int CorrectedNum;
    private int DisCorrectedNum;
    private int MinNums;
    private int MAx;
    public Student(){

    }
    public Student(String stu_id, String stu_pass, String stu_name, String stu_grade, int stu_school, int stu_orgamem, int answerTimes, int correctedNum, int disCorrectedNum, int minNums, int MAx) {
        this.stu_id = stu_id;
        this.stu_pass = stu_pass;
        this.stu_name = stu_name;
        this.stu_grade = stu_grade;
        this.stu_school = stu_school;
        this.stu_orgamem = stu_orgamem;
        this.AnswerTimes = answerTimes;
        this.CorrectedNum = correctedNum;
        this.DisCorrectedNum = disCorrectedNum;
        this.MinNums = minNums;
        this.MAx = MAx;
    }

    public int getAnswerTimes() {
        return AnswerTimes;
    }

    public void setAnswerTimes(int answerTimes) {
        AnswerTimes = answerTimes;
    }

    public int getCorrectedNum() {
        return CorrectedNum;
    }

    public void setCorrectedNum(int correctedNum) {
        CorrectedNum = correctedNum;
    }

    public int getDisCorrectedNum() {
        return DisCorrectedNum;
    }

    public void setDisCorrectedNum(int disCorrectedNum) {
        DisCorrectedNum = disCorrectedNum;
    }

    public int getMinNums() {
        return MinNums;
    }

    public void setMinNums(int minNums) {
        MinNums = minNums;
    }

    public int getMAx() {
        return MAx;
    }

    public void setMAx(int MAx) {
        this.MAx = MAx;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_pass() {
        return stu_pass;
    }

    public void setStu_pass(String stu_pass) {
        this.stu_pass = stu_pass;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_grade() {
        return stu_grade;
    }

    public void setStu_grade(String stu_grade) {
        this.stu_grade = stu_grade;
    }

    public int getStu_school() {
        return stu_school;
    }

    public void setStu_school(int stu_school) {
        this.stu_school = stu_school;
    }

    public int getStu_orgamem() {
        return stu_orgamem;
    }

    public void setStu_orgamem(int stu_orgamem) {
        this.stu_orgamem = stu_orgamem;
    }
}
