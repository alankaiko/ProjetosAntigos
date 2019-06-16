package br.com.gsv.beans;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gsv.domain.Evolucao;
import br.com.gsv.domain.sub.EnumEvolucaoEstGeral;
import br.com.gsv.domain.sub.EnumEvolucaoNivOrientacao;
import br.com.gsv.domain.sub.EnumEvolucaoNivelConsciencia;
import br.com.gsv.domain.sub.EnumEvolucaoPressao;
import br.com.gsv.domain.sub.EnumEvolucaoPulso;
import br.com.gsv.domain.sub.EnumEvolucaoTemperatura;
import br.com.projeto.gsv.service.EvolucaoService;

@ManagedBean(name = "MBCadEvolucao")
@ViewScoped
public class CadastroEvolucao {
	private Evolucao evolucao;
	private EvolucaoService service;
	private Long id;
	private EnumEvolucaoEstGeral[] listaEstadoGeral;
	private EnumEvolucaoNivelConsciencia[] listaNivelConsc;
	private EnumEvolucaoNivOrientacao[] listaNivelOrient;
	private EnumEvolucaoPulso[] listaPulso;
	private EnumEvolucaoPressao[] listaPressaos;
	private EnumEvolucaoTemperatura[] listaTemperatura;

	public CadastroEvolucao() {
		this.evolucao = new Evolucao();
		this.service = new EvolucaoService();
	}
	
	@PostConstruct
	public void Inicializar(){
		listaEstadoGeral = EnumEvolucaoEstGeral.values();
		listaNivelConsc = EnumEvolucaoNivelConsciencia.values();
		listaPulso = EnumEvolucaoPulso.values();
		listaPressaos = EnumEvolucaoPressao.values();
		listaTemperatura = EnumEvolucaoTemperatura.values();
		listaNivelOrient = EnumEvolucaoNivOrientacao.values();
	}

	public void Redirecionar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GASWeb/convenios/GerenciarConvenios.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void Salvando() {
		this.service.Salvando(evolucao);
	}

	public void CarregandoEvolucaoEditar() {
		if (this.id != null)
			this.evolucao = service.BuscandoPelaId(id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Evolucao getEvolucao() {
		return evolucao;
	}

	public void setEvolucao(Evolucao evolucao) {
		this.evolucao = evolucao;
	}
	
	public EnumEvolucaoEstGeral[] getListaEstadoGeral() {
		return listaEstadoGeral;
	}
	
	public EnumEvolucaoNivelConsciencia[] getListaNivelConsc() {
		return listaNivelConsc;
	}
	
	public EnumEvolucaoNivOrientacao[] getListaNivelOrient() {
		return listaNivelOrient;
	}
	
	public EnumEvolucaoPressao[] getListaPressaos() {
		return listaPressaos;
	}
	
	public EnumEvolucaoPulso[] getListaPulso() {
		return listaPulso;
	}
	
	public EnumEvolucaoTemperatura[] getListaTemperatura() {
		return listaTemperatura;
	}
	
}
