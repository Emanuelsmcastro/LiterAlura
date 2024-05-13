package com.alura.challenge.literalura.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alura.challenge.literalura.dtos.AuthorDTO;
import com.alura.challenge.literalura.mapper.AuthorMapper;
import com.alura.challenge.literalura.models.Author;
import com.alura.challenge.literalura.respositories.AuthorRepository;

@Service
public class AuthorServices {
    
    @Autowired
    private AuthorRepository repository;

    public Set<Author> saveAll(Set<AuthorDTO> authorDTOSet){
        Set<Author> authors = authorDTOSet
        .stream()
        .map(authorDTO -> this.save(AuthorMapper.toModel(authorDTO)))
        .collect(Collectors.toSet());
        return authors;
    }

    public Author save(Author author){
        if(!this.get(author.getName()).isEmpty()) return this.get(author.getName()).get();
        return repository.save(author);
    }

    public Optional<Author> get(String name){
        return repository.findByName(name);
    }

    public List<Author> getAll(){
        return repository.findAll();
    }

    public List<Author> getAllAuthorsAliveDuring(Integer year){
        return repository.findAuthorsAliveDuring(year);
    }
}
