package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IFuenteDAO;
import com.unia.model.Fuente;


@Stateless
public class FuenteDAOImpl implements IFuenteDAO, Serializable {

	@PersistenceContext(unitName = "Proyectos")
	private EntityManager em;

	@Override
	public void registrar(Fuente t) throws Exception {
		em.persist(t);

	}

	@Override
	public void modificar(Fuente t) throws Exception {
		em.merge(t);

	}

	@Override
	public List<Fuente> listar() throws Exception {
		List<Fuente> lista = new ArrayList<>();

		Query q = em.createQuery("FROM Fuente f");
		lista = (List<Fuente>) q.getResultList();

		return lista;
	}

	@Override
	public Fuente listarPorId(Fuente t) throws Exception {
		List<Fuente> lista = new ArrayList<>();

		Query q = em.createQuery("FROM Fuente f where f.idFuente=?1");
		q.setParameter(1, t.getIdFuente());
		lista = (List<Fuente>) q.getResultList();

		Fuente fuente = lista != null && !lista.isEmpty() ? lista.get(0) : new Fuente();

		return fuente;
	}

}
