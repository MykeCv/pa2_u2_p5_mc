package com.uce.edu.service;

import java.util.List;

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
	public Ciudadano buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorApellido(apellido);
	}

	@Override
	public Ciudadano buscarPorCriteria(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorCriteria(nombre, apellido, cedula);
	}

	@Override
	public Ciudadano buscarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorCriteriaAndOr(nombre, apellido, cedula);
	}

	// TAREA
	@Override
	public Ciudadano buscarPorEdadCriteria(String edad) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorEdadCriteria(edad);
	}

	@Override
	public List<Ciudadano> buscarPorNacionalidadCriteria(String nacionalidad) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorNacionalidadCriteria(nacionalidad);
	}

	@Override
	public Ciudadano buscarPorTituloCriteria(String titulo) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorTituloCriteria(titulo);
	}

	@Override
	public Ciudadano buscarPorCriteria1(String edad, String nacionalidad, String cedula) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorCriteria1(edad, nacionalidad, cedula);
	}

	@Override
	public List<Ciudadano> buscarPorCriteria2(String edad, String titulo) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorCriteria2(edad, titulo);
	}

	@Override
	public Ciudadano buscarPorCriteria3(String nacionalidad, String titulo) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorCriteria3(nacionalidad, titulo);
	}

}
