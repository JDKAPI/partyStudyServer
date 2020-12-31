package com.zcy.party.dao;

import com.zcy.party.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    User verifyAccount(String account, String password);
}
