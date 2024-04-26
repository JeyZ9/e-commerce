package com.app.paymentgitproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    @NotBlank
    private String categoryName;

    @NotBlank
    private String description;

    @NotBlank
    private String imageUrl;

    public Category() {}

    public Category(Long id, String categoryName, String description, String imageUrl) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Category{" +
                    "id=" + id + "," + "\n" +
                    "categoryName=" + categoryName + "," + "\n" +
                    "description=" + description + "," + "\n" +
                    "imageUrl=" + imageUrl + "\n" +
                    "}";
    }
}
