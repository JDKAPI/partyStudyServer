package com.zcy.party.server;

import com.zcy.party.domain.Organizationer;

import java.util.List;


public interface AdminServer {
    List<Organizationer> getAllOrganizationer();
    int updateInfo(Organizationer organizationer);
}
