package com.francisco.libreria_cervantes.modelos;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class Libro {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titulo;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> idioma;
    private Integer numeroDeDescargas;
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autor;

    public Libro(){}

    public Libro(LibroAPI libroApi) {
        this.titulo = libroApi.titulo();
        this.idioma=libroApi.idioma();
        this.numeroDeDescargas=libroApi.numeroDeDescargas();
        autor=libroApi.autor().stream()
                .map(l->new Autor(l))
                .collect(Collectors.toList());

    }

    public Integer getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setLibros(List<Autor> autores){
        autores.forEach(a -> a.setLibro(this));
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "***********************************" +
                "\nTitulo: '" + titulo +
                "\nIdioma: " + idioma +
                "\nNumero De Descargas:" + numeroDeDescargas +
                "\nAutor: " + autor +
                "\n***********************************\n";
    }
}
