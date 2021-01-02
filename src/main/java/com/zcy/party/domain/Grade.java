package com.zcy.party.domain;

import java.sql.Timestamp;

public class Grade {
    int id;
    private int CorrectedNum;
    private int DisCorrectedNum;
    private String questionMaster;
    private Timestamp createTime;
    private String stu_id;

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public Grade(int correctedNum, int disCorrectedNum, String questionMaster, String stu_id) {
        this.CorrectedNum = correctedNum;
        this.DisCorrectedNum = disCorrectedNum;
        this.questionMaster = questionMaster;
        this.stu_id = stu_id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public String getQuestionMaster() {
        return questionMaster;
    }
    public void setQuestionMaster(String questionMaster) {
        this.questionMaster = questionMaster;
    }
}
