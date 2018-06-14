package com.unia.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.model.Proyecto;
import com.unia.service.IProyectoService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class ProyectoBean implements Serializable {
	@Inject
	private Proyecto proyecto;
	@Inject
	private IProyectoService serviceProyecto;
	private List<Proyecto> lstProyecto;
	private Date fechaSelecionada1;
	private Date fechaSelecionada2;
	@PostConstruct
	public void init() {
		lstProyecto=new ArrayList<>();
		this.listar();
		
	}
	
	public void listar() {
		try {
			lstProyecto=serviceProyecto.listar();
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	public void operar() {
		try {
			
//			Calendar cal1= Calendar.getInstance();
//			cal1.setTime(fechaSelecionada1);
//			Calendar cal2= Calendar.getInstance();
//			cal2.setTime(fechaSelecionada2);
//			
//			LocalDate localdate1=LocalDate.of(cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH), cal1.get(Calendar.DATE));
//			LocalDate localdate2=LocalDate.of(cal2.get(Calendar.YEAR), cal2.get(Calendar.MONTH), cal2.get(Calendar.DATE));
//			
//			proyecto.setFechaPresentacion(localdate1);
//			proyecto.setFechaInicio(localdate2);
			
			if(proyecto.getIdProyecto()>0) {
				serviceProyecto.modificar(proyecto);
				MensajeManager.mostrarMensaje("Aviso", "MOdificación Exitosa", "INFO");
			}else {
				serviceProyecto.registrar(proyecto);
				MensajeManager.mostrarMensaje("Aviso", "Registro Exitoso", "INFO");
			}
			
			
			
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}
	public void selecionar(Proyecto t) {
		try {
			this.proyecto=serviceProyecto.listarPorId(t);
//			Calendar cal1= Calendar.getInstance();
//			Calendar cal2= Calendar.getInstance();
//			cal1.set(proyecto.getFechaPresentacion().getYear(),proyecto.getFechaPresentacion().getMonthValue(),proyecto.getFechaPresentacion().getDayOfMonth() );
//			cal2.set(proyecto.getFechaInicio().getYear(),proyecto.getFechaInicio().getMonthValue(),proyecto.getFechaInicio().getDayOfMonth() );
//			
//			this.fechaSelecionada1=cal1.getTime();
//			this.fechaSelecionada2=cal2.getTime();
			
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public List<Proyecto> getLstProyecto() {
		return lstProyecto;
	}

	public void setLstProyecto(List<Proyecto> lstProyecto) {
		this.lstProyecto = lstProyecto;
	}

	public Date getFechaSelecionada1() {
		return fechaSelecionada1;
	}

	public void setFechaSelecionada1(Date fechaSelecionada1) {
		this.fechaSelecionada1 = fechaSelecionada1;
	}

	public Date getFechaSelecionada2() {
		return fechaSelecionada2;
	}

	public void setFechaSelecionada2(Date fechaSelecionada2) {
		this.fechaSelecionada2 = fechaSelecionada2;
	}

	
	
	
}
