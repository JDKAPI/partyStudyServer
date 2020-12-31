package com.zcy.party.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    int verifyAccount(String account,String password);
}
