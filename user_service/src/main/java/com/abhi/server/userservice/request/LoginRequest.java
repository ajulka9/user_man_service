package com.abhi.server.userservice.request;


import sun.awt.UNIXToolkit;

import java.io.Serializable;

public class LoginRequest implements Serializable {


    private String password;
    private String username;
//    private FACTOR_TYPE factorType;
//    private SCENARIO scenario;
    private String factorType;
    private String scenario;
    private String signRequest;

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

    public String getSignRequest() {
        return signRequest;
    }

    public void setSignRequest(String signRequest) {
        this.signRequest = signRequest;
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


    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public FACTOR_TYPE getFactorType() {
//        return factorType;
//    }
//
//    public SCENARIO getScenario() {
//        return scenario;
//    }
//
//    public void setScenario(SCENARIO scenario) {
//        this.scenario = scenario;
//    }
//
//    public void setFactorType(FACTOR_TYPE factorType) {
//        this.factorType = factorType;
//    }


    public String getFactorType() {
        return factorType;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public void setFactorType(String factorType) {
        this.factorType = factorType;
    }

    public enum FACTOR_TYPE {

        PRIMARY("primary"),
        SECONDARY("secondary"),
        UNDEFINED("un-defined");

        private String value;

        public String getValue() {
            return value;
        }

        private FACTOR_TYPE(String val) {
            this.value = val;
        }

        @Override
        public String toString() {
            return value;
        }

        public FACTOR_TYPE getType(String val) {
            for (FACTOR_TYPE t : FACTOR_TYPE.values()) {
                if (t.getValue().equalsIgnoreCase(val)) {
                    return t;
                }
            }
            return UNDEFINED;
        }
    }

    public enum SCENARIO {

        REQUEST("request"),
        VERIFY("verify"),
        UNDEFINED("un-defined");

        private String value;

        public String getValue() {
            return value;
        }

        private SCENARIO(String val) {
            this.value = val;
        }

        @Override
        public String toString() {
            return value;
        }

        public SCENARIO getType(String val) {
            for (SCENARIO t : SCENARIO.values()) {
                if (t.getValue().equalsIgnoreCase(val)) {
                    return t;
                }
            }
            return UNDEFINED;
        }
    }
}
