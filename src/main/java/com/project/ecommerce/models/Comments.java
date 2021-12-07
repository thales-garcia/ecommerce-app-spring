package com.project.ecommerce.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Comments implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Title;
    private String text;
    private Integer grade;
    @ManyToOne
    private Product product;

    public Comments(Long id, String title, String text, Integer grade) {
        this.id = id;
        Title = title;
        this.text = text;
        this.grade = grade;
    }

    public Comments() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
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
