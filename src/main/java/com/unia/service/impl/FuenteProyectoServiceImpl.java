package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IActividadDAO;
import com.unia.dao.IFuenteProyectoDAO;
import com.unia.model.FuenteProyecto;
import com.unia.model.Proyecto;
import com.unia.service.IFuenteProyectoService;

@Named
public class FuenteProyectoServiceImpl implements IFuenteProyectoService, Serializable {

	@EJB
	private IFuenteProyectoDAO dao;
	
	@Override
	public void registrar(FuenteProyecto t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(FuenteProyecto t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<FuenteProyecto> listar() throws Exception {
		
		return dao.listar();
	}

	@Override
	public FuenteProyecto listarPorId(FuenteProyecto t) throws Exception {
	
		return dao.listarPorId(t);
	}

	@Override
	public List<FuenteProyecto> listaFuenteProyectoPorProyecto(Proyecto p) throws Exception {
		
		return dao.listaFuenteProyectoPorProyecto(p);
	}

}
