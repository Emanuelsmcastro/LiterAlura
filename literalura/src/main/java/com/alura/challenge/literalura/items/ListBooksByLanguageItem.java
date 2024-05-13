package com.alura.challenge.literalura.items;

import java.util.Scanner;

import com.alura.challenge.literalura.services.BookServices;
import com.currency.converter.menu.Item;

public class ListBooksByLanguageItem extends Item {

    private BookServices services;
    Scanner scanner = new Scanner(System.in);

    public ListBooksByLanguageItem(){

    }

    public ListBooksByLanguageItem(int id, String name, BookServices services){
        super(id, name);
        this.services = services;
    }

    @Override
    public void run() {
        System.out.print("Digite um idioma: ");
        String input = this.scanner.nextLine();
        System.out.println("\n**************************");
        services.getAll()
        .stream()
        .filter(book -> book.getLanguages().contains(input))
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
