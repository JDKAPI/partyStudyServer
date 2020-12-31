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
    public int verifyAccount(Login login) {
        if(login.getType()==3&&studentMapper.verifyAccount(login.getId(),login.getPass())>0)
            return 2;

        else if(login.getType()==1&&adminMapper.verifyAccount(login.getId(), login.getPass())>0)
            return 1;
        else if(login.getType()==2&&organizationerMapper.verifyAccount(login.getId(), login.getPass())>0)
            return 3;
        else return 0;
    }
}
