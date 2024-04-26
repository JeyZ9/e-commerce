package com.app.paymentgitproject.dto;

public class StripeResponse {

    private String sessionId;

    public StripeResponse(){}

    public StripeResponse(String sessionId){
        this.sessionId = sessionId;
    }

    public String getSession(){
        return sessionId;
    }

    public void setSession(String session){
        this.sessionId = session;
    }
}
