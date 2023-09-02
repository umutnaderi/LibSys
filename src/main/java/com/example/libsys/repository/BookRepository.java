package com.example.libsys.repository;

import com.example.libsys.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findById(Long id);
    Book findByTitle(String title);
    Book findByISBN(String isbn);

    List<Book> findAll();
    Boolean existsById(Long id);
    Boolean existsByTitle(String title);

    List<Book> findByTitleContaining(String title);

    List<Book> findByAuthorNameContaining(String authorName);
}
