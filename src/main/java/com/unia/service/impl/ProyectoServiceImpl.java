package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IProyectoDAO;
import com.unia.model.Proyecto;
import com.unia.service.IProyectoService;

@Named
public class ProyectoServiceImpl implements IProyectoService, Serializable{

	@EJB
	private IProyectoDAO dao;
	
	@Override
	public void registrar(Proyecto t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Proyecto t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<Proyecto> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public Proyecto listarPorId(Proyecto t) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPorId(t);
	}

}
