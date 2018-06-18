package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IFacultadDAO;
import com.unia.model.Facultad;
import com.unia.service.IFacultadService;

@Named
public class FacultadServiceImpl implements IFacultadService, Serializable{

	@EJB
	private IFacultadDAO dao;
	
	@Override
	public void registrar(Facultad t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Facultad t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<Facultad> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public Facultad listarPorId(Facultad t) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPorId(t);
	}

}
