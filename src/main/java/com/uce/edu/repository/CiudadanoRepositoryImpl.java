package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
	}

	@Override
	public Ciudadano seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Ciudadano.class, id);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		this.entityManager.merge(ciudadano);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Ciudadano ciudEncontrado = this.seleccionar(id);
		this.entityManager.remove(ciudEncontrado);

	}

	@Override
	public Empleado seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Empleado> myQuery = this.entityManager
				.createQuery("SELECT e FROM Empleado e WHERE e.ciudadano.cedula = :cedula", Empleado.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCedulaciud(String cedula) {
		// TODO Auto-generated method stub

		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_cedula = :cedula",
				Ciudadano.class);
		myQuery.setParameter("cedula", cedula);
		return (Ciudadano) myQuery.getSingleResult();
	}

//5 TypedQuery--------------------------------------------
	@Override
	public Ciudadano seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano n WHERE n.ciud_nombre = :nombre",
				Ciudadano.class);
		myQuery.setParameter("nombre", nombre);
		return (Ciudadano) myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager
				.createNativeQuery("SELECT * FROM ciudadano a WHERE a.ciud_apellido = :apellido", Ciudadano.class);
		myQuery.setParameter("apellido", apellido);
		return (Ciudadano) myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorNacionalidad(String nacionalidad) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery(
				"SELECT * FROM ciudadano na WHERE na.ciud_nacionalidad = :nacionalidad", Ciudadano.class);
		myQuery.setParameter("nacionalidad", nacionalidad);
		return (Ciudadano) myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorEdad(String edad) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano ed WHERE ed.ciud_edad = :edad",
				Ciudadano.class);
		myQuery.setParameter("edad", edad);
		return (Ciudadano) myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano t WHERE t.ciud_titulo = :titulo",
				Ciudadano.class);
		myQuery.setParameter("titulo", titulo);
		return (Ciudadano) myQuery.getSingleResult();
	}
//NamedQuery----------------------------------------------------
}
