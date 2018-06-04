package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IAutorDAO;
import com.unia.model.Autor;
import com.unia.service.IAutorService;

@Named
public class AutorServiceImpl implements IAutorService, Serializable{

	@EJB
	private IAutorDAO dao;
	
	
	@Override
	public void registrar(Autor t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Autor t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<Autor> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public Autor listarPorId(Autor t) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPorId(t);
	}

}
