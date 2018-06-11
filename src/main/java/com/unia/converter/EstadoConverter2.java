package com.unia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("estadoConverter2")
public class EstadoConverter2 implements Converter {

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
			case "co":
				tipo="Completado";
				break;
			
			
			}
			
		}
		return tipo;
	}

}
