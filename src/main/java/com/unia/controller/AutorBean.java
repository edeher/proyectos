package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.model.Autor;
import com.unia.service.IAutorService;

@Named
@ViewScoped
public class AutorBean implements Serializable{
	
	@Inject
	private Autor autor;
	@Inject 
	private IAutorService serviceautor;
	
	private List<Autor> lstAutor;
	
	@PostConstruct
	public void init() {
		lstAutor= new ArrayList<>();
		this.listarautor();
		
	}
	public void listarautor() {
		try {
			lstAutor= serviceautor.listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void selecionar(Autor t) {
		try {
			this.autor=serviceautor.listarPorId(t);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void operar() {
		try {
			
			if(autor.getIdAutor()>0){
				serviceautor.modificar(autor);
			}else {
				serviceautor.registrar(autor);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public List<Autor> getLstAutor() {
		return lstAutor;
	}
	public void setLstAutor(List<Autor> lstAutor) {
		this.lstAutor = lstAutor;
	}
	
	
	
	

}
