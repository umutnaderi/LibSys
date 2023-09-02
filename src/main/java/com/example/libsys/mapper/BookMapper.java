package com.example.libsys.mapper;

import com.example.libsys.dto.BookDto;
import org.springframework.stereotype.Component;
import com.example.libsys.model.Book;

@Component
public class BookMapper {

    public Book mapDtoToEntity(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setISBN(bookDto.getIsbn());
        book.setAuthor(bookDto.getAuthor());
        book.setYear(bookDto.getYear());
        // Map other fields as needed
        return book;
    }

}
