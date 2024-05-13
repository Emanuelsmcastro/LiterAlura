package com.alura.challenge.literalura.mapper;

import com.alura.challenge.literalura.dtos.AuthorDTO;
import com.alura.challenge.literalura.models.Author;

public class AuthorMapper {
    
    public static Author toModel(AuthorDTO authorDTO){
        return new Author(
            authorDTO.name(),
            authorDTO.birthYear(),
            authorDTO.deathYear()
        );
    }
}
