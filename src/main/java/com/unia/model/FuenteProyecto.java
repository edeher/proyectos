package com.unia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="fuenteproyecto")
public class FuenteProyecto implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFuenteProyecto;
	
	@ManyToOne
	@JoinColumn(name="idProyecto", nullable=false)
	private Proyecto proyecto;
	
	@ManyToOne
	@JoinColumn(name="idFuente", nullable=false)
	private Fuente fuente;
	
	@Column(name="monto", columnDefinition="Decimal(10,2)", nullable=false)
	private double monto;

	public int getIdFuenteProyecto() {
		return idFuenteProyecto;
	}

	public void setIdFuenteProyecto(int idFuenteProyecto) {
		this.idFuenteProyecto = idFuenteProyecto;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Fuente getFuente() {
		return fuente;
	}

	public void setFuente(Fuente fuente) {
		this.fuente = fuente;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFuenteProyecto;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FuenteProyecto other = (FuenteProyecto) obj;
		if (idFuenteProyecto != other.idFuenteProyecto)
			return false;
		return true;
	}
	
	

}
