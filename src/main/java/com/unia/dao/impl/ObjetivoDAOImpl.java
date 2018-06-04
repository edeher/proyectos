package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IObjetivoDAO;
import com.unia.model.Autor;
import com.unia.model.Componente;
import com.unia.model.Objetivo;

@Stateless
public class ObjetivoDAOImpl implements IObjetivoDAO, Serializable{

	@PersistenceContext(unitName="Proyectos")
	private EntityManager em;
	
	@Override
	public void registrar(Objetivo t) throws Exception {
		em.persist(t);
		
	}

	@Override
	public void modificar(Objetivo t) throws Exception {
		em.merge(t);
		
	}

	@Override
	public List<Objetivo> listar() throws Exception {
		List<Objetivo> lista=new ArrayList<>();
		
		Query q=em.createQuery("FROM Objetivo o");
		lista=(List<Objetivo>)q.getResultList();
		
		return lista;
	}

	@Override
	public Objetivo listarPorId(Objetivo t) throws Exception {
		List<Objetivo> lista=new ArrayList<>();
		
		Query q=em.createQuery("FROM Objetivo o where o.idObjetivo=?1");
		q.setParameter(1, t.getIdObjetivo() );
		lista=(List<Objetivo>)q.getResultList();
		
		Objetivo objetivo=lista!=null&&!lista.isEmpty() ? lista.get(0):new Objetivo();
		
		return objetivo;
	}

}
