package com.zcy.party.server;

import com.zcy.party.domain.Login;

public interface LoginServer {
    boolean verifyAccount(Login login);
}
