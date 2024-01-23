package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoService {

	public Ciudadano buscar(Integer id);

	public void guardar(Ciudadano ciudadano);

	public void borrar(int id);

	public void actualizar(Ciudadano ciudadano);

	public Empleado buscarPorCedula(String cedula);

	public Ciudadano buscarPorCedulaCiud(String cedula);

	public Ciudadano buscarPorApellido(String apellido);

	public Ciudadano buscarPorCriteria(String nombre, String apellido, String cedula);

	public Ciudadano buscarPorCriteriaAndOr(String nombre, String apellido, String cedula);

	// TAREA
	public Ciudadano buscarPorEdadCriteria(String edad);

	public List<Ciudadano> buscarPorNacionalidadCriteria(String nacionalidad);

	public Ciudadano buscarPorTituloCriteria(String titulo);

	// Cuando sea Ecuatoriano o mayor a 20 años
	public Ciudadano buscarPorCriteria1(String edad, String nacionalidad, String cedula);

	// Cuando sea mayor a 21 años o tenga titulo tecnico
	public List<Ciudadano> buscarPorCriteria2(String edad, String titulo);

	// Cuando sea Ecuatoriano y tenga titulo bachiller
	public Ciudadano buscarPorCriteria3(String nacionalidad, String titulo);

}
