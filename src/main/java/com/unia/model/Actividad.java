package com.unia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="actividad")
public class Actividad {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAutor;
	
	@ManyToOne
	@JoinColumn(name="idComponente", nullable=false)
	private Componente componente;
	
	@Column(name="nombre",length=150, nullable=false)
	private String nombre;
	
	@Column(name="estado", columnDefinition="char(1)", nullable=false)
	private String estado;

}
