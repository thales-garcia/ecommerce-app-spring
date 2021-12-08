package com.project.ecommerce.controllers;

import com.project.ecommerce.controllers.dto.UserDto;
import com.project.ecommerce.controllers.form.UserForm;
import com.project.ecommerce.controllers.form.UserFormPut;
import com.project.ecommerce.models.User;
import com.project.ecommerce.repositories.UserRepository;
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
@RequestMapping(value="/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<UserDto> list(String userName){
        if (userName == null){
            List<User> users = userRepository.findAll();
            return UserDto.converter(users);
        } else {
            List<User> users = userRepository.findByName(userName);
            return UserDto.converter(users);
        }
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return ResponseEntity.ok(new UserDto(user.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<UserDto> register(@RequestBody UserForm form, UriComponentsBuilder uriBuilder){
        User user = form.converter();
        userRepository.save(user);
        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDto(user));

    }

    @PutMapping(value="{id}")
    @Transactional
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody @Valid UserFormPut formPut){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            formPut.converter(user);
            return ResponseEntity.ok(new UserDto(user.get()));
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping(value="/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
