package br.com.correcao.sped.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

import br.com.correcao.sped.bean.controller.ControladorRegistrosSped;
import br.com.correcao.sped.services.manipulacao.GravandoArquivo;
import br.com.correcao.sped.services.manipulacao.Importando;
import br.com.correcao.sped.services.manipulacao.Validando;
import br.com.correcao.sped.util.TratarArquivoUtil;


@ManagedBean
@RequestScoped
public class BeanCFOP {
	private Part arquivo;
	private String conteudo;
	private String[] vetorArquivo;
	private boolean c;
	ControladorRegistrosSped controla = new ControladorRegistrosSped();
	
	
	//Primeiro passo, faz a validacao de tamanho de arquivo para depois importar
	public void Validar(FacesContext contexto, UIComponent componente,Object valor) throws ValidatorException {
		this.c =Validando.ValidarImportacao(valor);
	}

	//Segundo passo. Importa o arquivo apos a validacao
	public void Importar() {
		if(c == true)
			this.conteudo = Importando.ImportarConteudo(this.arquivo);		
		ConfigurarArquivo();
		TratarArquivo();
	}


	//Metodos privados para tratar arquivo e gravar arquivo
	//Terceiro passo. Transformar arquivo em um vetor de Strings para tratativas posteriores
	private void ConfigurarArquivo(){
		this.vetorArquivo = TratarArquivoUtil.ConfiguraArquivo(this.conteudo);		
	}
	
	private void TratarArquivo(){
		controla.ModificaReg0500(this.vetorArquivo);
		controla.ModificaRegC175(this.vetorArquivo);		
		GravandoArquivo.Gravar(this.vetorArquivo);
	}
	
	
	public void setArquivo(Part arquivo) {
		this.arquivo = arquivo;
	}
	
	public Part getArquivo() {
		return arquivo;
	}

	public String getConteudo() {
		return conteudo;
	}

	
}
