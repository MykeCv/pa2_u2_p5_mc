package com.uce.edu.repository;

import com.uce.edu.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {

	// Crud
	public CuentaBancaria seleccionar(Integer id);

	public void insertar(CuentaBancaria cuenta);

	public void actualizar(CuentaBancaria cuenta);

	public void eliminar(Integer id);
}
