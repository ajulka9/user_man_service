package com.abhi.server.userservice.handlers;

public class LoginHandlerException extends Exception {
    private String message;
    public LoginHandlerException(String msg){
        this.message = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
