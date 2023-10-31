package com.learning.BookmyShowProject.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@Builder // Builder object requires AllArgsConstructor annotation
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String name;

    @Column(unique = true)
    private String email;

    private String mobNo;

    private Integer age;

}
