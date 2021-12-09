package com.project.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.ecommerce.models.enums.Color;
import com.project.ecommerce.models.enums.StatusProduct;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Product implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private LocalDateTime date = LocalDateTime.now();
    private Integer quantity;
    private Double totalPrice;
    private Double grade;
    @Enumerated(EnumType.STRING)
    private Color color;
    @Enumerated(EnumType.STRING)
    private StatusProduct status = StatusProduct.AVAILABLE;
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JsonIgnore
    private Category category;
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JsonIgnore
    private User user;
    @OneToMany(mappedBy="product")
    private List<Comments> comments = new ArrayList<>();

    public Product(String name, Double totalPrice) {
        this.name = name;
        this.totalPrice = totalPrice;
    }

    public Product(Long id, String name, Double price, LocalDateTime date, Integer quantity, Double totalPrice, Double grade, Color color, StatusProduct status, Category category, User user) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.grade = grade;
        this.color = color;
        this.status = status;
        this.category = category;
        this.user = user;
    }

    public Product() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public StatusProduct getStatus() {
        return status;
    }

    public void setStatus(StatusProduct status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comments> getComments() {
        return comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
