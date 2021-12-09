package com.project.ecommerce.controllers.form;

import com.project.ecommerce.models.Product;
import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotEmpty @Length(min=5)
    private String name;
    @NotNull
    private Double totalPrice;

    public Product converter() {
        return new Product(name, totalPrice);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }
}
