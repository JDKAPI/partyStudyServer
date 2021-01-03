package com.zcy.party.dao;

import com.zcy.party.domain.Organizationer;
import com.zcy.party.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationerMapper {
    User verifyAccount(String account, String password);
    String getNameById(int id);
    List<Organizationer> getAllOrganizationer();
    int updateInfo(Organizationer organizationer);
    int deleteTeacher(String account);
    int insertTeacher(Organizationer organizationer);
}
