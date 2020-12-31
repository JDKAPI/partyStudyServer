package com.zcy.party.server;

import com.zcy.party.domain.Login;
import com.zcy.party.domain.User;

public interface LoginServer {
    User verifyAccount(Login login);
}
