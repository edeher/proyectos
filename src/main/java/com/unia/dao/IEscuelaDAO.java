package com.unia.dao;

import java.util.List;

import javax.ejb.Local;

import com.unia.model.Escuela;
import com.unia.model.Facultad;

@Local
public interface IEscuelaDAO extends IDAO<Escuela>{

		List<Escuela> listarPorFacultad(Facultad f)throws Exception;
}
