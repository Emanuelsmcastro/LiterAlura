package com.alura.challenge.literalura.dtos;

import java.util.List;

public record ResponseDTO(
        int count,
        String next,
        String previous,
        List<BookDTO> results) {

}
