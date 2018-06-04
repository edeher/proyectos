package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IAutorDAO;
import com.unia.model.Actividad;
import com.unia.model.Autor;

@Stateless
public class AutorDAOImpl implements IAutorDAO, Serializable{
	
	@PersistenceContext(unitName="Proyectos")
	private EntityManager em;
	
	@Override
	public void registrar(Autor t) throws Exception {
		em.persist(t);
		
	}

	@Override
	public void modificar(Autor t) throws Exception {
		em.merge(t);
		
	}

	@Override
	public List<Autor> listar() throws Exception {
		List<Autor> lista=new ArrayList<>();
		
		Query q=em.createQuery("FROM Autor a");
		lista=(List<Autor>)q.getResultList();
		
		return lista;
	}

	@Override
	public Autor listarPorId(Autor t) throws Exception {
		List<Autor> lista=new ArrayList<>();
		
		Query q=em.createQuery("FROM Autor a where a.idAutor=?1");
		q.setParameter(1, t.getIdAutor() );
		lista=(List<Autor>)q.getResultList();
		
		Autor autor=lista!=null&&!lista.isEmpty() ? lista.get(0):new Autor();
		
		return autor;
	}

}
