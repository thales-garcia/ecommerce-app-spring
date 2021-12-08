package com.project.ecommerce.controllers;

import com.project.ecommerce.controllers.dto.ProductDto;
import com.project.ecommerce.controllers.form.ProductForm;
import com.project.ecommerce.controllers.form.ProductFormPut;
import com.project.ecommerce.models.Product;
import com.project.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @GetMapping
    public List<ProductDto> listAll(String nameProduct){
        if (nameProduct == null){
            List<Product> products = productRepository.findAll();
            return ProductDto.converter(products);
        } else {
            List<Product> products = productRepository.findByName(nameProduct);
            return ProductDto.converter(products);
        }
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable Long id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            return ResponseEntity.ok(new ProductDto(product.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProductDto> register(@RequestBody @Valid ProductForm form, UriComponentsBuilder uriBuilder){
        Product product = form.converter();
        productRepository.save(product);
        URI uri = uriBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProductDto(product));
    }

    @PutMapping(value="/{id}")
    @Transactional
    public ResponseEntity<ProductDto> update(@PathVariable Long id, @RequestBody ProductFormPut formPut){
        Optional<Product> product = productRepository.findById(id);
        formPut.converter(product);
        if (product.isPresent()){
            return ResponseEntity.ok(new ProductDto(product.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            productRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }
}

