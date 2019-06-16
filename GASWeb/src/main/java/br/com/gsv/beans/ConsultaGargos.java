package br.com.gsv.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;

import br.com.gsv.domain.sub.Grupo;
import br.com.gsv.util.Mensagem;
import br.com.projeto.gsv.service.GrupoService;

@Entity
@ManagedBean(name="MBCargos")
public class ConsultaGargos {
	private Grupo grupoSelecionado;
	private GrupoService service;
	private List<Grupo> listaGrupo;

	public ConsultaGargos() {
		service = new GrupoService();
	}

	public void ListarGeral() {
		this.listaGrupo = service.ListandoGrupos();
	}

	public void Excluir() {
		try {
			this.service.Remover(this.grupoSelecionado);

			Mensagem.mensagemInfo("Cliente " + this.grupoSelecionado.getNome() + " Excluído com Sucesso");
		} catch (Exception e) {
			throw e;
		}

	}

	public void Redirecionar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GASWeb/grupos/GerenciarCargos.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Grupo> getListaGrupo() {
		return listaGrupo;
	}

	public void setGrupoSelecionado(Grupo grupoSelecionado) {
		this.grupoSelecionado = grupoSelecionado;
	}

	public Grupo getGrupoSelecionado() {
		return grupoSelecionado;
	}
}
