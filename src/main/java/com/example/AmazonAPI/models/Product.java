package com.example.AmazonAPI.models;

import org.springframework.data.annotation.Id;

public class Product {

    @Id
    private String id;
    private String title;
    private String image;
    private String description;
    private double price;
    private int rating;
    private String category;
    private Boolean bestseller;

    public Product() {
    }

    public Product(String id, String title, String image, String description, double price, int rating, String category, Boolean bestseller) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.category = category;
        this.bestseller = bestseller;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getBestseller() {
        return bestseller;
    }

    public void setBestseller(Boolean bestseller) {
        this.bestseller = bestseller;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", category='" + category + '\'' +
                ", bestseller=" + bestseller +
                '}';
    }
}
