package com.app.paymentgitproject.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tokens")
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @Column(name = "created_date")
    private Date createdDate;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    public User user;

    public AuthenticationToken(){}

    public AuthenticationToken(User user){
        this.token = UUID.randomUUID().toString();
        this.createdDate = new Date();
        this.user = user;
    }

    public Long getId(){
        return id;
    }

    public String getToken(){
        return token;
    }

    public Date getCreatedDate(){
        return createdDate;
    }

    public User getUser(){
        return user;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setToken(String token){
        this.token = token;
    }

    public void setCreatedDate(Date createdDate){
        this.createdDate = createdDate;
    }

    public void setUser(User user){
        this.user = user;
    }

    @Override
    public String toString(){
        return "User{" + "id=" + id + ", createdDate=" + createdDate + ", user" + user + ", token=" + token + "}";
    }
}
