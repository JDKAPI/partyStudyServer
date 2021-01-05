package com.zcy.party.dao;

import com.zcy.party.domain.StuAnswer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StuAnswerMapper {
    int insertStuAnswer(String stuId,int paperId,float objGrade,String eryi,String erer,String ersan,String ersi,String erwu);
    List<StuAnswer> getAllAnswer();
    StuAnswer getAnswerById(int id);
    int insertSubGrade(int id,float subGrade);
}
