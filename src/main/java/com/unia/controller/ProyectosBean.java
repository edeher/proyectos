package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import com.unia.model.Proyecto;
import com.unia.service.IProyectoService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class ProyectosBean implements Serializable{
	
@Inject
private IProyectoService serviceproyectos;

private List<Proyecto> lstProyectos;


@PostConstruct
public void init() {
	lstProyectos= new ArrayList<>();
	this.listarproyectos();
	
}

public void listarproyectos() {
	
	try {
		lstProyectos= serviceproyectos.listar();
	} catch (Exception e) {
		MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
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



	
}
