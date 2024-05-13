package com.alura.challenge.literalura.items;

import com.alura.challenge.literalura.services.AuthorServices;
import com.currency.converter.menu.Item;

public class ListAuthorsItem extends Item {

    private AuthorServices services;

    public ListAuthorsItem(){

    }

    public ListAuthorsItem(int id, String name, AuthorServices services){
        super(id, name);
        this.services = services;
    }

    @Override
    public void run() {
        System.out.println("\n**************************");
        services.getAll()
        .forEach(author -> {
            System.out.println("Name: " + author.getName());
            System.out.println("Birth Year: " + author.getBirthYear());
            System.out.println("Death Year: " + author.getDeathYear());
            System.out.println("---------------------------------");
        });
        System.out.println("\n**************************");
    }
    
}
