package com.example.libsys.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String ISBN;
    private int year;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;
}
