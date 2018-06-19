package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IActividadDAO;
import com.unia.model.Actividad;
import com.unia.model.Componente;
import com.unia.model.Escuela;

@Stateless
public class ActividaDAOImpl implements IActividadDAO, Serializable{

		@PersistenceContext(unitName="Proyectos")
		private EntityManager em;

		@Override
		public void registrar(Actividad t) throws Exception {
			em.persist(t);
			
		}

		@Override
		public void modificar(Actividad t) throws Exception {
			em.merge(t);
			
		}

		@Override
		public List<Actividad> listar() throws Exception {
			List<Actividad> lista=new ArrayList<>();
			
			Query q=em.createQuery("FROM Actividad a");
			lista=(List<Actividad>)q.getResultList();
			
			return lista;
		}

		@Override
		public Actividad listarPorId(Actividad t) throws Exception {
			List<Actividad> lista=new ArrayList<>();
			
			Query q=em.createQuery("FROM Actividad a where a.idActividad=?1");
			q.setParameter(1, t.getIdActividad() );
			lista=(List<Actividad>)q.getResultList();
			
			Actividad actividad=lista!=null&&!lista.isEmpty() ? lista.get(0):new Actividad();
			
			return actividad;
		}

		@Override
		public List<Actividad> listarPorComponente(Componente c) throws Exception {
			List<Actividad> lista=null;
			
			Query q= em.createQuery("FROM Actividad a where a.componente.idComponente=?1");
			q.setParameter(1, c.getIdComponente());
			
			lista=(List<Actividad>)q.getResultList();
			
					
			return lista;
		}
}
