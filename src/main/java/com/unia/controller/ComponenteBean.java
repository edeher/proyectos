package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.model.Componente;
import com.unia.model.Objetivo;
import com.unia.service.IComponenteService;
import com.unia.service.IObjetivoService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class ComponenteBean implements Serializable{
	
	@Inject 
	private Componente componente;
	@Inject 
	private Objetivo objetivo;
	
	@Inject
	private IComponenteService servicecomponente;
	@Inject
	private IObjetivoService serviceobjetivo;
	
	private List<Componente> lstComponente;
	private List<Objetivo> lstObjetivo;
	private String titulo;
	
	@PostConstruct
	public void init() {
		lstComponente=new ArrayList<>();
		lstObjetivo= new ArrayList<>();
		this.listarcomponente();
		this.listarobjetivo();
		
	}
	public void limpiarControles() {
		this.titulo="Nuevo";
		this.lstObjetivo.clear();
		this.lstObjetivo=new ArrayList<>();
		this.listarobjetivo();
		this.componente.getObjetivo().setIdObjetivo((short)0);
		this.componente.setIdComponente((short)0);
		this.componente.setDescripcion(null);
		this.componente.setEstado("in");
	}
	public void listarcomponente() {
		try {
			lstComponente=servicecomponente.listar();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	public void listarobjetivo() {
		try {
			lstObjetivo=serviceobjetivo.listar();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	public void seleccionar(Componente t) {
		try {
			this.componente=servicecomponente.listarPorId(t);
			this.objetivo=componente.getObjetivo();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}finally {
			this.titulo="Modificar";
		}
	}
	public void operar() {
		try {
			if(componente.getIdComponente()>0) {
				componente.setObjetivo(objetivo);
				servicecomponente.modificar(componente);
				MensajeManager.mostrarMensaje("Aviso", "MOdificaci�n Exitosa", "INFO");
			}else {
				componente.setObjetivo(objetivo);
				servicecomponente.registrar(componente);
				MensajeManager.mostrarMensaje("Aviso", "Registro Exitoso", "INFO");
			}
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	
	
	
	
	
	public Componente getComponente() {
		return componente;
	}
	public void setComponente(Componente componente) {
		this.componente = componente;
	}
	public Objetivo getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}
	public List<Componente> getLstComponente() {
		return lstComponente;
	}
	public void setLstComponente(List<Componente> lstComponente) {
		this.lstComponente = lstComponente;
	}
	public List<Objetivo> getLstObjetivo() {
		return lstObjetivo;
	}
	public void setLstObjetivo(List<Objetivo> lstObjetivo) {
		this.lstObjetivo = lstObjetivo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
	
	

}
