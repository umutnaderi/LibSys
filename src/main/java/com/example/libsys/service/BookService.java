package com.example.libsys.service;

import com.example.libsys.model.Book;

import java.util.List;

public interface BookService {

    List<Book> searchByTitle(String title);

    List<Book> searchByAuthor(String authorName);

    List<Book> getAllBooks();

    boolean buyBook(Long bookId);

    boolean rentBook(Long bookId);

    boolean returnBook(Long bookId);

    Book addBook(Book book);

    boolean removeBookById(Long bookId);
    boolean removeBookByISBN(String isbn);
}