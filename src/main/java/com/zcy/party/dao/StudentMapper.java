package com.zcy.party.dao;


import com.zcy.party.domain.Student;
import com.zcy.party.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentMapper {
    User verifyAccount(String stu_id, String stu_pass);
    Student getStuByStuID(String id);
    List<Student> getAllStudentInfo();
    int deleteStudent(String id);
    int updateStudentById(Student student);
    int insertStudent(Student student);
}
