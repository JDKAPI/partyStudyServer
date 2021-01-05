package com.zcy.party.server;

import com.zcy.party.domain.StuAnswer;

import java.util.List;

public interface StuAnswerServer {
    int insertStuAnswer(String stuId,int paperId,float objGrade,String eryi,String erer,String ersan,String ersi,String erwu);
    List<StuAnswer> getAllAnswer();
    StuAnswer getAnswerById(int id);
    int insertSubGrade(int id,float subGrade);
}
