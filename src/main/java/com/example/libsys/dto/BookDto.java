package com.example.libsys.dto;

import com.example.libsys.model.Author;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {

    @NotBlank
    private String title;

    @NotNull
    private String isbn;

    private int year;

    private Author author;

}
