package com.app.paymentgitproject.service;

import com.app.paymentgitproject.exceptions.AuthenticationFailException;
import com.app.paymentgitproject.model.AuthenticationToken;
import com.app.paymentgitproject.model.User;

public interface AuthenticationService {
    void saveConfirmationToken(AuthenticationToken authenticationToken);

    AuthenticationToken getToken(User user);

    User getUser(String token);

    void authenticate(String token) throws AuthenticationFailException;
}
