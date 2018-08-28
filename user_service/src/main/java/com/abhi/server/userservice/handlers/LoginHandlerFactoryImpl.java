package com.abhi.server.userservice.handlers;

import com.abhi.server.userservice.request.LoginRequest;
import org.jvnet.hk2.annotations.Service;

@Service
public class LoginHandlerFactoryImpl implements LoginHandlerFactory{

    @Override
    public LoginHandler getLoginHandler(LoginRequest login) {
        System.out.println("Login Factory factoryTYpe : "+ login.getFactorType());
        if(login.getFactorType().equalsIgnoreCase("primary")){
            return  new PasswordLoginHandler();
        }
        else{
            return new DuoLoginHandler();
        }
    }
}
