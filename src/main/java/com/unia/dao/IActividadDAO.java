package com.unia.dao;

import java.util.List;

import javax.ejb.Local;

import com.unia.model.Actividad;
import com.unia.model.Componente;

@Local
public interface IActividadDAO extends IDAO<Actividad>{
	List<Actividad> listarPorComponente(Componente c)throws Exception;
}
