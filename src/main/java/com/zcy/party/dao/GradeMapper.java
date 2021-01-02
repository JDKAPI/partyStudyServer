package com.zcy.party.dao;

import com.zcy.party.domain.Grade;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeMapper {
   List<Grade> getAllGrade(String stu_id);
   void insertStuGrade(Grade grade);
}
