package com.app.paymentgitproject.dto.users;

public class SignInResponseDTO {

    private String status;

    private String token;

    public SignInResponseDTO(String status, String token) {
        this.status = status;
        this.token = token;
    }

    public String getStatus(){
        return status;
    }

    public String getToken(){
        return token;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
