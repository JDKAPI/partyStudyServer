package com.zcy.party.server.impl;

import com.zcy.party.dao.OrganizationerMapper;
import com.zcy.party.domain.Organizationer;
import com.zcy.party.server.AdminServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServerImpl implements AdminServer {
    @Autowired
    OrganizationerMapper organizationerMapper;
    @Override
    public List<Organizationer> getAllOrganizationer() {
        return organizationerMapper.getAllOrganizationer();
    }

    @Override
    public int updateInfo(Organizationer organizationer) {
        return organizationerMapper.updateInfo(organizationer);
    }
}
