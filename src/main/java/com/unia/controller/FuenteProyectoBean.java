package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.model.Fuente;
import com.unia.model.FuenteProyecto;
import com.unia.model.Proyecto;
import com.unia.service.IFuenteProyectoService;
import com.unia.service.IFuenteService;
import com.unia.service.IProyectoService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class FuenteProyectoBean implements Serializable {

	@Inject
	private FuenteProyecto fuenteproyecto;
	@Inject
	private Proyecto proyecto;
	@Inject
	private Fuente fuente;
	@Inject
	private IFuenteProyectoService servicefuenteproyecto;
	@Inject
	private IProyectoService serviceproyecto;
	@Inject
	private IFuenteService servicefuente;

	private List<FuenteProyecto> lstFuenteProyecto;
	private List<Proyecto> lstProyecto;
	private List<Fuente> lstFuente;

	private String titulo;

	@PostConstruct
	public void init() {
		lstFuenteProyecto = new ArrayList<>();
		lstProyecto = new ArrayList<>();
		lstFuente = new ArrayList<>();
		this.listarFuenteProyecto();
		this.listarProyecto();
		this.listarFuente();

	}
	public void limpiarControles() {
		this.titulo="Nuevo";
		this.lstProyecto.clear();
		this.lstProyecto=new ArrayList<>();
		this.listarProyecto();
		this.lstFuente.clear();
		this.lstFuente=new ArrayList<>();
		this.listarFuente();
		this.fuenteproyecto.setMonto((short)0);
	}

	public void operar() {
		try {
			if (fuenteproyecto.getIdFuenteProyecto() > 0) {
				fuenteproyecto.setProyecto(proyecto);
				fuenteproyecto.setFuente(fuente);
				servicefuenteproyecto.modificar(fuenteproyecto);
				MensajeManager.mostrarMensaje("Aviso", "Modificación Exitosa", "INFO");
			} else {
				fuenteproyecto.setProyecto(proyecto);
				fuenteproyecto.setFuente(fuente);
				servicefuenteproyecto.registrar(fuenteproyecto);
				MensajeManager.mostrarMensaje("Aviso", "Registro Exitoso", "INFO");
			}

		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}

	}

	public void seleccionar(FuenteProyecto t) {
		try {
			this.fuenteproyecto=servicefuenteproyecto.listarPorId(t);
			this.proyecto=fuenteproyecto.getProyecto();
			this.fuente=fuenteproyecto.getFuente();
			

		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}finally {
			this.titulo="Modificar";
		}
	}

	public void listarFuenteProyecto() {
		try {
			lstFuenteProyecto = servicefuenteproyecto.listar();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}

	public void listarProyecto() {
		try {
			lstProyecto = serviceproyecto.listar();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}

	public void listarFuente() {
		try {
			lstFuente = servicefuente.listar();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}

	public FuenteProyecto getFuenteproyecto() {
		return fuenteproyecto;
	}

	public void setFuenteproyecto(FuenteProyecto fuenteproyecto) {
		this.fuenteproyecto = fuenteproyecto;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Fuente getFuente() {
		return fuente;
	}

	public void setFuente(Fuente fuente) {
		this.fuente = fuente;
	}

	public List<FuenteProyecto> getLstFuenteProyecto() {
		return lstFuenteProyecto;
	}

	public void setLstFuenteProyecto(List<FuenteProyecto> lstFuenteProyecto) {
		this.lstFuenteProyecto = lstFuenteProyecto;
	}

	public List<Proyecto> getLstProyecto() {
		return lstProyecto;
	}

	public void setLstProyecto(List<Proyecto> lstProyecto) {
		this.lstProyecto = lstProyecto;
	}

	public List<Fuente> getLstFuente() {
		return lstFuente;
	}

	public void setLstFuente(List<Fuente> lstFuente) {
		this.lstFuente = lstFuente;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
