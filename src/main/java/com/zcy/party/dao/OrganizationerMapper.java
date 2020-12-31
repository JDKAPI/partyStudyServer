package com.zcy.party.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationerMapper {
    int verifyAccount(String account,String password);
}
