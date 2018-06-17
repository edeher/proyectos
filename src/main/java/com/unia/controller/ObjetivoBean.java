package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.model.Objetivo;
import com.unia.model.Proyecto;
import com.unia.service.IObjetivoService;
import com.unia.service.IProyectoService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class ObjetivoBean implements Serializable{
	
	@Inject
	private Objetivo objetivo;
	@Inject
	private Proyecto proyecto;
	@Inject 
	private IObjetivoService serviceobjetivo;
	@Inject 
	private IProyectoService serviceproyecto;
	
	private List<Objetivo> lstObjetivo;
	private List<Proyecto> lstProyecto;
	
	private String titulo;
	
	
	@PostConstruct
	public void init() {
		lstObjetivo= new ArrayList<>();
		lstProyecto=new ArrayList<>();
		this.listarobjetivo();
		this.listarproyecto();
	}
	
	public void limpiarControles() {
		this.titulo="Nuevo";
		this.lstProyecto.clear();
		this.lstProyecto=new ArrayList<>();
		this.listarproyecto();
		this.objetivo.getProyecto().setIdProyecto((short)0);
		this.objetivo.setIdObjetivo((short)0);
		this.objetivo.setDescripcion(null);
		this.objetivo.setEstado("in");
		
	}
	public void listarobjetivo() {
		try {
			
			lstObjetivo=serviceobjetivo.listar();
			
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	
	
	public void listarproyecto() {
		try {
			
			lstProyecto=serviceproyecto.listar();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	public void seleccionar(Objetivo t) {
		try {
			this.objetivo=serviceobjetivo.listarPorId(t);
			this.proyecto=objetivo.getProyecto();
			
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}finally {
			this.titulo="Modificar";
		}
	}
	
	public void operar() {
		try {
			if(objetivo.getIdObjetivo()>0) {
				objetivo.setProyecto(proyecto);
				serviceobjetivo.modificar(objetivo);
				MensajeManager.mostrarMensaje("Aviso", "Modificación Exitosa", "INFO");
			}else {
				objetivo.setProyecto(proyecto);
				serviceobjetivo.registrar(objetivo);
				MensajeManager.mostrarMensaje("Aviso", "Registro Exitoso", "INFO");
			}
			
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
		
	}
	
	public Objetivo getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	public List<Objetivo> getLstObjetivo() {
		return lstObjetivo;
	}
	public void setLstObjetivo(List<Objetivo> lstObjetivo) {
		this.lstObjetivo = lstObjetivo;
	}
	public List<Proyecto> getLstProyecto() {
		return lstProyecto;
	}
	public void setLstProyecto(List<Proyecto> lstProyecto) {
		this.lstProyecto = lstProyecto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	

}
