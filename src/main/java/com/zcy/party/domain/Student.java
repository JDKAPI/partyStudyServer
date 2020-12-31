package com.zcy.party.domain;

public class Student implements User{
    private String stu_id;
    private String stu_pass;
    private String stu_name;
    private String stu_grade;
    private int stu_school;
    private int stu_orgamem;

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
