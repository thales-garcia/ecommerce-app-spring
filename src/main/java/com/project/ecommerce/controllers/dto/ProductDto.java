package com.project.ecommerce.controllers.dto;

import com.project.ecommerce.models.Product;
import com.project.ecommerce.models.enums.Color;
import com.project.ecommerce.models.enums.StatusProduct;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductDto implements Serializable {

    private Long id;
    private String name;
    private LocalDateTime date;
    private Double totalPrice;
    @Enumerated(EnumType.STRING)
    private Color color;
    @Enumerated(EnumType.STRING)
    private StatusProduct statusProduct;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.date = product.getDate();
        this.totalPrice = product.getTotalPrice();
        this.color = product.getColor();
        this.statusProduct = product.getStatus();
    }

    public static List<ProductDto> converter(List<Product> products) {
        return products.stream().map(ProductDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Color getColor() {
        return color;
    }

    public StatusProduct getStatusProduct() {
        return statusProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
