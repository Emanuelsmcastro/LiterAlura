package com.alura.challenge.literalura.integration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.alura.challenge.literalura.dtos.BookDTO;
import com.alura.challenge.literalura.dtos.ResponseDTO;
import com.google.gson.Gson;

public class BookAPI {
    static final private String baseURL = "https://gutendex.com/books";

    public static BookDTO get(String bookName) throws MalformedURLException, IOException, InterruptedException{
        String encodedBookName = URLEncoder.encode(bookName, StandardCharsets.UTF_8.toString());
        String fullURL = baseURL + "/?search=" +  encodedBookName;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fullURL))
                .build();

        HttpResponse<String> response;

        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response);
        Gson gson = new Gson();
        ResponseDTO dto = gson.fromJson(response.body(), ResponseDTO.class);
        return dto.results().get(0);
    }

}
