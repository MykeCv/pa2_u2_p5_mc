package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.service.ICiudadanoService;

@SpringBootApplication
public class Pa2U2P5McApplication implements CommandLineRunner {

	// 1. Query (JPQL)
	// 1.1 TypedQuery
	// 1.2 NamedQuery
	// 2. Native Query //Mantener el rendimiento
	// 3. Criteria API Query

	@Autowired
	private ICiudadanoService ciudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Ciudadano ciud1 = this.ciudadanoService.buscarPorNombre("Julio");
		Ciudadano ciud2 = this.ciudadanoService.buscarPorApellido("Gomez");
		Ciudadano ciud3 = this.ciudadanoService.buscarPorEdad("25");
		Ciudadano ciud4 = this.ciudadanoService.buscarPorNacionalidad("Colombiana");
		Ciudadano ciud5 = this.ciudadanoService.buscarPorTitulo("Tecnico");
		System.out.println(ciud1);
		System.out.println(ciud2);
		System.out.println(ciud3);
		System.out.println(ciud4);
		System.out.println(ciud5);
	}

}
