package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "img_path",columnDefinition = "TEXT")
    private String imgPath;

    public Product() {
    }

    public Product(Long id, String name, Double price, String description, String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imgPath = img;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImg() {
        return imgPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setImg(String img) {
        this.imgPath = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
