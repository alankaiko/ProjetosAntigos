package br.com.gsv.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gsv.domain.Evolucao;
import br.com.gsv.util.Mensagem;
import br.com.projeto.gsv.service.EvolucaoService;

@ManagedBean(name = "MBEvolucao")
@ViewScoped
public class ConsultaEvolucao {
	private Evolucao evolucaoSelecionado;
	private EvolucaoService service;
	private List<Evolucao> listaEvolucao;
	private Long idBusca;

	public ConsultaEvolucao() {
		service = new EvolucaoService();
	}
	
	public void getListaFiltrada(){
		this.listaEvolucao = service.BuscarPorPaciente(idBusca);
	}

	public void ListarGeral() {
		this.listaEvolucao = service.ListandoTudo();
	}

	public void Excluir() {
		try {
			service.Remover(this.evolucaoSelecionado);

			Mensagem.mensagemInfo("Registro excluído com sucesso");
		} catch (Exception e) {
			throw e;
		}
	}

	public void Redirecionar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GASWeb/produtos/GerenciarProdutos.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Evolucao> getListaEvolucao() {
		return listaEvolucao;
	}

	public Evolucao getEvolucaoSelecionado() {
		return evolucaoSelecionado;
	}

	public void setEvolucaoSelecionado(Evolucao evolucaoSelecionado) {
		this.evolucaoSelecionado = evolucaoSelecionado;
	}
	
	public void setIdBusca(Long idBusca) {
		this.idBusca = idBusca;
	}
	
	
}
