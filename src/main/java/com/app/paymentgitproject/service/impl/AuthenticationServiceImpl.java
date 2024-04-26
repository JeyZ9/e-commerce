package com.app.paymentgitproject.service.impl;

import com.app.paymentgitproject.config.MessageStrings;
import com.app.paymentgitproject.exceptions.AuthenticationFailException;
import com.app.paymentgitproject.model.AuthenticationToken;
import com.app.paymentgitproject.model.User;
import com.app.paymentgitproject.repository.TokenRepository;
import com.app.paymentgitproject.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final TokenRepository repository;

    @Autowired
    public AuthenticationServiceImpl(TokenRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveConfirmationToken(AuthenticationToken authenticationToken) {
        repository.save(authenticationToken);
    }

    @Override
    public AuthenticationToken getToken(User user){
        return repository.findTokenByUser(user);
    }

    @Override
    public User getUser(String token){
        AuthenticationToken authenticationToken = repository.findTokenByToken(token);

        if(Objects.nonNull(authenticationToken)){
            if(Objects.nonNull(authenticationToken.getUser())){
                return authenticationToken.getUser();
            }
        }
        return null;
    }

    @Override
    public void authenticate(String token) throws AuthenticationFailException{
        if(!Objects.nonNull(token)){
            throw new AuthenticationFailException(MessageStrings.AUTH_TOKEN_NOT_PRESENT);
        }
        if(!Objects.nonNull(getUser(token))){
            throw new AuthenticationFailException(MessageStrings.AUTH_TOKEN_VALID);
        }
    }
}
