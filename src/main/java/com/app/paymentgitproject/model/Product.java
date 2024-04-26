package com.app.paymentgitproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String imageUrl;

    @NotNull
    private Double price;

    @NotNull
    private String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    Category category;

    public Product(){}

    public Product(Long id, String name, String imageUrl, Double price, String description, Category category){
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
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

    public Category getCategory(){
        return category;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    @Override
    public String toString(){
        return "Product{" + "id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + ", description=" + description + ", category=" + category +"}";
    }
}
