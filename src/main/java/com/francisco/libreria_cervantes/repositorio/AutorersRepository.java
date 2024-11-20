package com.francisco.libreria_cervantes.repositorio;

import com.francisco.libreria_cervantes.modelos.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorersRepository extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Autor a WHERE a.aniodeNacimiento < :anioDeBusqueda AND a.getAniodeMuerte > :anioDeBusqueda")
    List<Autor> encontrarAutorVivo(int anioDeBusqueda);
    @Query("SELECT a FROM Autor a WHERE a.nombre ILIKE %:nombre%")
    Autor buscarAutorPorNombre(String nombre);
    @Query("SELECT a FROM Autor a WHERE a.getAniodeMuerte = :anio")
    List<Autor> buscarAutorPorMuerte(int anio);
    @Query("SELECT a FROM Autor a WHERE a.aniodeNacimiento = :aniomort")
    List<Autor> buscarAutorPorNacimiento(int aniomort);
}
