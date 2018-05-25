package com.unia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("jefeareaConverter")
public class JefeAreaConverter implements Converter {

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
			case "1":
				tipo="SI";
				break;
			case "0":
				tipo="NO";
				break;
			default :
				tipo="NO VALIDO";
				break;
			
			}
			
		}
		return tipo;
	}

}
