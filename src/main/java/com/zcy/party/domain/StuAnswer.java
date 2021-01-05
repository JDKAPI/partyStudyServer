package com.zcy.party.domain;

public class StuAnswer {
    int id;
    Student stuId;
    Paper paper;
    float objGrade;
    String eryi;
    String erer;
    String ersan;
    String ersi;
    String erwu;

    public float getObjGrade() {
        return objGrade;
    }

    public void setObjGrade(float objGrade) {
        this.objGrade = objGrade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStuId() {
        return stuId;
    }

    public void setStuId(Student stuId) {
        this.stuId = stuId;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public String getEryi() {
        return eryi;
    }

    public void setEryi(String eryi) {
        this.eryi = eryi;
    }

    public String getErer() {
        return erer;
    }

    public void setErer(String erer) {
        this.erer = erer;
    }

    public String getErsan() {
        return ersan;
    }

    public void setErsan(String ersan) {
        this.ersan = ersan;
    }

    public String getErsi() {
        return ersi;
    }

    public void setErsi(String ersi) {
        this.ersi = ersi;
    }

    public String getErwu() {
        return erwu;
    }

    public void setErwu(String erwu) {
        this.erwu = erwu;
    }
}
