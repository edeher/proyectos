package com.unia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proyecto")
public class Proyecto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProyecto;
	
	@Column(name="nombre", length=1500, nullable=false)
	private String nombre;
	
	
	
	@Column(name="tipofinanaciamiento", length=2, nullable=false)
	private String tipofinanaciamiento;
	
	@Column(name="perfilduracion", length=8, nullable=false)
	private String perfilduracion;
	
	@Column(name="tiempovigencia", length=8, nullable=false)
	private String tiempovigencia;
	
	@Column(name="estado", columnDefinition="char(1)", nullable=false)
	private String estado;
	
}
