package com.abhi.server.userservice.handlers;

import com.abhi.server.userservice.request.LoginRequest;
import com.abhi.server.userservice.response.LoginResponse;

import javax.ws.rs.core.Response;

public interface LoginHandler {

    public LoginResponse handleLogin(LoginRequest loginRequest) throws LoginHandlerException;
}
