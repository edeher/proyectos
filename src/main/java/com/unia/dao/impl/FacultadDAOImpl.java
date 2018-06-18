package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IFacultadDAO;
import com.unia.model.Facultad;

@Stateless
public class FacultadDAOImpl implements IFacultadDAO, Serializable{

	@PersistenceContext(unitName="Proyectos")
	private EntityManager em;
	
	@Override
	public void registrar(Facultad t) throws Exception {
		em.persist(t);
		
	}

	@Override
	public void modificar(Facultad t) throws Exception {
		em.merge(t);
		
	}

	@Override
	public List<Facultad> listar() throws Exception {
		List<Facultad> lista=new ArrayList<>();
		
		Query q=em.createQuery("FROM Facultad f");
		lista=(List<Facultad>)q.getResultList();
		
		return lista;
	}

	@Override
	public Facultad listarPorId(Facultad t) throws Exception {
		List<Facultad> lista=new ArrayList<>();
		
		Query q=em.createQuery("FROM Facultad f where f.idFacultad=?1");
		q.setParameter(1, t.getIdFacultad());
		lista=(List<Facultad>)q.getResultList();
		
		Facultad facultad=lista!=null&&!lista.isEmpty() ? lista.get(0):new Facultad();
		
		return facultad;
	}

}
