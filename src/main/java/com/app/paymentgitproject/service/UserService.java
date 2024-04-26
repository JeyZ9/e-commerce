package com.app.paymentgitproject.service;

import com.app.paymentgitproject.dto.users.SignInDTO;
import com.app.paymentgitproject.dto.users.SignUpDTO;
import com.app.paymentgitproject.dto.users.SignUpResponseDTO;
import com.app.paymentgitproject.exceptions.AuthenticationFailException;
import com.app.paymentgitproject.exceptions.CustomException;

public interface UserService {

    SignUpResponseDTO signUp(SignUpDTO signUpDTO) throws CustomException;

    SignUpResponseDTO signIn(SignInDTO signInDTO) throws AuthenticationFailException, CustomException;
}
