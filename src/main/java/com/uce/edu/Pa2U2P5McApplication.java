package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
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
		Empleado empl = this.ciudadanoService.buscarPorCedula("1724362106");
		System.out.println(empl);

		Ciudadano ciu = this.ciudadanoService.buscarPorCedulaCiud("1724362106");
		System.out.println(ciu);
	}

}
