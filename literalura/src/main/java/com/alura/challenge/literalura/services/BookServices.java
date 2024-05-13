package com.alura.challenge.literalura.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alura.challenge.literalura.models.Book;
import com.alura.challenge.literalura.respositories.BookRepository;

@Service
public class BookServices {
    
    @Autowired
    private BookRepository repository;

    public Book save(Book book){
        if(!this.get(book.getTitle()).isEmpty()) return this.get(book.getTitle()).get();
        return repository.save(book);
    }

    public Optional<Book> get(String title){
        return repository.findByTitle(title);
    }

    public List<Book> getAll(){
        return repository.findAll();
    }
}
