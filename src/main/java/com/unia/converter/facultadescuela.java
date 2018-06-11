package com.unia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("facultadescuela")
public class facultadescuela implements Converter {

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
			case "f1":
				tipo="facultad 1";
				break;
			case "f2":
				tipo="facultad 2";
				break;
			case "e1":
				tipo="escuela 1";
				break;
			case "e2":
				tipo="escuela 2";
				break;	
			default :
				tipo="NO VALIDO";
				break;
			
			}
			
		}
		return tipo;
	}

}
