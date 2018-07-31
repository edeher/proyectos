package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import com.unia.model.FuenteProyecto;
import com.unia.model.Proyecto;
import com.unia.service.IFuenteProyectoService;
import com.unia.service.IProyectoService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class ProyectosBean implements Serializable{

	
@Inject 
private Proyecto proyectos;
@Inject
private IProyectoService serviceproyectos;
@Inject
private FuenteProyecto fuenteproyecto;
@Inject
private IFuenteProyectoService servicefueteproyecto;


private List<Proyecto> lstProyectos;
private List<FuenteProyecto> lstFuenteProyecto;

@PostConstruct
public void init() {
	lstProyectos= new ArrayList<>();
	this.listarproyectos();
	
	this.actualizarmonto();
	
	
}

public void listarproyectos() {
	
	try {
		lstProyectos= serviceproyectos.listar();
	} catch (Exception e) {
		MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
	}
}
public void actualizarmonto() {

	try {
		
		for(Proyecto proyectoss: this.lstProyectos) {
			
		this.lstFuenteProyecto=servicefueteproyecto.listaFuenteProyectoPorProyecto(proyectoss);
		
		double montos = 0;
		for (FuenteProyecto fuentproyec : this.lstFuenteProyecto) {

			montos += fuentproyec.getMonto();
		}
		
		proyectoss.setMontoAprobado(montos);
		serviceproyectos.modificar(proyectoss);
		
		}
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
}

public void seleccionar(Proyecto proyectos) {
	
	
	Faces.setFlashAttribute("proyectos", proyectos);
	
	
}



public List<Proyecto> getLstProyectos() {
	return lstProyectos;
}

public void setLstProyectos(List<Proyecto> lstProyectos) {
	this.lstProyectos = lstProyectos;
}

public Proyecto getProyectos() {
	return proyectos;
}

public void setProyectos(Proyecto proyectos) {
	this.proyectos = proyectos;
}

public FuenteProyecto getFuenteproyecto() {
	return fuenteproyecto;
}

public void setFuenteproyecto(FuenteProyecto fuenteproyecto) {
	this.fuenteproyecto = fuenteproyecto;
}

public List<FuenteProyecto> getLstFuenteProyecto() {
	return lstFuenteProyecto;
}

public void setLstFuenteProyecto(List<FuenteProyecto> lstFuenteProyecto) {
	this.lstFuenteProyecto = lstFuenteProyecto;
}



	
}
