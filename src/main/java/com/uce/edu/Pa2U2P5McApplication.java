package com.uce.edu;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5McApplication implements CommandLineRunner {

	@Autowired
	private ILibroService iLibroService;

	@Autowired
	private IAlumnoService alumnoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Libro libro = new Libro();
		libro.setTitulo("JAVA");
		libro.setFechaPublicacion(LocalDateTime.now());

		Autor autor1 = new Autor();
		autor1.setNombre("Pepito Perez");
		autor1.setNacionalidad("Ecuatoriano");

		Autor autor2 = new Autor();
		autor2.setNombre("Daniel Teran");
		autor2.setNacionalidad("Ecuatoriano");

		Set<Autor> autores = new HashSet<Autor>();
		autores.add(autor1);
		autores.add(autor2);

		libro.setAutores(autores);

		Set<Libro> libros = new HashSet<Libro>();
		libros.add(libro);

		autor1.setLibros(libros);
		autor2.setLibros(libros);

		this.iLibroService.guardar(libro);
	}

}
