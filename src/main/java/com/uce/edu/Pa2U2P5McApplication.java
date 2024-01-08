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
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5McApplication implements CommandLineRunner {

	@Autowired
	private ILibroService iLibroService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Libro libro = new Libro();
		libro.setTitulo("JAVA");
		libro.setFechaPublicacion(LocalDateTime.now());

		Libro libro1 = new Libro();
		libro1.setTitulo("ANALITICS");
		libro1.setFechaPublicacion(LocalDateTime.now());

		Libro libro2 = new Libro();
		libro2.setTitulo("TRUE HISTORY");
		libro2.setFechaPublicacion(LocalDateTime.now());

		Libro libro3 = new Libro();
		libro3.setTitulo("APLICATION V");
		libro3.setFechaPublicacion(LocalDateTime.now());

		Libro libro4 = new Libro();
		libro4.setTitulo("TRAFALGAR D WATER LAW");
		libro4.setFechaPublicacion(LocalDateTime.now());

		Libro libro5 = new Libro();
		libro5.setTitulo("GOL D ROGUER");
		libro5.setFechaPublicacion(LocalDateTime.now());

		Autor autor1 = new Autor();
		autor1.setNombre("Pepito Perez");
		autor1.setNacionalidad("Ecuatoriano");

		Autor autor2 = new Autor();
		autor2.setNombre("Daniel Teran");
		autor2.setNacionalidad("Ecuatoriano");

		Autor autor3 = new Autor();
		autor3.setNombre("Sptheve Hipton");
		autor3.setNacionalidad("EstadoUnidense");

		Autor autor4 = new Autor();
		autor4.setNombre("Isacc Amstrom");
		autor4.setNacionalidad("Aleman");

		Autor autor5 = new Autor();
		autor5.setNombre("Frederic Voltovik");
		autor5.setNacionalidad("Ruso");

		Set<Autor> autores = new HashSet<Autor>();
		autores.add(autor1);
		autores.add(autor2);
		autores.add(autor3);
		autores.add(autor4);
		autores.add(autor5);

		libro.setAutores(autores);

		Set<Libro> libros = new HashSet<Libro>();
		libros.add(libro);
		libros.add(libro1);
		libros.add(libro2);
		Set<Libro> libros2 = new HashSet<Libro>();
		libros.add(libro3);
		libros.add(libro4);
		libros.add(libro5);

		autor1.setLibros(libros);
		autor2.setLibros(libros);
		autor3.setLibros(libros2);
		autor4.setLibros(libros2);
		autor5.setLibros(libros2);

		this.iLibroService.guardar(libro);
	}

}
