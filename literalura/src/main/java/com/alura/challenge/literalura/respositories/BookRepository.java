package com.alura.challenge.literalura.respositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.challenge.literalura.models.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
    public Optional<Book> findByTitle(String title);
}
