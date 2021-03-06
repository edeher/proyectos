package com.unia.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="proyecto")
public class Proyecto implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProyecto;
	
	@Column(name="nombre", length=1500, nullable=false)
	private String nombre;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaPresentacion", nullable=false)
	private Date fechaPresentacion;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaInicio", nullable=false)
	private Date fechaInicio;
	
	
	@Column(name="montoAprobado", columnDefinition="Decimal(10,2)", nullable=false)
	private double montoAprobado;
	
	@Column(name="montoRestante", columnDefinition="Decimal(10,2)", nullable=false)
	private double montoRestante;
	
	@Column(name="tipofinanciamiento", length=2, nullable=false)
	private String tipofinanciamiento;
	
	@Column(name="perfilduracion", length=8, nullable=false)
	private String perfilduracion;
	
	@Column(name="tiempovigencia", length=8, nullable=false)
	private String tiempovigencia;
	
	@Column(name="estado", columnDefinition="char(2)", nullable=false)
	private String estado="in";
	
	@OneToMany(mappedBy = "proyecto", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Objetivo> objetivos;
	
	@OneToMany(mappedBy = "proyecto", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<FuenteProyecto> fuentesproyectos;
	

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

	

	public Date getFechaPresentacion() {
		return fechaPresentacion;
	}

	public void setFechaPresentacion(Date fechaPresentacion) {
		this.fechaPresentacion = fechaPresentacion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getTipofinanciamiento() {
		return tipofinanciamiento;
	}

	public void setTipofinanciamiento(String tipofinanciamiento) {
		this.tipofinanciamiento = tipofinanciamiento;
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
	
	

	public double getMontoAprobado() {
		return montoAprobado;
	}

	public void setMontoAprobado(double montoAprobado) {
		this.montoAprobado = montoAprobado;
	}

	public double getMontoRestante() {
		return montoRestante;
	}

	public void setMontoRestante(double montoRestante) {
		this.montoRestante = montoRestante;
	}

	public List<Objetivo> getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(List<Objetivo> objetivos) {
		this.objetivos = objetivos;
	}
	

	public List<FuenteProyecto> getFuentesproyectos() {
		return fuentesproyectos;
	}

	public void setFuentesproyectos(List<FuenteProyecto> fuentesproyectos) {
		this.fuentesproyectos = fuentesproyectos;
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
