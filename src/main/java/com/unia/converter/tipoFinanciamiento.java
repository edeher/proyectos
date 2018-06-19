package com.unia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("tipoFinanciamiento")
public class tipoFinanciamiento implements Converter {

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
			case "ex":
				tipo="EXTERNO";
				break;
			case "un":
				tipo="UNIA";
				break;
			case "mi":
				tipo="MIXTO";
				break;
			default :
				tipo="NO VALIDO";
				break;
			
			}
			
		}
		return tipo;
	}

}
