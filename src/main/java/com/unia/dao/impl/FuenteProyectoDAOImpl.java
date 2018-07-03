package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IFuenteProyectoDAO;
import com.unia.model.FuenteProyecto;
import com.unia.model.Proyecto;

@Stateless
public class FuenteProyectoDAOImpl implements IFuenteProyectoDAO, Serializable{

	
	@PersistenceContext(unitName = "Proyectos")
	private EntityManager em;
	
	@Override
	public void registrar(FuenteProyecto t) throws Exception {
		em.persist(t);
		
	}

	@Override
	public void modificar(FuenteProyecto t) throws Exception {
		em.merge(t);
		
	}

	@Override
	public List<FuenteProyecto> listar() throws Exception {
		List<FuenteProyecto> lista = new ArrayList<>();

		Query q = em.createQuery("FROM FuenteProyecto f");
		lista = (List<FuenteProyecto>) q.getResultList();

		return lista;
	}

	@Override
	public FuenteProyecto listarPorId(FuenteProyecto t) throws Exception {
		List<FuenteProyecto> lista = new ArrayList<>();

		Query q = em.createQuery("FROM FuenteProyecto f where f.idFuenteProyecto=?1");
		q.setParameter(1, t.getIdFuenteProyecto());
		lista = (List<FuenteProyecto>) q.getResultList();

		FuenteProyecto fuenteproyecto = lista != null && !lista.isEmpty() ? lista.get(0) : new FuenteProyecto();

		return fuenteproyecto;
	}

	@Override
	public List<FuenteProyecto> listaFuenteProyectoPorProyecto(Proyecto p) throws Exception {
		List<FuenteProyecto> lista = null;

		Query q = em.createQuery("FROM FuenteProyecto f where f.proyecto.idProyecto=?1");
		q.setParameter(1, p.getIdProyecto());

		lista = (List<FuenteProyecto>) q.getResultList();

		return lista;
	}

}
