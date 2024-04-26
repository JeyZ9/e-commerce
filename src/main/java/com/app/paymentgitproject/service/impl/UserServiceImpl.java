package com.app.paymentgitproject.service.impl;

import com.app.paymentgitproject.config.MessageStrings;
import com.app.paymentgitproject.dto.users.SignInDTO;
import com.app.paymentgitproject.dto.users.SignUpDTO;
import com.app.paymentgitproject.dto.users.SignUpResponseDTO;
import com.app.paymentgitproject.exceptions.AuthenticationFailException;
import com.app.paymentgitproject.exceptions.CustomException;
import com.app.paymentgitproject.model.AuthenticationToken;
import com.app.paymentgitproject.model.User;
import com.app.paymentgitproject.repository.UserRepository;
import com.app.paymentgitproject.service.AuthenticationService;
import com.app.paymentgitproject.service.UserService;
import jakarta.xml.bind.DatatypeConverter;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final AuthenticationService authenticationService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AuthenticationService authenticationService) {
        this.userRepository = userRepository;
        this.authenticationService = authenticationService;
    }

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public SignUpResponseDTO signUp(SignUpDTO signUpDTO) throws CustomException{
        if(Objects.nonNull(userRepository.findByEmail(signUpDTO.getEmail()))){
            throw new CustomException("User already exists!");
        }

        String encryptedPassword = signUpDTO.getPassword();
        try{
            encryptedPassword = hashPassword(signUpDTO.getPassword());
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("hasing password failed {}", e.getMessage());
        }

        User user = new User(signUpDTO.getFirstName(), signUpDTO.getLastName(), signUpDTO.getEmail(), encryptedPassword);
        try{
            userRepository.save(user);

            final AuthenticationToken authenticationToken = new AuthenticationToken(user);

            authenticationService.saveConfirmationToken(authenticationToken);

            return new SignUpResponseDTO("success", "User created successfully");
        }catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public SignUpResponseDTO signIn(SignInDTO signInDTO) throws AuthenticationFailException, CustomException {

        User user = userRepository.findByEmail((signInDTO.getEmail()));

        if (!Objects.nonNull(user)) {
            throw new AuthenticationFailException("User not present");
        }
        try{
            if (!user.getPassword().equals(hashPassword(signInDTO.getPassword()))){
                throw new AuthenticationFailException(MessageStrings.WRONG_PASSWORD);
            }
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            logger.error("hashing password failes {}", e.getMessage());
            throw new CustomException(e.getMessage());
        }

        AuthenticationToken token = authenticationService.getToken(user);

        if(!Objects.nonNull(token)){
            throw new CustomException(MessageStrings.AUTH_TOKEN_NOT_PRESENT);
        }

        return new SignUpResponseDTO("success", token.getToken());
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException{
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(password.getBytes());
        byte[] digest = messageDigest.digest();
        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }

}
