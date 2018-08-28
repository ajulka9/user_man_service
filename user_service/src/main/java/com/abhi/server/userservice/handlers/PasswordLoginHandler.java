package com.abhi.server.userservice.handlers;

import com.abhi.server.userservice.request.LoginRequest;
import com.abhi.server.userservice.response.LoginResponse;

import javax.ws.rs.core.Response;


public class PasswordLoginHandler implements LoginHandler {
    @Override
    public LoginResponse handleLogin(LoginRequest request) {
        String user  = request.getUsername();
        String pass = request.getPassword();

        System.out.println("User : "+ user);
        System.out.println("Pass : "+ pass);



       LoginResponse respone = new LoginResponse();
       respone.setUsername(user);
       respone.setLoginTime(System.currentTimeMillis());
       respone.setFactorType("primary");
       return respone;
    }
}
