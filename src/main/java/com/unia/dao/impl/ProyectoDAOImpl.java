package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IProyectoDAO;

import com.unia.model.Proyecto;

@Stateless
public class ProyectoDAOImpl implements IProyectoDAO, Serializable{

	@PersistenceContext(unitName="Proyectos")
	private EntityManager em;	
	
	@Override
	public void registrar(Proyecto t) throws Exception {
		em.persist(t);
		
	}

	@Override
	public void modificar(Proyecto t) throws Exception {
		em.merge(t);
		
	}

	@Override
	public List<Proyecto> listar() throws Exception {
		List<Proyecto> lista=new ArrayList<>();
		
		Query q=em.createQuery("FROM Proyecto p");
		lista=(List<Proyecto>)q.getResultList();
		
		return lista;
	}

	@Override
	public Proyecto listarPorId(Proyecto t) throws Exception {
     List<Proyecto> lista=new ArrayList<>();
		
		Query q=em.createQuery("FROM Proyecto p where p.idProyecto=?1");
		q.setParameter(1, t.getIdProyecto() );
		lista=(List<Proyecto>)q.getResultList();
		
		Proyecto proyecto=lista!=null&&!lista.isEmpty() ? lista.get(0):new Proyecto();
		
		return proyecto;
	}

}
