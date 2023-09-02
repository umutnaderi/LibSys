package com.example.libsys.service;

import com.example.libsys.enums.StatusType;
import com.example.libsys.model.Author;
import com.example.libsys.model.Book;
import com.example.libsys.repository.AuthorRepository;
import com.example.libsys.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Book> searchByTitle(String title) {
        // Implement search logic by title using bookRepository
        return bookRepository.findByTitleContaining(title);
    }

    @Override
    public List<Book> searchByAuthor(String authorName) {
        // Implement search logic by author using bookRepository
        List<Author> authors = authorRepository.findByNameContaining(authorName);
        List<Book> books = new ArrayList<>();
        for (Author author : authors) {
            books.addAll(author.getBooks());
        }
        return books;
    }

    @Override
    public List<Book> getAllBooks() {
        // Implement logic to fetch all books using bookRepository
        return bookRepository.findAll();
    }

    @Override
    public boolean buyBook(Long bookId) {
//        // Implement logic to decrement book count and handle purchase
//        Book book = bookRepository.findById(bookId);
//        if (book != NULL) {
//            if (book.getAvailableCount() > 0) {
//                book.setAvailableCount(book.getAvailableCount() - 1);
//                bookRepository.save(book);
//                // Handle the purchase (e.g., record the transaction)
//                return true;
//            }
//        }
        return false;
    }

    @Override
    public boolean rentBook(Long bookId) {
//        // Implement logic to handle book rental
//        // Similar to buyBook but with different business rules
//        // (e.g., set a return date, charge a rental fee)
//        // You may need to create a Rental entity to track rentals.
//        // Return true if the rental is successful; otherwise, return false.
        return false;
    }

    @Override
    public boolean returnBook(Long bookId) {
        return false;
    }

    @Override
    public Book addBook(Book book) {
        book.setStatus(StatusType.AVAILABLE);
        bookRepository.save(book);
        return book;
    }

    @Override
    public boolean removeBookById(Long bookId) {
        bookRepository.delete(bookRepository.findById(bookId));
        return true;
    }

    @Override
    public boolean removeBookByISBN(String isbn) {
        return false;
    }
}