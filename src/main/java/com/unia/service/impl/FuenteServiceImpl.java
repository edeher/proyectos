package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IFuenteDAO;
import com.unia.model.Fuente;
import com.unia.service.IFuenteService;

@Named
public class FuenteServiceImpl implements IFuenteService, Serializable{

	@EJB
	private IFuenteDAO dao;
	
	@Override
	public void registrar(Fuente t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Fuente t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<Fuente> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public Fuente listarPorId(Fuente t) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPorId(t);
	}

}
