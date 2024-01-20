package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ICiudadanoRepository;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

@Service
public class ICiudadanoServiceImpl implements ICiudadanoService {

	@Autowired
	private ICiudadanoRepository ciudadanoRepository;

	@Override
	public void guardar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.insertar(ciudadano);
	}

	@Override
	public Ciudadano buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionar(id);
	}

	@Override
	public void borrar(int id) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.eliminar(id);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.actualizar(ciudadano);
	}

	@Override
	public Empleado buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorCedula(cedula);
	}

	@Override
	public Ciudadano buscarPorCedulaCiud(String cedula) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorCedulaciud(cedula);
	}

	@Override
	public Ciudadano buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorNombre(nombre);
	}

	@Override
	public Ciudadano buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorApellido(apellido);
	}

	@Override
	public Ciudadano buscarPorNacionalidad(String nacionalidad) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorNacionalidad(nacionalidad);
	}

	@Override
	public Ciudadano buscarPorEdad(String edad) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorEdad(edad);
	}

	@Override
	public Ciudadano buscarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorTitulo(titulo);
	}

}
