package com.project.ecommerce.controllers.dto;

import com.project.ecommerce.models.Product;
import com.project.ecommerce.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDto {

    private Long id;
    private String name;
    private List<Product> products = new ArrayList<>();

    public UserDto(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.products = user.getProducts();
    }

    public static List<UserDto> converter(List<User> users) {
        return users.stream().map(UserDto::new).collect(Collectors.toList());
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

    public List<Product> getProducts() {
        return products;
    }
}
