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
	
	
	@PostConstruct
	public void init() {
		lstObjetivo= new ArrayList<>();
		lstProyecto=new ArrayList<>();
		this.listarobjetivo();
		this.listarproyecto();
	}
	
	public void listarobjetivo() {
		try {
			
			lstObjetivo=serviceobjetivo.listar();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void listarproyecto() {
		try {
			
			lstProyecto=serviceproyecto.listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void seleccionar(Objetivo t) {
		try {
			this.objetivo=serviceobjetivo.listarPorId(t);
			this.proyecto=objetivo.getProyecto();
			
		} catch (Exception e) {
			// TODO: handle exception
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
	
	
	

}
