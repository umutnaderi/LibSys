package com.example.libsys.model;

import com.example.libsys.enums.StatusType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id") // Specify the foreign key column name
    private Author author;

    private String ISBN;

    private int year;

    @Enumerated(EnumType.STRING)
    private StatusType status;

}
