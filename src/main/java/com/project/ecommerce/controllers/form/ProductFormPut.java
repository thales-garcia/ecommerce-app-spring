package com.project.ecommerce.controllers.form;

import com.project.ecommerce.models.Product;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Optional;

public class ProductFormPut {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double totalPrice;

    public void converter(Optional<Product> product){
        product.get().setName(name);
        product.get().setTotalPrice(totalPrice);
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

    public Double gettotalPrice() {
        return totalPrice;
    }

    public void settotalPrice(Double price) {
        this.totalPrice = price;
    }
}
