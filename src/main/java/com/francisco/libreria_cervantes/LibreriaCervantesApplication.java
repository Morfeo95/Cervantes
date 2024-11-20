package com.francisco.libreria_cervantes;

import com.francisco.libreria_cervantes.repositorio.AutorersRepository;
import com.francisco.libreria_cervantes.repositorio.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;

@SpringBootApplication
public class LibreriaCervantesApplication implements CommandLineRunner {
	@Autowired
	private LibroRepository repository;
	@Autowired
	private AutorersRepository repositoryAutor;
	public static void main(String[] args) {
		SpringApplication.run(LibreriaCervantesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal=new Principal(repository, repositoryAutor);
		try {
			principal.creaMenu();
		}catch (InputMismatchException e){
			System.out.println("Por favor solo ingresa números");
		}
		System.out.println("Hasta la proxima");
	}
}
