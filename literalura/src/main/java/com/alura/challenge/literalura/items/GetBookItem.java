package com.alura.challenge.literalura.items;

import java.io.IOException;
import java.util.Scanner;

import com.alura.challenge.literalura.dtos.BookDTO;
import com.alura.challenge.literalura.integration.BookAPI;
import com.alura.challenge.literalura.mapper.BookMapper;
import com.alura.challenge.literalura.models.Book;
import com.alura.challenge.literalura.services.AuthorServices;
import com.alura.challenge.literalura.services.BookServices;
import com.currency.converter.menu.Item;

public class GetBookItem extends Item {

    private BookServices bookServices;
    private AuthorServices authorServices;

    Scanner scanner = new Scanner(System.in);

    public GetBookItem() {

    }

    public GetBookItem(int id, String name, BookServices bookServices, AuthorServices authorServices) {
        super(id, name);
        this.bookServices = bookServices;
        this.authorServices = authorServices;
    }

    @Override
    public void run() {
        System.out.print("Digite: ");
        String input = this.scanner.nextLine();
        try {
            BookDTO book = BookAPI.get(input);
            Book bookModel = BookMapper.toModel(book, authorServices);
            System.out.println(bookServices.save(bookModel));
        } catch (IOException | InterruptedException | IndexOutOfBoundsException e ) {
            System.out.println("Ocorreu um error: " + e.getMessage());
        }
    }

}
