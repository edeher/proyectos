package com.unia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("estadoProyecto")
public class estadoProyecto implements Converter {

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
			case "in":
				tipo="Iniciado";
				break;
			case "ap":
				tipo="Aprobado";
				break;
			case "ob":
				tipo="Observado";
				break;
			case "co":
				tipo="concluido";
				break;
			default :
				tipo="NO VALIDO";
				break;
			
			}
			
		}
		return tipo;
	}

}
