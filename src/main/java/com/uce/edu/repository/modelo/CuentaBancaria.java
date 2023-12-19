package com.uce.edu.repository.modelo;

import java.math.BigDecimal;

public class CuentaBancaria {
	private String numero;
	private String cedulaPropietario;
	private BigDecimal saldo;

	// SETS Y GETS
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCedulaPropietario() {
		return cedulaPropietario;
	}

	public void setCedulaPropietario(String cedulaPropietario) {
		this.cedulaPropietario = cedulaPropietario;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [numero=" + numero + ", cedulaPropietario=" + cedulaPropietario + ", saldo=" + saldo
				+ "]";
	}
}
