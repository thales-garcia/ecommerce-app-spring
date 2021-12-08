package com.project.ecommerce.controllers.dto;

import com.project.ecommerce.models.Product;
import com.project.ecommerce.models.User;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
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
