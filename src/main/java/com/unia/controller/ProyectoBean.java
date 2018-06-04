package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.model.Proyecto;
import com.unia.service.IProyectoService;

@Named
@ViewScoped
public class ProyectoBean implements Serializable {
	@Inject
	private Proyecto proyeto;
	@Inject
	private IProyectoService serviceProyecto;
	
	private List<Proyecto> lstProyecto;
	
	
	@PostConstruct
	public void init() {
		lstProyecto=new ArrayList<>();
		this.listar();
		
	}
	
	public void listar() {
		try {
			lstProyecto=serviceProyecto.listar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Proyecto getProyeto() {
		return proyeto;
	}

	public void setProyeto(Proyecto proyeto) {
		this.proyeto = proyeto;
	}

	public List<Proyecto> getLstProyecto() {
		return lstProyecto;
	}

	public void setLstProyecto(List<Proyecto> lstProyecto) {
		this.lstProyecto = lstProyecto;
	}
	
}
