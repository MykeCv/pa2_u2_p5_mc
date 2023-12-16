package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IAlumnoRepository;
import com.uce.edu.repository.modelo.Alumno;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

	@Autowired
	private IAlumnoRepository alumnoRepository;

	@Override
	public Alumno buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.alumnoRepository.seleccionar(id);
	}

	@Override
	public void guardar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.alumnoRepository.insertar(alumno);
	}

	@Override
	public void actulizar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.alumnoRepository.actualizar(alumno);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.alumnoRepository.eliminar(id);
	}

}
