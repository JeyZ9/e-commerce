package com.app.paymentgitproject.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "wishlists")
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    public WishList(){}

    public WishList(User user, Product product){
        this.user = user;
        this.product = product;
        this.createdDate = new Date();
    }

    public Long getId(){
        return id;
    }

    public User getUser(){
        return user;
    }

    public Date getCreatedDate(){
        return createdDate;
    }

    public Product getProduct(){
        return product;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setCreatedDate(Date createdDate){
        this.createdDate = createdDate;
    }

    public void setProduct(Product product){
        this.product = product;
    }

    @Override
    public String toString(){
        return "Product{" + "id=" + id + ", user=" + user + ", createdDate=" + createdDate + ", product=" + product + "}";
    }
}
