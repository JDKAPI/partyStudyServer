package com.zcy.party.domain;

import java.util.List;

public class Student {
    private String stu_id;
    private String stu_pass;
    private String stu_name;
    private String stu_grade;
    private String stu_school;
    private String stu_orgamem;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    private String major;
    private List<Grade> grades;
    public Student(){

    }
    public Student(String stu_id, String stu_pass, String stu_name, String stu_grade, String stu_school, String stu_orgamem,String major) {
        this.stu_id = stu_id;
        this.stu_pass = stu_pass;
        this.stu_name = stu_name;
        this.stu_grade = stu_grade;
        this.stu_school = stu_school;
        this.stu_orgamem = stu_orgamem;
        this.major = major;
    }

    public List<Grade> getGrades() {
        return grades;
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

    public String getStu_school() {
        return stu_school;
    }

    public void setStu_school(String stu_school) {
        this.stu_school = stu_school;
    }

    public String getStu_orgamem() {
        return stu_orgamem;
    }

    public void setStu_orgamem(String stu_orgamem) {
        this.stu_orgamem = stu_orgamem;
    }
}
