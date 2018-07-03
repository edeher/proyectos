package com.unia.service;

import java.util.List;

import com.unia.model.FuenteProyecto;
import com.unia.model.Proyecto;

public interface IFuenteProyectoService extends IService<FuenteProyecto>{
	
	List<FuenteProyecto> listaFuenteProyectoPorProyecto(Proyecto p)throws Exception;
}
