package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import com.unia.model.Actividad;
import com.unia.model.Componente;
import com.unia.model.Objetivo;
import com.unia.model.Proyecto;
import com.unia.service.IActividadService;
import com.unia.service.IComponenteService;
import com.unia.service.IObjetivoService;
import com.unia.service.IProyectoService;

@Named
@ViewScoped
public class TreeTableBean implements Serializable{

	@Inject
	private Proyecto proyectos;
	@Inject
	private Objetivo objetivos;
	@Inject
	private Componente componentes;
	@Inject
	private Actividad actividads;
	
	@Inject
	private IProyectoService serviceproyectos;
	@Inject
	private IObjetivoService serviceobjetivos;
	@Inject
	private IComponenteService servicecomponentes;
	@Inject
	private IActividadService serviceactividades;
	
	
	private List<Objetivo> lstObjetivos;
	private List<Componente> lstComponentes;
	private List<Actividad> lstActividades;
	
	@PostConstruct
	public void init() {
		
		
		lstComponentes= new ArrayList<>();
		lstActividades= new ArrayList<>();
		
		
		Proyecto pro=Faces.getFlashAttribute("proyectos");
		
		if(pro!=null) {
			lstObjetivos= new ArrayList<>();
			this.leer(pro);
			
		}
	}
	public void leer(Proyecto p) {
		
		try {
			
			this.proyectos=serviceproyectos.listarPorId(p);
			this.lstObjetivos=this.proyectos.getObjetivos();
			
				
			
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
