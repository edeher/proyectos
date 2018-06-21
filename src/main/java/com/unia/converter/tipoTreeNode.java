package com.unia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("tipoTreeNode")
public class tipoTreeNode implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
			String tipo="";
		
		if(value!=null) {
			tipo=String.valueOf(value);
			
			switch(tipo) {
			case "ob":
				tipo="->Objetivo";
				break;
			case "co":
				tipo="-->Componente";
				break;
			case "ac":
				tipo="---->Actividad";
				break;
			default :
				tipo="NO VALIDO";
				break;
			
			}
			
		}
		return tipo;
	}

}
