package com.app.paymentgitproject.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date")
    private Date createdDate;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Cart(Product product, Integer quantity, User user){}

    public Cart(Long id, Date createdDate, Integer quantity, Product product, User user) {
        this.id = id;
        this.createdDate = new Date();
        this.quantity = quantity;
        this.product = product;
        this.user = user;
    }

    public Long getId(){
        return id;
    }

    public Date getCreatedDate(){
        return createdDate;
    }

    public Integer getQuantity(){
        return quantity;
    }

    public Product getProduct(){
        return product;
    }

    public User getUser(){
        return user;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setCreatedDate(Date createdDate){
        this.createdDate = createdDate;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Product product){
        this.product = product;
    }

    public void setUser(User user){
        this.user = user;
    }

    @Override
    public String toString(){
        return "User{" + "id=" + id + ", createdDate=" + createdDate + ", product=" + product + ", user=" + user + "}";
    }
}
