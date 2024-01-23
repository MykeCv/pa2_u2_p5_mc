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

		// CRITERIA API QUERY

		Ciudadano ciu = this.ciudadanoService.buscarPorApellido("Gomez");
		System.out.println(ciu);

		// select
		// c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_edad,c1_0.ciud_nacionalidad,c1_0.ciud_nombre,c1_0.ciud_titulo
		// from ciudadano c1_0 where c1_0.ciud_nombre=?
		Ciudadano ciu1 = this.ciudadanoService.buscarPorCriteria("Miguel", "Fernandez", "17171717");
		System.out.println(ciu1);

		// select
		// c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_edad,c1_0.ciud_nacionalidad,c1_0.ciud_nombre,c1_0.ciud_titulo
		// from ciudadano c1_0 where c1_0.ciud_apellido=?
		Ciudadano ciu2 = this.ciudadanoService.buscarPorCriteria("Miguel", "Fernandez", "05050505");
		System.out.println(ciu2);

		// select
		// c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_edad,c1_0.ciud_nacionalidad,c1_0.ciud_nombre,c1_0.ciud_titulo
		// from ciudadano c1_0 where c1_0.ciud_cedula=?
		Ciudadano ciu3 = this.ciudadanoService.buscarPorCriteria("Miguel", "Fernandez", "17171717");
		System.out.println(ciu3);

		System.out.println("Criteria API Query And Or");
		// select
		// c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_edad,c1_0.ciud_nacionalidad,c1_0.ciud_nombre,c1_0.ciud_titulo
		// from ciudadano c1_0 where c1_0.ciud_nombre=? or c1_0.ciud_apellido=?
		Ciudadano ciu4 = this.ciudadanoService.buscarPorCriteriaAndOr("Miguel", "Fernandez", "17171717");
		System.out.println(ciu4);

		// select
		// c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_edad,c1_0.ciud_nacionalidad,c1_0.ciud_nombre,c1_0.ciud_titulo
		// from ciudadano c1_0 where c1_0.ciud_nombre=? and c1_0.ciud_apellido=?
		Ciudadano ciu5 = this.ciudadanoService.buscarPorCriteriaAndOr("Miguel", "Fernandez", "05050505");
		System.out.println(ciu5);
	}

}
