package com.app.paymentgitproject.dto;

public class CheckoutItemDTO {

    private String productName;

    private Long quantity;

    private double price;

    private Long productId;

    public CheckoutItemDTO(){}

    public CheckoutItemDTO(String productName, Long quantity, double price, Long productId){
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.productId = productId;
    }

    public String getProductName(){
        return productName;
    }

    public Long getQuantity(){
        return quantity;
    }

    public double getPrice(){
        return price;
    }

    public Long getProductId(){
        return productId;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public void setQuantity(Long quantity){
        this.quantity = quantity;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setProductId(Long productId){
        this.productId = productId;
    }
}
