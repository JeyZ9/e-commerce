package com.app.paymentgitproject.dto;

import java.util.List;

public class CartDTO {

    private List<CartItemDTO> cartItemDTOS;

    private double totalCost;

    public CartDTO(){}

    public CartDTO(List<CartItemDTO> cartItemDTOS, double totalCost){
        this.cartItemDTOS = cartItemDTOS;
        this.totalCost = totalCost;
    }

    public List<CartItemDTO> getCartItemDTOS(){
        return cartItemDTOS;
    }

    public double getTotalCost(){
        return totalCost;
    }

    public void setCartItemDTOS(List<CartItemDTO> cartItemDTOS) {
        this.cartItemDTOS = cartItemDTOS;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
