package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoRepository {

	public void insertar(Ciudadano ciudadano);

	public Ciudadano seleccionar(Integer id);

	public void eliminar(Integer id);

	public void actualizar(Ciudadano ciudadano);

	public Empleado seleccionarPorCedula(String cedula);

	public Ciudadano seleccionarPorCedulaciud(String cedula);
	// ------------------

	public Ciudadano seleccionarPorApellido(String apellido);

	// Funcionalidada que cuando sea el ciudadano de Pichincha lo busque por nombre
	// Cuando sea de cotopaxi sea de lo busque por apellido
	// Cuando no sea ni de cotopaxi ni pichincha, lo busque por cedula
	public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula);

	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula);

}
