package com.abhi.server.userservice.api;

import com.abhi.server.userservice.handlers.LoginHandler;
import com.abhi.server.userservice.handlers.LoginHandlerException;
import com.abhi.server.userservice.handlers.LoginHandlerFactory;
import com.abhi.server.userservice.request.LoginRequest;
import com.abhi.server.userservice.response.LoginResponse;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("login")
public class LoginResource {



    private LoginHandlerFactory loginHandlerFactory;

    @Inject
    LoginResource(LoginHandlerFactory loginHandlerFactory){
        this.loginHandlerFactory = loginHandlerFactory;
    }

    @Path("/2FA")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHelloPlain(@QueryParam("user") String user) {
        System.out.println("/2FA query user : "+ user);
        return ("2fa for user : "+ user);
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginRequest login){
        if(login == null){
            throw new IllegalArgumentException("User Object can not be null!!");
        }

        LoginHandler handler = loginHandlerFactory.getLoginHandler(login);
        if(handler != null){
            try {
                LoginResponse response =  handler.handleLogin(login);
                return response.getResponse(200);
            } catch (LoginHandlerException e) {
                return Response.serverError()
                        .status(400)
                        .entity("{\"error\":\"" + e.getMessage()
                                +  "\"}")
                        .build();
            }
        }
        else{
            return Response.serverError()
                    .status(400)
                    .entity("{\"error\":\"" + "Internal error(No Login Handlers)"
                            +  "\"}")
                    .build();
        }
    }
}
