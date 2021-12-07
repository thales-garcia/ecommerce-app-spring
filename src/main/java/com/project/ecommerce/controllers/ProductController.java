package com.project.ecommerce.controllers;

import com.project.ecommerce.models.Product;
import com.project.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value="/products")
    public @ResponseBody List<Product> listAll(){
        List<Product> products = productRepository.findAll();
        return products;

    }

}
