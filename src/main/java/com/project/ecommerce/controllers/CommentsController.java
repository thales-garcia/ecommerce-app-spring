package com.project.ecommerce.controllers;

import com.project.ecommerce.controllers.form.CommentsForm;
import com.project.ecommerce.controllers.form.CommentsFormPut;
import com.project.ecommerce.models.Comments;
import com.project.ecommerce.repositories.CommentsRepository;
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
@RequestMapping(value="/comments")
public class CommentsController {

    @Autowired
    public CommentsRepository commentsRepositories;

    @GetMapping
    public List<Comments> list(String titleName){
        if (titleName == null){
            List<Comments> comments = commentsRepositories.findAll();
            return comments;
        } else {
            List<Comments> comments = commentsRepositories.findByTitle(titleName);
            return comments;
        }
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Comments> findById(@PathVariable Long id){
        Optional<Comments> comments = commentsRepositories.findById(id);
        if (comments.isPresent()){
            return ResponseEntity.ok(comments.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Comments> register(@RequestBody @Valid CommentsForm form, UriComponentsBuilder uriBuilder){
        Comments comments = form.converter();
        commentsRepositories.save(comments);
        URI uri = uriBuilder.path("/comments/{id}").buildAndExpand(comments.getId()).toUri();
        return ResponseEntity.created(uri).body(comments);
    }

    @PutMapping(value="/{id}")
    @Transactional
    public ResponseEntity<Comments> update(@PathVariable Long id, @RequestBody @Valid CommentsFormPut commentsFormPut){
        Optional<Comments> com = commentsRepositories.findById(id);
        if (com.isPresent()){
            commentsFormPut.converter(com);
            return ResponseEntity.ok(com.get());
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Comments> comments = commentsRepositories.findById(id);
        if (comments.isPresent()){
            commentsRepositories.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }






}
