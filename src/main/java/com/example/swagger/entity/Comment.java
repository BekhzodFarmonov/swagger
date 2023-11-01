package com.example.swagger.entity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private  Integer postId;
    private   String name;
    private  String email;
    @Column(length = 10000)
    private String body;
}
