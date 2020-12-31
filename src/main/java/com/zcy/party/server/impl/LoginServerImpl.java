package com.zcy.party.server.impl;

import com.zcy.party.dao.AdminMapper;
import com.zcy.party.dao.OrganizationerMapper;
import com.zcy.party.dao.StudentMapper;
import com.zcy.party.domain.Login;
import com.zcy.party.domain.User;
import com.zcy.party.server.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServerImpl implements LoginServer {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    OrganizationerMapper organizationerMapper;
    @Override
    public User verifyAccount(Login login) {
        if(studentMapper.verifyAccount(login.getId(),login.getPass())!=null&&studentMapper.verifyAccount(login.getId(),login.getPass()).getType()==3) {
            return studentMapper.verifyAccount(login.getId(),login.getPass());
        }
        else if(adminMapper.verifyAccount(login.getId(),login.getPass())!=null&&adminMapper.verifyAccount(login.getId(),login.getPass()).getType()==1){
            return adminMapper.verifyAccount(login.getId(),login.getPass());
        }
        else if(organizationerMapper.verifyAccount(login.getId(),login.getPass())!=null&&organizationerMapper.verifyAccount(login.getId(),login.getPass()).getType()==2){
            return organizationerMapper.verifyAccount(login.getId(),login.getPass());
        }
        else return null;
    }
}
