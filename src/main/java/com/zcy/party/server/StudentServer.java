package com.zcy.party.server;


import com.zcy.party.domain.Paper;
import com.zcy.party.domain.ResultData;
import com.zcy.party.domain.StuPaper;
import com.zcy.party.domain.Student;

import java.util.List;

public interface StudentServer {
    Student getStuByStuID(String id);
    List<Student> getAllStudentInfo();
    List<ResultData> getMeigeSchoolRenshu();
    List<Student> getStuByTeacherId(int id);
    int sendPaperToStudent(String stu_id,int paper_id);
    List<StuPaper>  getMyPaper(String id);
}
