package com.example.libsys.controller;

import com.example.libsys.dto.BookDto;
import com.example.libsys.mapper.BookMapper;
import com.example.libsys.model.Book;
import com.example.libsys.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    BookMapper bookMapper;

    @PostMapping("/books/add")
    public ResponseEntity<Book> addBook(@RequestBody @Valid BookDto bookDto) {

        Book book = bookMapper.mapDtoToEntity(bookDto);

        Book addedBook = bookService.addBook(book);
        return ResponseEntity.ok(addedBook);
    }

    @DeleteMapping("/books/remove/{bookId}")
    public ResponseEntity<String> removeBookById(@PathVariable Long bookId) {
        boolean removed = bookService.removeBookById(bookId);
        if (removed) {
            return ResponseEntity.ok("Book removed successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/books/searchByTitle")
    public ResponseEntity<List<Book>> searchByTitle(@RequestParam String title) {
        List<Book> books = bookService.searchByTitle(title);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/searchByAuthor")
    public ResponseEntity<List<Book>> searchByAuthor(@RequestParam String authorName) {
        List<Book> books = bookService.searchByAuthor(authorName);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @PostMapping("/books/buy/{bookId}")
    public ResponseEntity<String> buyBook(@PathVariable Long bookId) {
        boolean bought = bookService.buyBook(bookId);
        if (bought) {
            return ResponseEntity.ok("Book purchased successfully.");
        } else {
            return ResponseEntity.badRequest().body("Book not available for purchase.");
        }
    }

    @PostMapping("/books/rent/{bookId}")
    public ResponseEntity<String> rentBook(@PathVariable Long bookId) {
        boolean rented = bookService.rentBook(bookId);
        if (rented) {
            return ResponseEntity.ok("Book rented successfully.");
        } else {
            return ResponseEntity.badRequest().body("Book not available for rent.");
        }
    }

    @PostMapping("/books/return/{bookId}")
    public ResponseEntity<String> returnBook(@PathVariable Long bookId) {
        boolean returned = bookService.returnBook(bookId);
        if (returned) {
            return ResponseEntity.ok("Book returned successfully.");
        } else {
            return ResponseEntity.badRequest().body("Book return failed.");
        }
    }

}
