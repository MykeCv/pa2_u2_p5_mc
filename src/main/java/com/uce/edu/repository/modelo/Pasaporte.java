package com.uce.edu.repository.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pasaporte")
public class Pasaporte {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pasaporte")
	@SequenceGenerator(name = "seq_pasaporte", sequenceName = "seq_pasaporte", allocationSize = 1)
	@Column(name = "pst_id")
	private Integer id;
	@Column(name = "pst_nombre")
	private String nombre;
	@Column(name = "pst_apellido")
	private String apellido;
	@OneToOne(mappedBy = "pasaporte", cascade = CascadeType.ALL)
	private Cedula cedula;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Cedula getCedula() {
		return cedula;
	}

	public void setCedula(Cedula cedula) {
		this.cedula = cedula;
	}

}
