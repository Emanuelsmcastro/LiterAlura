package com.alura.challenge.literalura.mapper;

import java.util.HashSet;
import java.util.Set;

import com.alura.challenge.literalura.dtos.BookDTO;
import com.alura.challenge.literalura.models.Author;
import com.alura.challenge.literalura.models.Book;
import com.alura.challenge.literalura.services.AuthorServices;

public class BookMapper {

    public static Book toModel(BookDTO bookDTO, AuthorServices services) {
        Set<Author> authors = services.saveAll(new HashSet<>(bookDTO.authors()));
        return new Book(bookDTO.title(), authors, new HashSet<>(bookDTO.languages()), bookDTO.downloadCount());
    }
}