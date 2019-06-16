package br.com.gsv.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gsv.util.context.FacesUtil;

@Named
@RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private HttpServletRequest request ;
	
	@Inject
	private HttpServletResponse response;
	
	private String login;
	private String senha;
	
	public void preRender() {
		if ("true".equals(request.getParameter("invalid"))) {
			FacesUtil.addErrorMessage("Usuário ou senha inválido!");
		}
	}

	
	public void login() throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.xhtml");
		dispatcher.forward(request, response);
		
		facesContext.getCurrentInstance().responseComplete();
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}