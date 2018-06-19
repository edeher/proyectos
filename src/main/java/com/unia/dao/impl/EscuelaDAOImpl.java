package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IEscuelaDAO;
import com.unia.model.Escuela;
import com.unia.model.Facultad;

@Stateless
public class EscuelaDAOImpl implements IEscuelaDAO, Serializable{

	@PersistenceContext(unitName="Proyectos")
	private EntityManager em;
	
	@Override
	public void registrar(Escuela t) throws Exception {
		em.persist(t);
		
	}

	@Override
	public void modificar(Escuela t) throws Exception {
		em.merge(t);
		
	}

	@Override
	public List<Escuela> listar() throws Exception {
		List<Escuela> lista=new ArrayList<>();
		
		Query q=em.createQuery("FROM Escuela e");
		lista=(List<Escuela>)q.getResultList();
		
		return lista;
	}

	@Override
	public Escuela listarPorId(Escuela t) throws Exception {
		List<Escuela> lista=new ArrayList<>();
		
		Query q=em.createQuery("FROM Escuela e where e.idEscuela=?1");
		q.setParameter(1, t.getIdEscuela());
		lista=(List<Escuela>)q.getResultList();
		
		Escuela escuela=lista!=null&&!lista.isEmpty() ? lista.get(0):new Escuela();
		
		return escuela;
	}

	@Override
	public List<Escuela> listarPorFacultad(Facultad f) throws Exception {
			List<Escuela> lista=null;
		
		Query q= em.createQuery("FROM Escuela e where e.facultad.idFacultad=?1");
		q.setParameter(1, f.getIdFacultad());
		
		lista=(List<Escuela>)q.getResultList();
		
				
		return lista;
	}

}
