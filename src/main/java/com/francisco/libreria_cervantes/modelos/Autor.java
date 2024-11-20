package com.francisco.libreria_cervantes.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    private Integer aniodeNacimiento;
    private Integer getAniodeMuerte;
    @ManyToOne()
    private Libro libro;

    public Autor(){}

    public Autor(AutorAPI autorAPI) {
        this.nombre = autorAPI.nombre();
        this.aniodeNacimiento = autorAPI.aniodeNacimiento();
        this.getAniodeMuerte = autorAPI.getAniodeMuerte();
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return " \nNombre: " + nombre +
                "\nAño de nacimiento: " + aniodeNacimiento +
                "\nAño de Muerte: " + getAniodeMuerte +
                '\n';
    }
}
