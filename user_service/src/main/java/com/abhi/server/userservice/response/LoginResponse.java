package com.abhi.server.userservice.response;

import com.google.gson.Gson;

public class LoginResponse extends AbstractResponse {

    public String username;
    public long loginTime;
    public String factorType;

    public String getUsername() {
        return username;
    }

    public long getLoginTime() {
        return loginTime;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }

    public String getFactorType() {
        return factorType;
    }

    public void setFactorType(String factorType) {
        this.factorType = factorType;
    }

}
