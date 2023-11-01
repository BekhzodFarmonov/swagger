package com.example.swagger.controller;


import com.example.swagger.entity.Comment;
import com.example.swagger.exseption.EntityNotFoundException;
import com.example.swagger.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {
    private  final CommentRepository commentRepository;
    @GetMapping("/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Integer id ){

        Comment comment = commentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Comment Not Found" + id));
        return ResponseEntity.ok(comment);
    }
   @GetMapping("/")
    public ResponseEntity<List<Comment>> getAllComment(){
       List<Comment> all = commentRepository.findAll();
       return ResponseEntity.ok(all);

   }
   @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer id){
       Comment comment = commentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Comment Not Found" + id));
       commentRepository.delete(comment);
       return ResponseEntity.notFound().build();
   }
  @PostMapping("/save")
    public ResponseEntity<Comment>  saveComment(@RequestBody Comment comment){
      return ResponseEntity.status(HttpStatus.CREATED).body(commentRepository.save(comment));
  }
}
