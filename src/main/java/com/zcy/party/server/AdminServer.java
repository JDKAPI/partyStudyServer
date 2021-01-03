package com.zcy.party.server;

import com.zcy.party.domain.Organizationer;
import com.zcy.party.domain.Student;

import java.util.List;


public interface AdminServer {
    List<Organizationer> getAllOrganizationer();
    int updateInfo(Organizationer organizationer);
    int deleteTeacher(String account);
    int insertTeacher(Organizationer organizationer);
    int deleteStudent(String id);
    int updateStudent(String id,String pass,String name,String grade,String major,int school);
    int insertStudent(Student student);
}
