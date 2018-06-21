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
import com.unia.model.Objetivo;
import com.unia.model.Proyecto;
import com.unia.service.IActividadService;
import com.unia.service.IComponenteService;
import com.unia.service.IObjetivoService;
import com.unia.service.IProyectoService;

@Named
@ViewScoped
public class TreeTableBean implements Serializable {

	@Inject
	private Proyecto proyectos;
	@Inject
	private Objetivo objetivos;
	@Inject
	private Componente componentes;
	@Inject
	private Actividad actividads;

	@Inject
	private IProyectoService serviceproyectos;
	@Inject
	private IObjetivoService serviceobjetivos;
	@Inject
	private IComponenteService servicecomponentes;
	@Inject
	private IActividadService serviceactividades;

	private TreeNode raiz;
	private TreeNode subraiz1;
	private TreeNode subraiz2;
	private List<Objetivo> lstObjetivos;
	private List<Componente> lstComponentes;
	private List<Actividad> lstActividades;

	@PostConstruct
	public void init() {

		lstComponentes = new ArrayList<>();
		lstActividades = new ArrayList<>();

		Proyecto pro = Faces.getFlashAttribute("proyectos");

		if (pro != null) {
			lstObjetivos = new ArrayList<>();
			this.leer(pro);

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
					
					this.lstActividades=serviceactividades.listarPorComponente(componentes);
					List<Actividad> ActividadesRaizes=this.lstActividades;
					
					for(Actividad actividades : ActividadesRaizes) {
						
						TreeNode no2=new DefaultTreeNode(actividades,no1);
					}

				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void adicionarNos() {
		try {

			this.lstComponentes = servicecomponentes.listar();
			List<Componente> ComponentesRaizes = this.lstComponentes;

			this.subraiz1 = new DefaultTreeNode("subraiz1", this.raiz);
			for (Componente componentes : ComponentesRaizes) {

				TreeNode no1 = new DefaultTreeNode(componentes, subraiz1);

			}

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

	public TreeNode getRaiz() {
		return raiz;
	}

	public void setRaiz(TreeNode raiz) {
		this.raiz = raiz;
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

	public TreeNode getSubraiz1() {
		return subraiz1;
	}

	public void setSubraiz1(TreeNode subraiz1) {
		this.subraiz1 = subraiz1;
	}

	public TreeNode getSubraiz2() {
		return subraiz2;
	}

	public void setSubraiz2(TreeNode subraiz2) {
		this.subraiz2 = subraiz2;
	}

}
