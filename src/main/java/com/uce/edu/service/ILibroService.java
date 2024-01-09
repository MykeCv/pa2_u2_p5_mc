package com.uce.edu.service;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroService {

	public void guardar(Libro libro);

	public void guardar(Libro2 libro);

	public Libro buscar(Integer id);

	public void actulizar(Libro libro);

	public void borrar(Integer id);
	
	public Libro buscarPorNombre(String nombre);
}
