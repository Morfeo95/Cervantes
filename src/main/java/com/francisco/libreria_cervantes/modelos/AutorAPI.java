package com.francisco.libreria_cervantes.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorAPI(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") Integer aniodeNacimiento,
        @JsonAlias("death_year") Integer getAniodeMuerte) {
}
