package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IEmpleadoRepository;
import com.uce.edu.repository.modelo.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepository empleadoRepository;

	@Override
	public void guardar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepository.insertar(empleado);
	}

	@Override
	public Empleado buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.empleadoRepository.seleccionar(id);
	}

	@Override
	public void actulizar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepository.actualizar(empleado);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.empleadoRepository.eliminar(id);
	}

}
