package com.unia.dao;

import java.util.List;

import javax.ejb.Local;

import com.unia.model.FuenteProyecto;
import com.unia.model.Proyecto;

@Local
public interface IFuenteProyectoDAO extends IDAO<FuenteProyecto> {
	
	List<FuenteProyecto> listaFuenteProyectoPorProyecto(Proyecto p)throws Exception;
}
