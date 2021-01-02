package com.zcy.party.server.impl;

import com.zcy.party.dao.GradeMapper;
import com.zcy.party.domain.Grade;
import com.zcy.party.server.GradeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

@Service
public class GradeServerImpl implements GradeServer {
    @Autowired
    GradeMapper gradeMapper;
    @Override
    public void insertStuGrade(Grade grade) {
        gradeMapper.insertStuGrade(grade);
    }
}
