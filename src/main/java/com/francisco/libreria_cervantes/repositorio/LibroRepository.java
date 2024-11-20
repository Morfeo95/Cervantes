package com.francisco.libreria_cervantes.repositorio;

import com.francisco.libreria_cervantes.modelos.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    boolean existsByTitulo(String titulo);
    @Query("SELECT l FROM Libro l JOIN l.idioma i WHERE i ILIKE %:idiomaen%")
    List<Libro> buscarLibrosPorIdioma(String idiomaen);
    @Query("SELECT l FROM Libro l ORDER BY l.numeroDeDescargas DESC LIMIT 10")
    List<Libro> findTop10();
}
