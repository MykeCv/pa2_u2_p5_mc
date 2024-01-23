package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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

	@Override
	public Ciudadano seleccionarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		// SELECT c FROM Ciudadano c WHERE c.apellido :variable
		// 0. Creamos una instancia de la interfaz CriteriaBuilder a partir de un entity
		// manager
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();

		// 1. Determinamos el tipo de retorno que va a tener mi Consulta
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteria.createQuery(Ciudadano.class);
		// 2. Construir nuestro SQL
		// 2.1 Determinamos el FROM (Root)
		// Nota: No necesariamente el from es igual al tipo de retorno
		// SELECT c FROM Ciudadano c WHERE c.nombre =:dato

		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class); // FROM Ciudadano
		// 2.2 Construir las condiciones (WHERE del SQL)
		// En criteria apoi query las condiciones se las conoce como Predicadate
		// c.apellido = :variable
		Predicate condicionApellido = myCriteria.equal(myFrom.get("apellido"), apellido);
		// 3. Construimos nuestro SQL final
		myCriteriaQuery.select(myFrom).where(condicionApellido);
		// 4. Ejecutamos la consulta con un typedQuery
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		// 0. Creamos una instancia de interfaz CriteriaBuilder
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		// 1. Determinamos el tipo de retorno que va a tener mi consulta
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);
		// 2. Contruimos el SQL
		// 2.1 Determinamos el FROM a travez de una interfaz (Root)
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);
		// 2.2 Construir las condiciones del WHERE por el predicate

		Predicate condicionGenerica = null;

		if (cedula.startsWith("17")) {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
		} else if (cedula.startsWith("05")) {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);
		} else {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("cedula"), cedula);
		}

		// 3. Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionGenerica);
		// 4. Ejecutamos la consulta con un typedQuery
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		// 0. Creamos una instancia de interfaz CriteriaBuilder
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		// 1. Determinamos el tipo de retorno que va a tener mi consulta
		CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);
		// 2. Contruimos el SQL
		// 2.1 Determinamos el FROM a travez de una interfaz (Root)
		Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);
		// 2.2 Construir las condiciones del WHERE por el predicate

		Predicate condicionTotal = null;
		// c.nombre = :nombre
		Predicate condicionNombre = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
		// c.apelliod =:apellido
		Predicate condicionApellido = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);

		if (cedula.startsWith("17")) {
			// c.nombre = :nombre or c.apelliod =:apellido
			condicionTotal = myCriteriaBuilder.or(condicionNombre, condicionApellido);
		} else if (cedula.startsWith("05")) {
			// c.nombre = :nombre and c.apelliod =:apellido
			condicionTotal = myCriteriaBuilder.and(condicionNombre, condicionApellido);
		}
		// 3. Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionTotal);
		// 4. Ejecutamos la consulta con un typedQuery
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		return myTypedQuery.getSingleResult();
	}

}
