package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.model.Autor;
import com.unia.model.Escuela;
import com.unia.model.Facultad;
import com.unia.service.IAutorService;
import com.unia.service.IEscuelaService;
import com.unia.service.IFacultadService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class AutorBean implements Serializable{
	
	@Inject
	private Autor autor;
	@Inject
	private Facultad facultad;
	@Inject
	private Escuela escuela;
	@Inject 
	private IAutorService serviceautor;
	@Inject
	private IFacultadService servicefacultad;
	@Inject
	private IEscuelaService serviceescuela;
	
	private List<Autor> lstAutor;
	private List<Facultad> lstFacultad;
	private List<Escuela> lstEscuela;
	private String titulo;
	
	@PostConstruct
	public void init() {
		lstEscuela= new ArrayList<>();
		lstAutor= new ArrayList<>();
		lstFacultad= new ArrayList<>();
		this.listarautor();
		this.listarfacultad();
		this.listarescuela();
		
	}
	public void limpiarControles() {
		this.titulo="Nuevo";
		this.lstFacultad.clear();
		this.lstFacultad= new ArrayList<>();
		this.listarfacultad();
		this.lstEscuela.clear();
		this.lstEscuela=new ArrayList<>();
		this.listarescuela();
		this.autor.setIdAutor((short)0);
		this.autor.setNombres(null);
		this.autor.setApellidos(null);
		this.autor.setCategoria(null);
		this.autor.setDireccion(null);
		this.autor.setEmail(null);
		this.autor.setTelefono(null);
		this.autor.setSexo(null);
		
		this.autor.setEscuela(null);
		this.autor.setEstado("1");
	}
	public void listarautor() {
		try {
			lstAutor= serviceautor.listar();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	public void seleccionFacultad() {
		
		
	}
	public void listarfacultad() {
		try {
			lstFacultad=servicefacultad.listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void listarescuela() {
		try {
			
				if(facultad!=null) {		
					
				lstEscuela= serviceescuela.listarPorFacultad(facultad);
				}else {
					
					lstEscuela= serviceescuela.listar();
				}
			
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	public void selecionar(Autor t) {
		try {
			
			this.autor=serviceautor.listarPorId(t);
			this.escuela=autor.getEscuela();
			this.facultad=escuela.getFacultad();
			this.listarescuela();
			
			
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}finally {
			this.titulo="Modificar";
		}
	}
	public void operar() {
		try {
			
			if(autor.getIdAutor()>0){
				autor.setEscuela(escuela);
				serviceautor.modificar(autor);
				MensajeManager.mostrarMensaje("Aviso", "MOdificaci�n Exitosa", "INFO");
			}else {
				autor.setEscuela(escuela);
				serviceautor.registrar(autor);
				MensajeManager.mostrarMensaje("Aviso", "Registro Exitoso", "INFO");
			}
			
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	
	

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public List<Autor> getLstAutor() {
		return lstAutor;
	}
	public void setLstAutor(List<Autor> lstAutor) {
		this.lstAutor = lstAutor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<Facultad> getLstFacultad() {
		return lstFacultad;
	}
	public void setLstFacultad(List<Facultad> lstFacultad) {
		this.lstFacultad = lstFacultad;
	}
	public List<Escuela> getLstEscuela() {
		return lstEscuela;
	}
	public void setLstEscuela(List<Escuela> lstEscuela) {
		this.lstEscuela = lstEscuela;
	}
	public Facultad getFacultad() {
		return facultad;
	}
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}
	public Escuela getEscuela() {
		return escuela;
	}
	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}
	
	
	
	

}
