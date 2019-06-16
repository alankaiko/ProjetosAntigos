package br.com.gsv.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;

import br.com.gsv.domain.Convenio;
import br.com.projeto.gsv.service.ConvenioService;


@FacesConverter(forClass=Convenio.class, value="convenioConverter")
public class ConvenioConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {                
    	ConvenioService service = new ConvenioService();
    	Convenio convenio = null;
    	
    	if (StringUtils.isNotEmpty(value)) {
			Long id = new Long(value);
			convenio = service.BuscandoId(id);
		}
    	
    	return convenio;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Convenio convenio = (Convenio) value;
        if(convenio != null){
            return String.valueOf(convenio.getId());
        }else{
            return null;
        }

    }
    
}