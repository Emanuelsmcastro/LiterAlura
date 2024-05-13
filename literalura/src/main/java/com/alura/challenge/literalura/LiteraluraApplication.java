package com.alura.challenge.literalura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alura.challenge.literalura.items.GetBookItem;
import com.alura.challenge.literalura.items.ListAuthorsAliveDuring;
import com.alura.challenge.literalura.items.ListAuthorsItem;
import com.alura.challenge.literalura.items.ListBooksByLanguageItem;
import com.alura.challenge.literalura.items.ListBooksItem;
import com.alura.challenge.literalura.services.AuthorServices;
import com.alura.challenge.literalura.services.BookServices;
import com.currency.converter.menu.Menu;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner{

	@Autowired
	private BookServices bookServices;

	@Autowired
	private AuthorServices authorServices;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu menu = new Menu();
		menu.addItem(new GetBookItem(1, "Buscar Livro Pelo Título", bookServices, authorServices))
		.addItem(new ListBooksItem(2, "Listar Livros Registrados", bookServices))
		.addItem(new ListAuthorsItem(3, "Listar Autores Registrados", authorServices))
		.addItem(new ListAuthorsAliveDuring(4, "Listar Authores Vivos em um determinado Ano", authorServices))
		.addItem(new ListBooksByLanguageItem(5, "Listar Livros Por Um Idioma", bookServices))
		.build();
		System.exit(0);
	}

}
