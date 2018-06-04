package com.unia.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proyecto")
public class Proyecto implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProyecto;
	
	@Column(name="nombre", length=1500, nullable=false)
	private String nombre;
	
	@Column(name="fechaPresentacion", nullable=false)
	private LocalDate fechaPresentacion;
	
	@Column(name="fechaInicio", nullable=false)
	private LocalDate fechaInicio;
	
	@Column(name="tipofinanaciamiento", length=2, nullable=false)
	private String tipofinanaciamiento;
	
	@Column(name="perfilduracion", length=8, nullable=false)
	private String perfilduracion;
	
	@Column(name="tiempovigencia", length=8, nullable=false)
	private String tiempovigencia;
	
	@Column(name="estado", columnDefinition="char(1)", nullable=false)
	private String estado="1";

	public int getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaPresentacion() {
		return fechaPresentacion;
	}

	public void setFechaPresentacion(LocalDate fechaPresentacion) {
		this.fechaPresentacion = fechaPresentacion;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getTipofinanaciamiento() {
		return tipofinanaciamiento;
	}

	public void setTipofinanaciamiento(String tipofinanaciamiento) {
		this.tipofinanaciamiento = tipofinanaciamiento;
	}

	public String getPerfilduracion() {
		return perfilduracion;
	}

	public void setPerfilduracion(String perfilduracion) {
		this.perfilduracion = perfilduracion;
	}

	public String getTiempovigencia() {
		return tiempovigencia;
	}

	public void setTiempovigencia(String tiempovigencia) {
		this.tiempovigencia = tiempovigencia;
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
		result = prime * result + idProyecto;
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
		Proyecto other = (Proyecto) obj;
		if (idProyecto != other.idProyecto)
			return false;
		return true;
	}
	
	
}
