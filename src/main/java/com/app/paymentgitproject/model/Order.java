package com.app.paymentgitproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date")
    private Date createdDate;

    private Double totalPrice;

    private String sessionId;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Order(){}

//    public Order(Long id, Double totalPrice, String sessionId, List<OrderItem> orderItems){
//        this.id = id;
//        this.createdDate = new Date();
//        this.totalPrice = totalPrice;
//        this.sessionId = sessionId;
//        this.orderItems = orderItems;
//    }

    public Long getId(){
        return id;
    }

    public Date getCreatedDate(){
        return createdDate;
    }

    public Double getTotalPrice(){
        return totalPrice;
    }

    public String getSessionId(){
        return sessionId;
    }

    public List<OrderItem> getOrderItems(){
        return orderItems;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setCreatedDate(Date createdDate){
        this.createdDate = createdDate;
    }

    public void setTotalPrice(Double totalPrice){
        this.totalPrice = totalPrice;
    }

    public void setSessionId(String sessionId){
        this.sessionId = sessionId;
    }

    public void setOrderItems(List<OrderItem> orderItems){
        this.orderItems = orderItems;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString(){
        return "Order{" + "id=" + id + ", createdDate=" + createdDate + ", totalPrice=" + totalPrice + ", sessionId=" + sessionId + ", orderItems=" + orderItems +  "}";
    }
}
