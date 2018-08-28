package com.abhi.server.userservice.response;

import com.google.gson.Gson;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

public abstract class AbstractResponse {

    public static final String HEADER_PARAM_CACHE_CONTROL_NO_STORE = "no-store";
    public static final String HEADER_PARAM_PRGMA = "Pragma";
    public static final String HEADER_PARAM_PRGMA_NO_CACHE = "no-cache";
    public static final String HEADER_PARAM_REFERER = "referer";

    public Response getResponse(int status) {
            Response.ResponseBuilder responseBuilder = Response.status(status);
            // Set headers
            responseBuilder.header(HttpHeaders.CACHE_CONTROL, HEADER_PARAM_CACHE_CONTROL_NO_STORE);
            responseBuilder.header(HEADER_PARAM_PRGMA, HEADER_PARAM_PRGMA_NO_CACHE);

            // Set the response entity
            responseBuilder.entity(this.toJSONString());
            return responseBuilder.build();
        }

        public Response getResponse() {
            return getResponse(200);
        }


    public String toJSONString(){
        String json = new Gson().toJson(this);
        System.out.println("toJSON : "+ json);
        return json;
    }
}
