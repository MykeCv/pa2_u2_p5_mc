package com.uce.edu.repository;

import java.util.List;

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

	// TAREA

	public Ciudadano seleccionarPorEdadCriteria(String edad);

	public List<Ciudadano> seleccionarPorNacionalidadCriteria(String nacionalidad);

	public Ciudadano seleccionarPorTituloCriteria(String titulo);

	// Cuando sea Ecuatoriano o mayor a 20 años
	public Ciudadano seleccionarPorCriteria1(String edad, String nacionalidad, String cedula);

	// Cuando sea mayor a 21 años o tenga titulo tecnico
	public List<Ciudadano> seleccionarPorCriteria2(String edad, String titulo);

	// Cuando sea Ecuatoriano y tenga titulo bachiller
	public Ciudadano seleccionarPorCriteria3(String nacionalidad, String titulo);

}
