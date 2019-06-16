package br.com.gsv.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.gsv.domain.sub.DiagnosticoBaseCheckbox;
import br.com.gsv.domain.sub.EnumEvolucaoEstGeral;
import br.com.gsv.domain.sub.EnumEvolucaoNivOrientacao;
import br.com.gsv.domain.sub.EnumEvolucaoNivelConsciencia;
import br.com.gsv.domain.sub.EnumEvolucaoPressao;
import br.com.gsv.domain.sub.EnumEvolucaoPulso;
import br.com.gsv.domain.sub.EnumEvolucaoTemperatura;

@Table
@Entity
@NamedQueries({ 
	@NamedQuery(name ="Evolucao.listar", query = "SELECT evolucao FROM Evolucao evolucao order by data"),
	@NamedQuery(name="Evolucao.buscarPorId", query="SELECT evolucao FROM Evolucao evolucao WHERE evolucao.id = :id"),
	@NamedQuery(name="Evolucao.buscarPorNome", query="SELECT evolucao FROM Evolucao evolucao WHERE evolucao.paciente.id = :id order by data")
})
public class Evolucao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private EnumEvolucaoEstGeral enumEstadoGeral;
	
	@Enumerated(EnumType.STRING)
	private EnumEvolucaoNivelConsciencia enumNivelConsciencia;
	
	@Enumerated(EnumType.STRING)
	private EnumEvolucaoNivOrientacao enumNivelOrientacao;
	
	@Enumerated(EnumType.STRING)
	private EnumEvolucaoTemperatura enumTemperatura;
	
	@Enumerated(EnumType.STRING)
	private EnumEvolucaoPressao enumPressao;
	
	@Enumerated(EnumType.STRING)
	private EnumEvolucaoPulso enumPulso;
	
	private String queixaPaciente;
	private String temperatura;
	private String pressao;
	private String pulso;
	private String radioRespiracao;
	private String tempoInternacao;
	private String textoDiagnostico;
	private String textoItensRelacionados;
	private String textoSonda;
	private String textoCurativo;
	private String textoObservacao;
	private String textoDiagAssoc;
	private String textoIntercorrencias;
	private String textoExames;
	private String textoEvolucao;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "tab_evo_diag_id", referencedColumnName = "diag_id")
	private DiagnosticoBaseCheckbox diagnosticoCheck;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "tbl_paciente_id", referencedColumnName = "id")
	private Paciente paciente;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "tbl_funcionario_id", referencedColumnName = "id")
	private Funcionario funcionario;
	
	@Temporal(TemporalType.DATE)
	private Date data;

	public Evolucao() {
		queixaPaciente = new String();
		temperatura = new String();
		pressao = new String();
		pulso = new String();
		radioRespiracao = new String();
		data = new Date();
		tempoInternacao = new String();
		textoDiagnostico = new String();
		textoItensRelacionados = new String();
		textoSonda = new String();
		textoCurativo = new String();
		funcionario = new Funcionario();
		paciente = new Paciente();
		diagnosticoCheck = new DiagnosticoBaseCheckbox();
		textoObservacao = new String();
		textoDiagAssoc = new String();
		textoIntercorrencias = new String();
		textoExames = new String();
		textoEvolucao = new String();
	}

	public EnumEvolucaoEstGeral getEnumEstadoGeral() {
		return enumEstadoGeral;
	}

	public void setEnumEstadoGeral(EnumEvolucaoEstGeral enumEstadoGeral) {
		this.enumEstadoGeral = enumEstadoGeral;
	}

	public EnumEvolucaoNivelConsciencia getEnumNivelConsciencia() {
		return enumNivelConsciencia;
	}

	public void setEnumNivelConsciencia(
			EnumEvolucaoNivelConsciencia enumNivelConsciencia) {
		this.enumNivelConsciencia = enumNivelConsciencia;
	}

	public EnumEvolucaoNivOrientacao getEnumNivelOrientacao() {
		return enumNivelOrientacao;
	}

	public void setEnumNivelOrientacao(
			EnumEvolucaoNivOrientacao enumNivelOrientacao) {
		this.enumNivelOrientacao = enumNivelOrientacao;
	}

	public EnumEvolucaoTemperatura getEnumTemperatura() {
		return enumTemperatura;
	}

	public void setEnumTemperatura(EnumEvolucaoTemperatura enumTemperatura) {
		this.enumTemperatura = enumTemperatura;
	}

	public EnumEvolucaoPressao getEnumPressao() {
		return enumPressao;
	}

	public void setEnumPressao(EnumEvolucaoPressao enumPressao) {
		this.enumPressao = enumPressao;
	}

	public EnumEvolucaoPulso getEnumPulso() {
		return enumPulso;
	}

	public void setEnumPulso(EnumEvolucaoPulso enumPulso) {
		this.enumPulso = enumPulso;
	}

	public String getQueixaPaciente() {
		return queixaPaciente;
	}

	public void setQueixaPaciente(String queixaPaciente) {
		this.queixaPaciente = queixaPaciente;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public String getPressao() {
		return pressao;
	}

	public void setPressao(String pressao) {
		this.pressao = pressao;
	}

	public String getPulso() {
		return pulso;
	}

	public void setPulso(String pulso) {
		this.pulso = pulso;
	}

	public String getRadioRespiracao() {
		return radioRespiracao;
	}

	public void setRadioRespiracao(String radioRespiracao) {
		this.radioRespiracao = radioRespiracao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTempoInternacao() {
		return tempoInternacao;
	}

	public void setTempoInternacao(String tempoInternacao) {
		this.tempoInternacao = tempoInternacao;
	}

	public String getTextoDiagnostico() {
		return textoDiagnostico;
	}

	public void setTextoDiagnostico(String textoDiagnostico) {
		this.textoDiagnostico = textoDiagnostico;
	}

	public String getTextoItensRelacionados() {
		return textoItensRelacionados;
	}

	public void setTextoItensRelacionados(String textoItensRelacionados) {
		this.textoItensRelacionados = textoItensRelacionados;
	}

	public String getTextoSonda() {
		return textoSonda;
	}

	public void setTextoSonda(String textoSonda) {
		this.textoSonda = textoSonda;
	}

	public String getTextoCurativo() {
		return textoCurativo;
	}

	public void setTextoCurativo(String textoCurativo) {
		this.textoCurativo = textoCurativo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public DiagnosticoBaseCheckbox getDiagnosticoCheck() {
		return diagnosticoCheck;
	}

	public void setDiagnosticoCheck(DiagnosticoBaseCheckbox diagnosticoCheck) {
		this.diagnosticoCheck = diagnosticoCheck;
	}

	public String getTextoObservacao() {
		return textoObservacao;
	}

	public void setTextoObservacao(String textoObservacao) {
		this.textoObservacao = textoObservacao;
	}

	public String getTextoDiagAssoc() {
		return textoDiagAssoc;
	}

	public void setTextoDiagAssoc(String textoDiagAssoc) {
		this.textoDiagAssoc = textoDiagAssoc;
	}

	public String getTextoIntercorrencias() {
		return textoIntercorrencias;
	}

	public void setTextoIntercorrencias(String textoIntercorrencias) {
		this.textoIntercorrencias = textoIntercorrencias;
	}

	public String getTextoExames() {
		return textoExames;
	}

	public void setTextoExames(String textoExames) {
		this.textoExames = textoExames;
	}

	public String getTextoEvolucao() {
		return textoEvolucao;
	}

	public void setTextoEvolucao(String textoEvolucao) {
		this.textoEvolucao = textoEvolucao;
	}
	
	

}
