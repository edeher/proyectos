package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IEscuelaDAO;
import com.unia.model.Escuela;
import com.unia.service.IEscuelaService;

@Named
public class EscuelaServiceImpl implements IEscuelaService, Serializable {
	
	@EJB
	private IEscuelaDAO dao;
	
	@Override
	public void registrar(Escuela t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Escuela t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<Escuela> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public Escuela listarPorId(Escuela t) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPorId(t);
	}

}
