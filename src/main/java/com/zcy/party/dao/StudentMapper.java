package com.zcy.party.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {
    int verifyAccount(String stu_id,String stu_pass);
}
