package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor2;
import com.uce.edu.repository.modelo.AutorLibro;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;
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
		Libro2 libro = new Libro2();
		libro.setTitulo("JAVA2");
		libro.setFechaPublicacion(LocalDateTime.now());

		Autor2 autor1 = new Autor2();
		autor1.setNombre("Pepito Perez2");
		autor1.setNacionalidad("Ecuatoriano2");

		Autor2 autor2 = new Autor2();
		autor2.setNombre("Daniel Teran2");
		autor2.setNacionalidad("Ecuatoriano2");

		Set<Autor2> autores = new HashSet<Autor2>();
		autores.add(autor1);
		autores.add(autor2);

		AutorLibro autorLibro1 = new AutorLibro();
		autorLibro1.setLibro2(libro);
		autorLibro1.setAutor2(autor1);
		autorLibro1.setDateTime(LocalDateTime.now());

		AutorLibro autorLibro2 = new AutorLibro();
		autorLibro2.setLibro2(libro);
		autorLibro2.setAutor2(autor2);
		autorLibro2.setDateTime(LocalDateTime.now());

		List<AutorLibro> lista = new ArrayList<>();
		lista.add(autorLibro1);
		lista.add(autorLibro2);

		libro.setAutoreslibros(lista);

		//this.iLibroService.guardar(libro);
		Libro libroFinal=this.iLibroService.buscarPorNombre("ANALITICS");
		System.out.println(libroFinal);
	}

}
