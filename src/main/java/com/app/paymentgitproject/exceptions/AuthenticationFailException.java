package com.app.paymentgitproject.exceptions;

public class AuthenticationFailException extends Exception{
    public AuthenticationFailException(String msg){
        super(msg);
    }
}
