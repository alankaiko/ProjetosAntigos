package br.com.gsv.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;

import br.com.gsv.domain.Fabricante;
import br.com.projeto.gsv.service.FabricanteService;


@FacesConverter(forClass=Fabricante.class, value="fabricanteConverter")
public class FabricanteConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {                
    	FabricanteService service = new FabricanteService();
    	Fabricante fabricante = null;
    	
    	if (StringUtils.isNotEmpty(value)) {
			Long id = new Long(value);
			fabricante = service.BuscandoId(id);
		}
    	
    	return fabricante;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Fabricante fabricante = (Fabricante) value;
        if(fabricante != null){
            return String.valueOf(fabricante.getId());
        }else{
            return null;
        }

    }
    
}