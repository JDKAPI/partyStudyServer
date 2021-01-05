package com.zcy.party.server.impl;

import com.zcy.party.dao.StudentMapper;
import com.zcy.party.domain.Paper;
import com.zcy.party.domain.ResultData;
import com.zcy.party.domain.StuPaper;
import com.zcy.party.domain.Student;
import com.zcy.party.server.StudentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServerImpl implements StudentServer {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public Student getStuByStuID(String id) {
        return studentMapper.getStuByStuID(id);
    }

    @Override
    public List<Student> getAllStudentInfo() {
        return studentMapper.getAllStudentInfo();
    }

    @Override
    public List<ResultData> getMeigeSchoolRenshu() {
        return studentMapper.getMeigeSchoolRenshu();
    }

    @Override
    public List<Student> getStuByTeacherId(int id) {
        return studentMapper.getStuByTeacherId(id);
    }

    @Override
    public int sendPaperToStudent(String stu_id, int paper_id) {
        return studentMapper.sendPaperToStudent(stu_id,paper_id);
    }

    @Override
    public List<StuPaper> getMyPaper(String id) {
        return studentMapper.getMyPaper(id);
    }
}
