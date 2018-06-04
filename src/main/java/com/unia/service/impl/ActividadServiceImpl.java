package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IActividadDAO;
import com.unia.model.Actividad;
import com.unia.service.IActividadService;

@Named
public class ActividadServiceImpl implements IActividadService,Serializable{
	
	@EJB
	private IActividadDAO dao;
	
	@Override
	public void registrar(Actividad t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Actividad t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<Actividad> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public Actividad listarPorId(Actividad t) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPorId(t);
	}

}
