package com.project.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Comments implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;
    private Double grade;
    @ManyToOne
    @JsonIgnore
    private Product product;

    public Comments(Long id, String title, String text, Double grade, Product product) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.grade = grade;
        this.product = product;
    }

    public Comments() {
    }

    public Comments(String title, String text) {
    }

    public Comments(String title, String text, Double grade) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return Objects.equals(getId(), comments.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
