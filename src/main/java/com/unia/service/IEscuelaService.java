package com.unia.service;

import java.util.List;

import com.unia.model.Escuela;
import com.unia.model.Facultad;

public interface IEscuelaService extends IService<Escuela>{
	
	List<Escuela> listarPorFacultad(Facultad f)throws Exception;
}
