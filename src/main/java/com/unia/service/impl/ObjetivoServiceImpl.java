package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IObjetivoDAO;
import com.unia.model.Objetivo;
import com.unia.service.IObjetivoService;

@Named
public class ObjetivoServiceImpl implements IObjetivoService, Serializable{

	@EJB
	private IObjetivoDAO dao;
	
	@Override
	public void registrar(Objetivo t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Objetivo t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<Objetivo> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public Objetivo listarPorId(Objetivo t) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPorId(t);
	}

}
