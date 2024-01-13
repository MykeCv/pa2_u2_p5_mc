package com.uce.edu;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5McApplication implements CommandLineRunner {

	// 1. Query (JPQL)
	// 1.1 TypedQuery
	// 1.2 NamedQuery
	// 2. Native Query
	// 3. Criteria API Query

	@Autowired
	private ILibroService iLibroService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Query");
		List<Libro> lista = this.iLibroService.buscarPorFecha(LocalDateTime.of(2023, 1, 1, 7, 15));
		for (Libro libro : lista) {
			System.out.println(libro);
		}
		System.out.println("TypedQuery");
		Libro l1 = this.iLibroService.buscarPorTitulo("TRAFALGAR D WATER LAW");
		System.out.println(l1);

		List<Libro> lista2 = this.iLibroService.buscarPorFechaPubli(LocalDateTime.of(2023, 1, 1, 7, 15));
		for (Libro libro : lista2) {
			System.out.println(libro);
		}

		System.out.println("NamedQuery");
		Libro l2 = this.iLibroService.buscarPorTituloNamed("GOL D ROGUER");
		System.out.println(l2);
		List<Libro> lista3 = this.iLibroService.buscarPorFechaPubliNamed(LocalDateTime.of(2023, 1, 1, 7, 15));
		for (Libro libro : lista3) {
			System.out.println(libro);
		}

	}

}
