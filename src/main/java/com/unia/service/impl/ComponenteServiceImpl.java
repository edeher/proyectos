package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IComponenteDAO;
import com.unia.model.Componente;
import com.unia.service.IComponenteService;

@Named
public class ComponenteServiceImpl implements IComponenteService, Serializable{

	@EJB
	private IComponenteDAO dao;
	
	@Override
	public void registrar(Componente t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Componente t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<Componente> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public Componente listarPorId(Componente t) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPorId(t);
	}

}
