package com.app.paymentgitproject.dto.users;

public class SignUpResponseDTO {

    private String status;

    private String message;

    public SignUpResponseDTO(String status, String message){
        this.status = status;
        this.message = message;
    }

    public String getStatus(){
        return status;
    }

    public String getMessage(){
        return message;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
