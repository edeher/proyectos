package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
public class ProyectosFormBean implements Serializable{
	
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
	
	private List<Proyecto > lstProyectos;;
	private List<Objetivo> lstObjetivos;
	private List<Componente> lstComponentes;
	private List<Actividad> lstActividades;
	
	
	public void init() {
		lstProyectos= new ArrayList<>();
		lstObjetivos= new ArrayList<>();
		lstComponentes= new ArrayList<>();
		lstActividades= new ArrayList<>();
		this.listarproyectos();
		this.listarobjetivos();
		this.listarcomponentes();
		this.listaractividades();
		
		Proyecto pro=Faces.getFlashAttribute("proyectos");
		
		if(pro!=null) {
			this.leer(pro);
		}
	}
	
	public void leer(Proyecto p) {
		
		try {
			proyectos=serviceproyectos.listarPorId(p);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void listarproyectos() {
		try {
			lstProyectos=serviceproyectos.listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void listarobjetivos() {
		try {
			lstObjetivos=serviceobjetivos.listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void listarcomponentes() {
		try {
			lstComponentes=servicecomponentes.listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void listaractividades() {
		try {
			lstActividades=serviceactividades.listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	public Proyecto getProyectos() {
		return proyectos;
	}
	public void setProyectos(Proyecto proyectos) {
		this.proyectos = proyectos;
	}
	public Objetivo getObjetivos() {
		return objetivos;
	}
	public void setObjetivos(Objetivo objetivos) {
		this.objetivos = objetivos;
	}
	public Componente getComponentes() {
		return componentes;
	}
	public void setComponentes(Componente componentes) {
		this.componentes = componentes;
	}
	public Actividad getActividads() {
		return actividads;
	}
	public void setActividads(Actividad actividads) {
		this.actividads = actividads;
	}
	public List<Proyecto> getLstProyectos() {
		return lstProyectos;
	}
	public void setLstProyectos(List<Proyecto> lstProyectos) {
		this.lstProyectos = lstProyectos;
	}
	public List<Objetivo> getLstObjetivos() {
		return lstObjetivos;
	}
	public void setLstObjetivos(List<Objetivo> lstObjetivos) {
		this.lstObjetivos = lstObjetivos;
	}
	public List<Componente> getLstComponentes() {
		return lstComponentes;
	}
	public void setLstComponentes(List<Componente> lstComponentes) {
		this.lstComponentes = lstComponentes;
	}
	public List<Actividad> getLstActividades() {
		return lstActividades;
	}
	public void setLstActividades(List<Actividad> lstActividades) {
		this.lstActividades = lstActividades;
	}
	
	
	

}
