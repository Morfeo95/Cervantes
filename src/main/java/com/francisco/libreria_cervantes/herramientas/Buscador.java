package com.francisco.libreria_cervantes.herramientas;

import com.francisco.libreria_cervantes.modelos.DatosAPI;
import com.francisco.libreria_cervantes.modelos.Libro;
import com.francisco.libreria_cervantes.modelos.LibroAPI;
import com.francisco.libreria_cervantes.service.ConvierteDatos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Buscador {
    private RecibeLibro recibeLibro = new RecibeLibro();
    private ConvierteDatos convierte= new ConvierteDatos();

    public List<Libro> buscaLibroPorNombre(String libro) throws IOException, InterruptedException {
        //lista de datos genericos
        DatosAPI datos = convierte.obtenerDatos(recibeLibro.reciveLibro(libro), DatosAPI.class);
        //Lista de LibrosApi
        List<LibroAPI> librosAPI= new ArrayList<>();
        librosAPI=datos.libroAPIS().stream()
                .map(l -> new LibroAPI(l.titulo(), l.idioma(),l.numeroDeDescargas(),l.autor()))
                .collect(Collectors.toList());
        //Lista de Libros
        List<Libro> libros= new ArrayList<>();
        libros=librosAPI.stream()
                .map(l -> new Libro(l))
                .collect(Collectors.toList());
        return libros;

    }
}
