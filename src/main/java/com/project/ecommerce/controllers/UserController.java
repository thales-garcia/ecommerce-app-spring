package com.project.ecommerce.controllers;

import com.project.ecommerce.controllers.dto.UserDto;
import com.project.ecommerce.models.User;
import com.project.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    

}
