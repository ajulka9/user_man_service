package com.abhi.server.userservice.handlers;

import com.abhi.server.userservice.request.LoginRequest;
import org.jvnet.hk2.annotations.Contract;

@Contract
public interface LoginHandlerFactory {

    public LoginHandler getLoginHandler(LoginRequest login);
}
