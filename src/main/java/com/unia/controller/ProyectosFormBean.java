package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.unia.model.Actividad;
import com.unia.model.Componente;
import com.unia.model.Fuente;
import com.unia.model.FuenteProyecto;
import com.unia.model.Objetivo;
import com.unia.model.Proyecto;
import com.unia.service.IActividadService;
import com.unia.service.IComponenteService;
import com.unia.service.IFuenteProyectoService;
import com.unia.service.IFuenteService;
import com.unia.service.IObjetivoService;
import com.unia.service.IProyectoService;
import com.unia.util.MensajeManager;

@Named
@ViewScoped
public class ProyectosFormBean implements Serializable {

	@Inject
	private Proyecto proyectos;
	@Inject
	private Objetivo objetivos;
	@Inject
	private Componente componentes;
	@Inject
	private Actividad actividads;
	@Inject
	private Fuente fuente;
	@Inject
	private FuenteProyecto fuenteproyecto;

	@Inject
	private IProyectoService serviceproyectos;
	
	@Inject
	private IComponenteService servicecomponentes;
	@Inject
	private IActividadService serviceactividades;
	@Inject
	private IFuenteProyectoService servicefueteproyecto;
	@Inject
	private IFuenteService servicefuente;

	private TreeNode raiz;
	private List<Objetivo> lstObjetivos;
	private List<Componente> lstComponentes;
	private List<Actividad> lstActividades;
	private List<Fuente> lstFuente;
	private List<FuenteProyecto> lstFuenteProyecto;
	
	private String titulo;
	
	@PostConstruct
	public void init() {

		lstComponentes = new ArrayList<>();
		lstActividades = new ArrayList<>();
		lstFuente = new ArrayList<>();

		this.listarcomponentes();
		this.listaractividades();
		this.listarFuentes();

		Proyecto pro = Faces.getFlashAttribute("proyectos");

		if (pro != null) {
			lstObjetivos = new ArrayList<>();
			
			this.leer(pro);
			this.listarFuentesProyectos(pro);
			
			this.actualizarmonto();
		}
	}
public void limpiarControles() {
	
	this.titulo="Nuevo";
}


public void operar() {

	}
	public void operarFuente() {
		

		
		try {
			if(fuenteproyecto.getIdFuenteProyecto()>0) {
				fuenteproyecto.setProyecto(proyectos);
				fuenteproyecto.setFuente(fuente);
				servicefueteproyecto.modificar(fuenteproyecto);
				MensajeManager.mostrarMensaje("Aviso", "Modificación Exitosa", "INFO");
				
			}else {
				fuenteproyecto.setProyecto(proyectos);
				fuenteproyecto.setFuente(fuente);
				servicefueteproyecto.registrar(fuenteproyecto);
				MensajeManager.mostrarMensaje("Aviso", "Registro Exitoso", "INFO");
			}
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}
		
	}

	public void seleccionarFuente(FuenteProyecto fuen) {
		try {
			
			this.fuenteproyecto=servicefueteproyecto.listarPorId(fuen);
			
			this.proyectos=fuenteproyecto.getProyecto();
			this.fuente=fuenteproyecto.getFuente();
			
			
		} catch (Exception e) {
			MensajeManager.mostrarMensaje("Aviso", e.getMessage(), "FATAL");
		}finally {
			this.titulo="Modificar";
		}
		
	}
	
	public void leer(Proyecto p) {

		try {
			
			this.proyectos = serviceproyectos.listarPorId(p);
			this.lstObjetivos = this.proyectos.getObjetivos();
			List<Objetivo> objetivosRaizes = this.lstObjetivos;

			this.raiz = new DefaultTreeNode("raiz", null);

			for (Objetivo objetivoss : objetivosRaizes) {

				TreeNode no0 = new DefaultTreeNode(objetivoss, raiz);

				this.lstComponentes = servicecomponentes.listarPorObjetivo(objetivoss);
				List<Componente> ComponentesRaizes = this.lstComponentes;

				for (Componente componentes : ComponentesRaizes) {

					TreeNode no1 = new DefaultTreeNode(componentes, no0);

					this.lstActividades = serviceactividades.listarPorComponente(componentes);
					List<Actividad> ActividadesRaizes = this.lstActividades;

					for (Actividad actividades : ActividadesRaizes) {

						TreeNode no2 = new DefaultTreeNode(actividades, no1);
					}

				}
			}

			

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void listarcomponentes() {
		try {
			lstComponentes = servicecomponentes.listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void listaractividades() {
		try {
			lstActividades = serviceactividades.listar();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void listarFuentes() {
		try {
			lstFuente = servicefuente.listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void listarFuentesProyectos(Proyecto p) {
		try {

			lstFuenteProyecto = servicefueteproyecto.listaFuenteProyectoPorProyecto(p);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void actualizarmonto() {

		try {
			double montos = 0;
			for (FuenteProyecto fuentproyec : this.lstFuenteProyecto) {

				montos += fuentproyec.getMonto();
			}
		
			this.proyectos.setMontoAprobado(montos);
			serviceproyectos.modificar(proyectos);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	public Proyecto getProyectos() {
		return proyectos;
	}

	public void setProyectos(Proyecto proyectos) {
		this.proyectos = proyectos;
	}

	public Objetivo getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(Objetivo objetivos) {
		this.objetivos = objetivos;
	}

	public Componente getComponentes() {
		return componentes;
	}

	public void setComponentes(Componente componentes) {
		this.componentes = componentes;
	}

	public Actividad getActividads() {
		return actividads;
	}

	public void setActividads(Actividad actividads) {
		this.actividads = actividads;
	}

	public List<Objetivo> getLstObjetivos() {
		return lstObjetivos;
	}

	public void setLstObjetivos(List<Objetivo> lstObjetivos) {
		this.lstObjetivos = lstObjetivos;
	}

	public List<Componente> getLstComponentes() {
		return lstComponentes;
	}

	public void setLstComponentes(List<Componente> lstComponentes) {
		this.lstComponentes = lstComponentes;
	}

	public List<Actividad> getLstActividades() {
		return lstActividades;
	}

	public void setLstActividades(List<Actividad> lstActividades) {
		this.lstActividades = lstActividades;
	}

	public TreeNode getRaiz() {
		return raiz;
	}

	public void setRaiz(TreeNode raiz) {
		this.raiz = raiz;
	}

	public Fuente getFuente() {
		return fuente;
	}

	public void setFuente(Fuente fuente) {
		this.fuente = fuente;
	}

	public FuenteProyecto getFuenteproyecto() {
		return fuenteproyecto;
	}

	public void setFuenteproyecto(FuenteProyecto fuenteproyecto) {
		this.fuenteproyecto = fuenteproyecto;
	}

	public List<Fuente> getLstFuente() {
		return lstFuente;
	}

	public void setLstFuente(List<Fuente> lstFuente) {
		this.lstFuente = lstFuente;
	}

	public List<FuenteProyecto> getLstFuenteProyecto() {
		return lstFuenteProyecto;
	}

	public void setLstFuenteProyecto(List<FuenteProyecto> lstFuenteProyecto) {
		this.lstFuenteProyecto = lstFuenteProyecto;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
