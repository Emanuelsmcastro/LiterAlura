package com.alura.challenge.literalura.dtos;
import com.google.gson.annotations.SerializedName;

public record AuthorDTO(
    String name,
    @SerializedName("birth_year") Integer birthYear,
    @SerializedName("death_year") Integer deathYear) {
}
