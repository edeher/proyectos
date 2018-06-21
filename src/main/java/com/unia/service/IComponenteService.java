package com.unia.service;

import java.util.List;

import com.unia.model.Componente;
import com.unia.model.Objetivo;

public interface IComponenteService extends IService<Componente> {
	List<Componente> listarPorObjetivo(Objetivo o)throws Exception;
}
