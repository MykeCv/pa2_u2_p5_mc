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

	public Ciudadano seleccionarPorNombre(String nombre);

	public Ciudadano seleccionarPorApellido(String apellido);

	public Ciudadano seleccionarPorNacionalidad(String nacionalidad);

	public Ciudadano seleccionarPorEdad(String edad);

	public Ciudadano seleccionarPorTitulo(String titulo);

}
