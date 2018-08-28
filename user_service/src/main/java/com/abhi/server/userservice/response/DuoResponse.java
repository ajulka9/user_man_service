package com.abhi.server.userservice.response;

public class DuoResponse extends LoginResponse {
    public String signature;
    public String host;
    public String scenario;
    public String mfaResponse;

    public String getSignature() {
        return signature;
    }

    public String getHost() {
        return host;
    }

    public String getMfaResponse() {
        return mfaResponse;
    }

    public String getScenario() {
        return scenario;
    }

    public void setMfaResponse(String mfaResponse) {
        this.mfaResponse = mfaResponse;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
