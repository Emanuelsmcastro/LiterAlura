package com.alura.challenge.literalura.items;

import java.util.Scanner;

import com.alura.challenge.literalura.services.AuthorServices;
import com.currency.converter.menu.Item;

public class ListAuthorsAliveDuring extends Item{
    private AuthorServices services;
    Scanner scanner = new Scanner(System.in);

    public ListAuthorsAliveDuring(){

    }

    public ListAuthorsAliveDuring(int id, String name, AuthorServices services){
        super(id, name);
        this.services = services;
    }

    @Override
    public void run() {
        System.out.print("Digite um ano: ");
        Integer year = this.scanner.nextInt();
        this.scanner.nextLine();
        System.out.println("\n**************************");
        services.getAllAuthorsAliveDuring(year)
        .forEach(author -> {
            System.out.println("Name: " + author.getName());
            System.out.println("Birth Year: " + author.getBirthYear());
            System.out.println("Death Year: " + author.getDeathYear());
            System.out.println("---------------------------------");
        });
        System.out.println("\n**************************");
    }
}
