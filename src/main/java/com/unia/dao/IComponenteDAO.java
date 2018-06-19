package com.unia.dao;

import java.util.List;

import javax.ejb.Local;

import com.unia.model.Componente;
import com.unia.model.Objetivo;

@Local
public interface IComponenteDAO extends IDAO<Componente>{
	List<Componente> listarPorObjetivo(Objetivo o)throws Exception;
}
