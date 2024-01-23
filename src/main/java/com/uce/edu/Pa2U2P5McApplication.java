package com.uce.edu;

import java.util.List;

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

		// TAREA: 5 EJEMPLOS QUERY
		
		System.out.println("Consulta 1--------------------------------------");
		// select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_edad,c1_0.ciud_nacionalidad,c1_0.ciud_nombre,c1_0.ciud_titulo
		// from ciudadano c1_0 where c1_0.ciud_edad=?
		Ciudadano ciudadano1 = this.ciudadanoService.buscarPorEdadCriteria("23");
		System.out.println(ciudadano1);

		
		System.out.println("Consulta 2--------------------------------------");
		// select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_edad,c1_0.ciud_nacionalidad,c1_0.ciud_nombre,c1_0.ciud_titulo
		// from ciudadano c1_0 where c1_0.ciud_nacionalidad=?
		List<Ciudadano> ciudadano2 = this.ciudadanoService.buscarPorNacionalidadCriteria("Ecuatoriana");
		System.out.println(ciudadano2);

		
		System.out.println("Consulta 3--------------------------------------");
		// select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_edad,c1_0.ciud_nacionalidad,c1_0.ciud_nombre,c1_0.ciud_titulo
		// from ciudadano c1_0 where c1_0.ciud_titulo=?
		Ciudadano ciudadano3 = this.ciudadanoService.buscarPorTituloCriteria("Tecnico");
		System.out.println(ciudadano3);

		
		System.out.println("Consulta 4--------------------------------------");
		// select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_edad,c1_0.ciud_nacionalidad,c1_0.ciud_nombre,c1_0.ciud_titulo
		// from ciudadano c1_0 where c1_0.ciud_edad=?
		Ciudadano ciudadano4 = this.ciudadanoService.buscarPorCriteria1("23", "Ecuatoriana", "1724362106");
		System.out.println(ciudadano4);

		
		System.out.println("Consulta 5--------------------------------------");
		// select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_edad,c1_0.ciud_nacionalidad,c1_0.ciud_nombre,c1_0.ciud_titulo 
		//from ciudadano c1_0 where c1_0.ciud_titulo=?
		List<Ciudadano> ciudadano5 = this.ciudadanoService.buscarPorCriteria2("21", "Bachiller");
		System.out.println(ciudadano5);

		System.out.println("Consulta 6--------------------------------------");
		//select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_edad,c1_0.ciud_nacionalidad,c1_0.ciud_nombre,c1_0.ciud_titulo 
		//from ciudadano c1_0 where c1_0.ciud_nacionalidad=? and c1_0.ciud_titulo=?
		Ciudadano ciudadano6 = this.ciudadanoService.buscarPorCriteria3("Colombiana", "Bachiller");
		System.out.println(ciudadano6);

	}

}
