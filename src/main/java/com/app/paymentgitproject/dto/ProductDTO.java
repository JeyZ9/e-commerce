package com.app.paymentgitproject.dto;

import com.app.paymentgitproject.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String imageUrl;

    @NotNull
    private Double price;

    @NotBlank
    private String description;

    @NotNull
    private Long categoryId;

    public ProductDTO(){}

    public ProductDTO(String name, String imageUrl, Double price, String description, Long categoryId){
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
    }

    public ProductDTO(Product product){
        this.setId(product.getId());
        this.setName(product.getName());
        this.setDescription(product.getDescription());
        this.setPrice(product.getPrice());
        this.setImageUrl(product.getImageUrl());
        this.setCategoryId(product.getCategory().getId());
    }

    public String getName(){
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public Double getPrice(){
        return price;
    }

    public String getDescription(){
        return description;
    }

    public Long getCategoryId(){
        return categoryId;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
