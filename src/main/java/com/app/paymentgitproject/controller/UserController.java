package com.app.paymentgitproject.controller;

import com.app.paymentgitproject.dto.users.SignInDTO;
import com.app.paymentgitproject.dto.users.SignUpDTO;
import com.app.paymentgitproject.dto.users.SignUpResponseDTO;
import com.app.paymentgitproject.exceptions.AuthenticationFailException;
import com.app.paymentgitproject.exceptions.CustomException;
import com.app.paymentgitproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/signUp")
    public SignUpResponseDTO signUp(@RequestBody SignUpDTO signUpDTO) throws CustomException {
        return userService.signUp(signUpDTO);
    }

    @PostMapping("/signIn")
    public SignUpResponseDTO SignUp(@RequestBody SignInDTO signInDTO) throws CustomException, AuthenticationFailException {
        return userService.signIn(signInDTO);
    }
}
