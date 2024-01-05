package com.uce.edu.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cedula")
public class Cedula {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cedula")
	@SequenceGenerator(name = "seq_cedula", sequenceName = "seq_cedula", allocationSize = 1)
	@Column(name = "cdl_id")
	private Integer id;
	@Column(name = "cld_noPasaporte")
	private String noPasaporte;
	@OneToOne
	@JoinColumn(name = "cld_pst_id")
	private Pasaporte pasaporte;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNoPasaporte() {
		return noPasaporte;
	}
	public void setNoPasaporte(String noPasaporte) {
		this.noPasaporte = noPasaporte;
	}
	public Pasaporte getPasaporte() {
		return pasaporte;
	}
	public void setPasaporte(Pasaporte pasaporte) {
		this.pasaporte = pasaporte;
	}

}
