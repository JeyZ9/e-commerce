package com.app.paymentgitproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "orderItems")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int quantity;

    @NotNull
    private double price;

    @Column(name = "created_date")
    public Date createdDate;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public OrderItem(){}

    public OrderItem(Long id, int quantity, double price, Order order, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.createdDate = new Date();
        this.order = order;
        this.product = product;
    }

    public Long getId(){
        return id;
    }

    public int getQuantity(){
        return quantity;
    }

    public double getPrice(){
        return price;
    }

    public Date getCreatedDate(){
        return createdDate;
    }

    public Order getOrder(){
        return order;
    }

    public Product getProduct(){
        return product;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setCreatedDate(Date createdDate){
        this.createdDate = createdDate;
    }

    public void setOrder(Order order){
        this.order = order;
    }

    public void setProduct(Product product){
        this.product = product;
    }

    @Override
    public String toString(){
        return "OrderItem{" + "id=" + id + ", createdDate=" + createdDate + ", order=" + order + ", product=" + product + "}";
    }
}
