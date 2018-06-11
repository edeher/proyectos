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
@Table(name="componente")
public class Componente implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idComponente;
	
	@ManyToOne
	@JoinColumn(name="idObjetivo", nullable=false)
	private Objetivo objetivo;
	
	@Column(name="nombre", length=100, nullable=false)
	private String nombre;
	
	@Column(name="estado", columnDefinition="char(1)", nullable=false)
	private String estado="1";

	public int getIdComponente() {
		return idComponente;
	}

	public void setIdComponente(int idComponente) {
		this.idComponente = idComponente;
	}

	public Objetivo getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idComponente;
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
		Componente other = (Componente) obj;
		if (idComponente != other.idComponente)
			return false;
		return true;
	}
	
	
}
