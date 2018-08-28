package com.abhi.server.userservice;

import com.abhi.server.userservice.handlers.LoginHandlerFactoryImpl;
import com.abhi.server.userservice.handlers.LoginHandler;
import com.abhi.server.userservice.handlers.LoginHandlerFactory;
import com.abhi.server.userservice.handlers.LoginHandlerFactoryImpl;
import com.abhi.server.userservice.manager.UserManager;
import com.abhi.server.userservice.manager.impl.UserManagerImpl;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class MyAbstractBinder extends AbstractBinder {

    @Override
    protected void configure() {

        bind(UserManagerImpl.class).to(UserManager.class);
        bind(LoginHandlerFactoryImpl.class).to(LoginHandlerFactory.class);
    }
}
