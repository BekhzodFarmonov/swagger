package com.example.springboot.controller;

import com.example.springboot.entity.Post;
import com.example.springboot.exseption.EntityNotFoundException;
import com.example.springboot.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
    private  final PostRepository postRepository;
    @GetMapping("/{id}")
    public ResponseEntity<Post> getComment(@PathVariable Integer id ){

        Post post = postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Comment Not Found" + id));
        return ResponseEntity.ok(post);
    }
    @GetMapping("/")
    public ResponseEntity<List<Post>> getAllComment(){
        List<Post> all = postRepository.findAll();
        return ResponseEntity.ok(all);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer id){
        Post post= postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Comment Not Found" + id));
        postRepository.delete(post);
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/save")
    public ResponseEntity<Post>  saveComment(@RequestBody Post post){
        return ResponseEntity.status(HttpStatus.CREATED).body(postRepository.save(post));
    }
}

