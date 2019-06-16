package br.com.gsv.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gsv.domain.Funcionario;
import br.com.gsv.util.ListasUtil;
import br.com.projeto.gsv.service.FuncionarioService;

@ManagedBean(name="MBCadFuncionario")
@ViewScoped
public class CadastroFuncionario {
	private List<String> listaEstados;
	private List<String> listaEstadosCoren;
	private List<String> listaCoren;
	private Funcionario funcionario;
	private FuncionarioService service;
	private Long id;
	
	public CadastroFuncionario() {
		this.service = new FuncionarioService();
		this.funcionario = new Funcionario();
	}
	
	public void Inicializar(){
		this.listaEstados = ListasUtil.Estados();
		this.listaEstadosCoren = ListasUtil.EstadosAbrev();
		this.listaCoren = ListasUtil.Coren();
	}
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GASWeb/funcionarios/GerenciarFuncionarios.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Salvando(){
		this.service.Salvar(this.funcionario);
	}
	
	public void CarregarFuncionarioEditar(){
		if(this.id != null)
			this.funcionario = service.BuscandoId(this.id);
	}

	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public List<String> getListaEstados() {
		return listaEstados;
	}
	
	public List<String> getListaCoren() {
		return listaCoren;
	}
	
	public List<String> getListaEstadosCoren() {
		return listaEstadosCoren;
	}
}
