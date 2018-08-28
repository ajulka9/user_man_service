package com.abhi.server.userservice.request;

public class DuoLoginRequest {

    private String aKey;
    private String sKey;
    private String iKey;
    private String host;

    public String getaKey() {
        return aKey;
    }

    public String getiKey() {
        return iKey;
    }

    public String getHost() {
        return host;
    }

    public String getsKey() {
        return sKey;
    }

    public void setaKey(String aKey) {
        this.aKey = aKey;
    }

    public void setiKey(String iKey) {
        this.iKey = iKey;
    }

    public void setsKey(String sKey) {
        this.sKey = sKey;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public static interface BaseRequest {
    }
}
