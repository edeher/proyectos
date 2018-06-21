package com.unia.service;

import java.util.List;

import com.unia.model.Actividad;
import com.unia.model.Componente;

public interface IActividadService extends IService<Actividad>{
	List<Actividad> listarPorComponente(Componente c)throws Exception;
}
