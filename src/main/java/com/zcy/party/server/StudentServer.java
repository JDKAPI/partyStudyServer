package com.zcy.party.server;


import com.zcy.party.domain.Student;

import java.util.List;

public interface StudentServer {
    Student getStuByStuID(String id);
    List<Student> getAllStudentInfo();
}
