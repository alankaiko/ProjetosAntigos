package br.com.gsv.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;

import br.com.gsv.domain.Convenio;
import br.com.gsv.domain.sub.Grupo;
import br.com.projeto.gsv.service.GrupoService;



@FacesConverter(forClass=Convenio.class, value="grupoConverter")
public class GrupoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {                
    	GrupoService service = new GrupoService();
    	Grupo grupo = null;
    	
    	if (StringUtils.isNotEmpty(value)) {
			Long id = new Long(value);
			grupo = service.BuscandoId(id);
		}
    	
    	return grupo;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
    	 Grupo grupo = (Grupo) value;
         if(grupo != null){
             return String.valueOf(grupo.getId());
         }else{
             return null;
         }

    }
    
}