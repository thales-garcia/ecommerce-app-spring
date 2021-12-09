package com.project.ecommerce.controllers.form;

import com.project.ecommerce.models.Product;
import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ProductFormPut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotEmpty @Length(min=5)
    private String name;
    @NotNull
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

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double price) {
        this.totalPrice = price;
    }
}
