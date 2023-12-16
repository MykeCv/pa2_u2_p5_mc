package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P5McApplication implements CommandLineRunner {

	@Autowired
	private IEstudianteService estudianteService;
	@Autowired
	private IAlumnoService alumnoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// 1
		/*
		 * Estudiante estu = new Estudiante(); estu.setNombre("Marcos");
		 * estu.setApellido("Perez"); estu.setCedula("12215365");
		 * estu.setFechaNacimiento(LocalDateTime.of(1989, 07, 07, 07, 50));
		 * 
		 * this.estudianteService.guardar(estu);
		 */

		// 2
		Estudiante estu1 = this.estudianteService.buscar(17);
		System.out.println(estu1);

		// 3

		estu1.setNombre("Actualizado");
		this.estudianteService.actulizar(estu1);

		// 4
		// this.estudianteService.borrar(17);

//		/*--------------------------*/

		// 1
		/*
		 * Alumno alum = new Alumno(); alum.setNombre("Carlos");
		 * 
		 * this.alumnoService.guardar(alum);
		 */
		// 2
		Alumno alum1 = this.alumnoService.buscar(1);
		System.out.println(alum1);
		// 3
		alum1.setNombre("Juan");
		this.alumnoService.actulizar(alum1);
		// 4

		// this.alumnoService.borrar(3);

	}

}
