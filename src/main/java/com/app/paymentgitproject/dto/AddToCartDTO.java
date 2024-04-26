package com.app.paymentgitproject.dto;


import jakarta.validation.constraints.NotNull;

public class AddToCartDTO {

    private Long id;

    @NotNull
    private Long productId;

    @NotNull
    private Integer quantity;

    public AddToCartDTO(){}

    public AddToCartDTO(Long id, Long productId, Integer quantity){
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getId(){
        return id;
    }

    public Long getProductId(){
        return productId;
    }

    public Integer getQuantity(){
        return quantity;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setProductId(Long productId){
        this.productId = productId;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }
}
