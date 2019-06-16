package br.com.gsv.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Mensagem {

	public static void mensagemInfo(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		FacesContext facesContext = FacesContext.getCurrentInstance();

		facesContext.addMessage(null, facesMessage);
	}

	public static void mensagemError(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
		FacesContext facesContext = FacesContext.getCurrentInstance();

		facesContext.addMessage(null, facesMessage);
	}

}
