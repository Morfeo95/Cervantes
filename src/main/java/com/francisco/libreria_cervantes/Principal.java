package com.francisco.libreria_cervantes;

import com.francisco.libreria_cervantes.herramientas.Buscador;
import com.francisco.libreria_cervantes.modelos.Libro;
import com.francisco.libreria_cervantes.repositorio.AutorersRepository;
import com.francisco.libreria_cervantes.repositorio.LibroRepository;

import java.io.IOException;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal{
    private boolean iniciador;
    private Scanner teclado=new Scanner(System.in);
    private Buscador buscador=new Buscador();
    private LibroRepository repository;
    private AutorersRepository repositoryAutor;

public Principal(LibroRepository repository, AutorersRepository repositoryAutor){
    this.repository = repository;
    this.repositoryAutor=repositoryAutor;
}

    public void creaMenu() throws IOException, InterruptedException {
        iniciador=true;
        while (iniciador){
            System.out.println(
                    """
                            ********************************
                            Bienvenido a la Libreria Cervantes.
                            Eliga una opción:
                            1).- Buscar Libro.
                            2).- Listar libros Buscados.
                            3).- Listar Autores Registrados.
                            4).- Listar Autores durante un periodo de tiempo.
                            5).- Listar libros por idioma.
                            6).- Estadisticas de libros descargados.
                            7).- Top 10 libros mas descargados.
                            8).- Buscar Autores por nombre.
                            9).- Filtrar Autor por año de muerte.
                            10).- Filtrar Autor por año de Nacimiento.
                            
                            0).- Salir.
                            ********************************
                            """);
                    switch (teclado.nextInt()){
                case 1:
                    teclado.nextLine();
                    System.out.println("Ingresa el nombre de el libro a buscar");
                    var libroBuscado = teclado.nextLine();
                    var listaDeLibrosBuscados = buscador.buscaLibroPorNombre(libroBuscado);
                    System.out.println(listaDeLibrosBuscados.stream().findFirst());
                    if (!listaDeLibrosBuscados.isEmpty()){
                        var libro = listaDeLibrosBuscados.get(0);
                        libro.setLibros(libro.getAutor());
                        if (!repository.existsByTitulo(libro.getTitulo())) {
                            repository.save(libro);
                            break;
                        }else {
                            System.out.println("Libro ya registrado en base de datos");
                        }
                        System.out.println("Preciona ENTER para continuar...");
                        teclado.nextLine();
                        break;
                    }else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                        case 2:
                            teclado.nextLine();
                            System.out.println(repository.findAll());
                            System.out.println("Preciona ENTER para continuar...");
                            teclado.nextLine();
                            break;
                        case 3:
                            teclado.nextLine();
                            System.out.println(repositoryAutor.findAll());
                            System.out.println("Preciona ENTER para continuar...");
                            teclado.nextLine();
                            break;
                        case 4:
                            teclado.nextLine();
                            System.out.println("Ingresa el año de busqueda.");
                            var anioDeBusqueda = teclado.nextInt();
                            teclado.nextLine();
                            System.out.println(repositoryAutor.encontrarAutorVivo(anioDeBusqueda));
                            System.out.println("Preciona ENTER para continuar...");
                            teclado.nextLine();
                            break;
                        case 5:
                            teclado.nextLine();
                            System.out.println("Ingresa el idioma deseado.");
                            var idioma = teclado.nextLine();
                            System.out.println(repository.buscarLibrosPorIdioma(idioma));
                            System.out.println("Preciona ENTER para continuar...");
                            teclado.nextLine();
                            break;
                        case 6:
                            teclado.nextLine();
                            List<Libro> estadisticas= repository.findAll();
                            IntSummaryStatistics intSummaryStatistics = estadisticas.stream()
                                    .collect(Collectors.summarizingInt(l->l.getNumeroDeDescargas()));
                            System.out.println("Total de libros en base de datos: "+intSummaryStatistics.getCount());
                            System.out.println("Media de las descargas: "+intSummaryStatistics.getAverage());
                            System.out.println("Total de descargas: "+intSummaryStatistics.getSum());
                            System.out.println("Preciona ENTER para continuar...");
                            teclado.nextLine();
                            break;
                        case 7:
                            teclado.nextLine();
                            repository.findTop10().stream()
                                    .forEach(l-> System.out.println(l.getTitulo()));
                            System.out.println("Preciona ENTER para continuar...");
                            teclado.nextLine();
                            break;
                        case 8:
                            teclado.nextLine();
                            System.out.println("ingresa el nombre del autor a buscar.");
                            var nombre = teclado.nextLine();
                            if (repositoryAutor.buscarAutorPorNombre(nombre) == null) {
                                System.out.println("Autor no registrado.");
                            }else {
                                System.out.println(repositoryAutor.buscarAutorPorNombre(nombre));
                            }
                            System.out.println("Preciona ENTER para continuar...");
                            teclado.nextLine();
                            break;
                        case 9:
                            teclado.nextLine();
                            System.out.println("ingresa el año de muerte");
                            var anio = teclado.nextInt();
                            teclado.nextLine();
                            System.out.println(repositoryAutor.buscarAutorPorMuerte(anio));
                            System.out.println("Preciona ENTER para continuar...");
                            teclado.nextLine();
                            break;
                        case 10:
                            teclado.nextLine();
                            System.out.println("ingresa el año de Nacimiento");
                            var aniomort = teclado.nextInt();
                            teclado.nextLine();
                            System.out.println(repositoryAutor.buscarAutorPorNacimiento(aniomort));
                            System.out.println("Preciona ENTER para continuar...");
                            teclado.nextLine();
                            break;
                        case 0:
                            teclado.nextLine();
                            iniciador=false;
                            break;
                default:
                    teclado.nextLine();
                    System.out.println("Opción invalida.");
                    System.out.println("Preciona ENTER para continuar...");
                    teclado.nextLine();
            }

        }
    }
}
