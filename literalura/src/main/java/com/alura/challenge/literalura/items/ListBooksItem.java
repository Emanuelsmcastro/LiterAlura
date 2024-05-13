package com.alura.challenge.literalura.items;

import com.alura.challenge.literalura.services.BookServices;
import com.currency.converter.menu.Item;

public class ListBooksItem extends Item {

    private BookServices services;

    public ListBooksItem(){

    }

    public ListBooksItem(int id, String name, BookServices services){
        super(id, name);
        this.services = services;
    }

    @Override
    public void run() {
        System.out.println("\n**************************");
        services.getAll()
        .forEach(book -> {
            System.out.println("Title: " + book.getTitle());
            System.out.print("Authors: ");
            book.getAuthors().forEach(author -> System.out.print(author.getName()));
            System.out.println();
            System.out.println("Languages: " + book.getLanguages());
            System.out.println("Download Count: " + book.getDownloadCount());
            System.out.println("---------------------------------");
        });
        System.out.println("\n**************************");
    }
    
}
