package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IComponenteDAO;

import com.unia.model.Componente;

@Stateless
public class ComponenteDAOImpl implements IComponenteDAO,Serializable {

	@PersistenceContext(unitName="Proyectos")
	private EntityManager em;
	
	@Override
	public void registrar(Componente t) throws Exception {
		em.persist(t);
		
	}

	@Override
	public void modificar(Componente t) throws Exception {
		em.merge(t);
		
	}

	@Override
	public List<Componente> listar() throws Exception {
		List<Componente> lista=new ArrayList<>();
		
		Query q=em.createQuery("FROM Componente c");
		lista=(List<Componente>)q.getResultList();
		
		return lista;
	}

	@Override
	public Componente listarPorId(Componente t) throws Exception {
		List<Componente> lista=new ArrayList<>();
		
		Query q=em.createQuery("FROM Componente c where c.idComponente=?1");
		q.setParameter(1, t.getIdComponente() );
		lista=(List<Componente>)q.getResultList();
		
		Componente componente=lista!=null&&!lista.isEmpty() ? lista.get(0):new Componente();
		
		return componente;
	}

}
