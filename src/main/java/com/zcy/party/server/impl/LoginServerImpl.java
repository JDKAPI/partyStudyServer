package com.zcy.party.server.impl;

import com.zcy.party.dao.AdminMapper;
import com.zcy.party.dao.OrganizationerMapper;
import com.zcy.party.dao.StudentMapper;
import com.zcy.party.domain.Login;
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
    public boolean verifyAccount(Login login) {
        if(login.getType()==2)
            return studentMapper.verifyAccount(login.getId(),login.getPass())>0?true:false;
        else if(login.getType()==1)
            return adminMapper.verifyAccount(login.getId(), login.getPass())>0?true:false;
        else
            return organizationerMapper.verifyAccount(login.getId(), login.getPass())>0?true:false;
    }
}
