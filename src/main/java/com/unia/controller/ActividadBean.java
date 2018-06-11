package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.model.Actividad;
import com.unia.model.Componente;
import com.unia.service.IActividadService;
import com.unia.service.IComponenteService;

@Named
@ViewScoped
public class ActividadBean implements Serializable{
	
	@Inject 
	private Actividad actividad;
	@Inject 
	private IActividadService serviceactividad;
	@Inject
	private Componente componente;
	@Inject 
	private IComponenteService servicecomponente;
	
	private List<Componente> lstComponente;
	private List<Actividad> lstActividad;
	
	@PostConstruct
	public void init() {
		lstActividad=new ArrayList<>();
		lstComponente=new ArrayList<>();
		this.listaractividad();
		this.listarcomponente();
	}
	public void listaractividad() {
		try {
			lstActividad=serviceactividad.listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void listarcomponente() {
		try {
			lstComponente=servicecomponente.listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void selecionar(Actividad t) {
		try {
			this.actividad=serviceactividad.listarPorId(t);
			this.componente=actividad.getComponente();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void operar () {
		try {
			if(actividad.getIdActividad()>0) {
				actividad.setComponente(componente);
				serviceactividad.modificar(actividad);
			}else {
				actividad.setComponente(componente);
				serviceactividad.registrar(actividad);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
	
	public Actividad getActividad() {
		return actividad;
	}
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	public Componente getComponente() {
		return componente;
	}
	public void setComponente(Componente componente) {
		this.componente = componente;
	}
	public List<Actividad> getLstActividad() {
		return lstActividad;
	}
	public void setLstActividad(List<Actividad> lstActividad) {
		this.lstActividad = lstActividad;
	}
	public List<Componente> getLstComponente() {
		return lstComponente;
	}
	public void setLstComponente(List<Componente> lstComponente) {
		this.lstComponente = lstComponente;
	}
	

}
