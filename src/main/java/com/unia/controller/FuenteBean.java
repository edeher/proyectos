package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.model.Fuente;
import com.unia.service.IFuenteService;

@Named
@ViewScoped
public class FuenteBean implements Serializable{
	
	@Inject
	private Fuente fuente;
	@Inject 
	private IFuenteService servicefuente;
	
	private List<Fuente> lstFuente;
	
	@PostConstruct
	public void init() {
		
		lstFuente= new ArrayList<>();
		this.listarfuente();
	}
	public void listarfuente() {
		try {
			lstFuente= servicefuente.listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void seleccionar(Fuente t) {
		try {
			this.fuente=servicefuente.listarPorId(t);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void operar () {
		try {
			if(fuente.getIdFuente()>0) {
				servicefuente.modificar(fuente);
			}else {
				servicefuente.registrar(fuente);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Fuente getFuente() {
		return fuente;
	}

	public void setFuente(Fuente fuente) {
		this.fuente = fuente;
	}
	public List<Fuente> getLstFuente() {
		return lstFuente;
	}
	public void setLstFuente(List<Fuente> lstFuente) {
		this.lstFuente = lstFuente;
	}
	
	
	

}
