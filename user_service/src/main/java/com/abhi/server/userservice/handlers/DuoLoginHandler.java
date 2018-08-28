package com.abhi.server.userservice.handlers;

import com.abhi.server.userservice.duo.DuoWeb;
import com.abhi.server.userservice.duo.DuoWebException;
import com.abhi.server.userservice.request.LoginRequest;
import com.abhi.server.userservice.response.DuoResponse;
import com.abhi.server.userservice.response.LoginResponse;
import com.fasterxml.jackson.databind.util.JSONPObject;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class DuoLoginHandler implements LoginHandler {

    private static final String ikey = "DIEZWTWELUBXHD6DLJ3U";
    private static final String skey = "xutZbWlNrNddu5e65EeyM0PyONq6I5EcbGKezFdC";
    private static final String akey = "THISISAREALLYLONGSECURESECRETFORDUOFORMFA";
    private static final String host = "api-0095dc4a.duosecurity.com";


    private void updateRequest(LoginRequest request){
        request.setaKey(akey);
        request.setiKey(ikey);
        request.setsKey(skey);
        request.setHost(host);
    }
    @Override
    public LoginResponse handleLogin(LoginRequest loginRequest) throws LoginHandlerException {
        if(loginRequest == null){
            // This should not happen/
        }
        updateRequest(loginRequest);
        if(loginRequest.getFactorType().equalsIgnoreCase("secondary")){

            String scenario = loginRequest.getScenario();
            String username = loginRequest.getUsername();
            String ikey = loginRequest.getiKey();
            String akey = loginRequest.getaKey();
            String skey = loginRequest.getsKey();
            if(ikey == null || akey == null || skey == null){
                throw new LoginHandlerException("Either of DUO config params are null.");
            }
            if(scenario.equalsIgnoreCase("register"))
            {
                if(username == null){
                    throw new LoginHandlerException("DUO config username param is null.");
                }
                System.out.println("iKey : "+ ikey + " legnth : "+ ikey.length());
                System.out.println("akey : "+ akey + " legnth : "+ akey.length());
                System.out.println("skey : "+ skey + " legnth : "+ skey.length());
                System.out.println("username : "+ username);


                String sign = DuoWeb.signRequest(ikey,skey,akey,username);
                DuoResponse response = new DuoResponse();
                response.setUsername(username);
                response.setFactorType("secondary");
                response.setScenario("register");
                response.setSignature(sign);
                response.setHost(host);
                response.setLoginTime(System.currentTimeMillis());
                return response;
            }
            else{
                String signResponse = loginRequest.getSignRequest();
                System.out.println("Sign Response to be verified: "+ signResponse);
                // Verify the user
                try {
                    String duoResp = DuoWeb.verifyResponse(ikey,skey,akey,signResponse);
                    DuoResponse response = new DuoResponse();
                    response.setMfaResponse(duoResp);
                    response.setUsername(username);
                    response.setFactorType("secondary");
                    response.setScenario("verify");
                    response.setLoginTime(System.currentTimeMillis());
                    return response;
                } catch (Exception e) {
                    throw new LoginHandlerException("Unable to verify the signed response for user: "+ username);

                }

            }
        }
        return null;
    }
}
