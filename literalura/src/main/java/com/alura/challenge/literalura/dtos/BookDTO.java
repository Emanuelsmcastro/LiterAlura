package com.alura.challenge.literalura.dtos;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public record BookDTO(int id,
    String title,
    List<AuthorDTO> authors,
    List<String> subjects,
    List<String> languages,
    boolean copyright,
    String mediaType,
    Map<String, String> formats,
    @SerializedName("download_count")Integer downloadCount) {
    
}
