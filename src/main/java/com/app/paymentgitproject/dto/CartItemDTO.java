package com.app.paymentgitproject.dto;

import com.app.paymentgitproject.model.Cart;
import com.app.paymentgitproject.model.Product;
import jakarta.validation.constraints.NotNull;

public class CartItemDTO {

    private Long id;

    @NotNull
    private Integer quantity;

    @NotNull
    private Product product;

    public CartItemDTO(){}

    public CartItemDTO(Cart cart){
        this.setId(cart.getId());
        this.setQuantity(cart.getQuantity());
        this.setProduct(cart.getProduct());
    }

    public Long getId(){
        return id;
    }

    public Integer getQuantity(){
        return quantity;
    }

    public Product getProduct(){
        return product;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }

    public void setProduct(Product product){
        this.product = product;
    }
}
