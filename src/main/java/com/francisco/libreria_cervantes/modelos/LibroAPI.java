package com.francisco.libreria_cervantes.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroAPI(
        @JsonAlias("title") String titulo,
        @JsonAlias("languages") List<String> idioma,
        @JsonAlias("download_count") Integer numeroDeDescargas,
        @JsonAlias("authors") List<AutorAPI> autor
) {
}
