package com.zcy.party.dao;

import com.zcy.party.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {
    User verifyAccount(String stu_id, String stu_pass);
    void insertGrade(String id,int AnswerTimes, int CorrectedNum,int DisCorrectedNum,int MinNum,int MaxNum);
}
