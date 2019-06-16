package br.com.gsv.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.gsv.domain.sub.EquipamentoCheckBox;
import br.com.gsv.domain.sub.IntegridadeHemorragia;
import br.com.gsv.domain.sub.SintomasCheckbox;
import br.com.gsv.domain.sub.SintomasMembrosCheckbox;

@Table
@Entity
@NamedQueries({
	@NamedQuery(name="Prontuario.listar", query="SELECT prontuario FROM Prontuario prontuario"),
	@NamedQuery(name="Prontuario.buscarPorIdPaciente", query="SELECT prontuario FROM Prontuario prontuario WHERE prontuario.paciente.id= :id"),
	@NamedQuery(name="Prontuario.buscarPorId", query="SELECT prontuario FROM Prontuario prontuario WHERE prontuario.id= :id"),
	@NamedQuery(name="Prontuario.BuscarPelaData", query="SELECT prontuario FROM Prontuario prontuario WHERE prontuario.data = :data")
})
public class Prontuario implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="conv_id")
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	private String hora;
	
	@OneToOne
	@JoinColumn(name = "tbl_paciente_id", referencedColumnName = "id")
	private Paciente paciente;
	
	@OneToOne
	@JoinColumn(name = "tbl_funcionario_id", referencedColumnName = "id")
	private Funcionario funcionario;
	
	
	private String anotConsciencia;
	private String anotMental;
	private String anotObservacao;
	private String condDeambulacao;
	private String condDeamObservacao;
	private String condRepouso;
	private String condSono;
	private String equipObservacao;
	private String inteHemoText;
	private String inteDispText;
	private String inteEdemaText;
	private String inteDescText;
	private String inteHemaText;
	private String inteCicaText;
	private String inteOutrosText;
	private String sintomasEspText;
	private String sintomasMembText;
	private String textoAreachegada;
	private String avaliCefaloMental;
	private String avaliCefaloTexto;
	private String avaliIntercorrencias;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "tab_pront_equip_id", referencedColumnName = "equip_id")
	private EquipamentoCheckBox equipCheckbox;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "tab_pront_sint_id", referencedColumnName = "sint_id")
	private SintomasCheckbox sintomasEsp;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "tab_pront_memb_id", referencedColumnName = "memb_id")
	private SintomasMembrosCheckbox sintomasMembros;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "tab_pront_integ_id", referencedColumnName = "integ_id")
	private IntegridadeHemorragia integHemorragia;
	
	
	
	
	public Prontuario() {
		funcionario = new Funcionario();
		paciente = new Paciente();
		anotConsciencia = new String();
		anotMental = new String();
		anotObservacao = new String();
		condDeambulacao = new String();
		condDeamObservacao = new String();
		condRepouso = new String();
		condSono = new String();
		equipObservacao = new String();
		inteHemoText = new String();
		inteDispText = new String();
		inteEdemaText = new String();
		inteDescText = new String();
		inteHemaText = new String();
		inteCicaText = new String();
		inteOutrosText = new String();
		sintomasEspText = new String();
		sintomasMembText = new String();
		textoAreachegada = new String();
		avaliCefaloMental = new String();
		avaliCefaloTexto = new String();
		avaliIntercorrencias = new String();
		integHemorragia = new IntegridadeHemorragia();
		sintomasMembros = new SintomasMembrosCheckbox();
		sintomasEsp = new SintomasCheckbox();
		equipCheckbox = new EquipamentoCheckBox();
	}

	
	
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}	

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getAnotConsciencia() {
		return anotConsciencia;
	}

	public void setAnotConsciencia(String anotConsciencia) {
		this.anotConsciencia = anotConsciencia;
	}

	public String getAnotMental() {
		return anotMental;
	}

	public void setAnotMental(String anotMental) {
		this.anotMental = anotMental;
	}

	public String getAnotObservacao() {
		return anotObservacao;
	}

	public void setAnotObservacao(String anotObservacao) {
		this.anotObservacao = anotObservacao;
	}

	public String getCondDeambulacao() {
		return condDeambulacao;
	}

	public void setCondDeambulacao(String condDeambulacao) {
		this.condDeambulacao = condDeambulacao;
	}

	public String getCondDeamObservacao() {
		return condDeamObservacao;
	}

	public void setCondDeamObservacao(String condDeamObservacao) {
		this.condDeamObservacao = condDeamObservacao;
	}

	public String getCondRepouso() {
		return condRepouso;
	}

	public void setCondRepouso(String condRepouso) {
		this.condRepouso = condRepouso;
	}

	public String getCondSono() {
		return condSono;
	}

	public void setCondSono(String condSono) {
		this.condSono = condSono;
	}

	public EquipamentoCheckBox getEquipCheckbox() {
		return equipCheckbox;
	}

	public void setEquipCheckbox(EquipamentoCheckBox equipCheckbox) {
		this.equipCheckbox = equipCheckbox;
	}

	public String getEquipObservacao() {
		return equipObservacao;
	}

	public void setEquipObservacao(String equipObservacao) {
		this.equipObservacao = equipObservacao;
	}

	public String getInteHemoText() {
		return inteHemoText;
	}

	public void setInteHemoText(String inteHemoText) {
		this.inteHemoText = inteHemoText;
	}

	public String getInteDispText() {
		return inteDispText;
	}

	public void setInteDispText(String inteDispText) {
		this.inteDispText = inteDispText;
	}

	public String getInteEdemaText() {
		return inteEdemaText;
	}

	public void setInteEdemaText(String inteEdemaText) {
		this.inteEdemaText = inteEdemaText;
	}

	public String getInteDescText() {
		return inteDescText;
	}

	public void setInteDescText(String inteDescText) {
		this.inteDescText = inteDescText;
	}

	public String getInteHemaText() {
		return inteHemaText;
	}

	public void setInteHemaText(String inteHemaText) {
		this.inteHemaText = inteHemaText;
	}

	public String getInteCicaText() {
		return inteCicaText;
	}

	public void setInteCicaText(String inteCicaText) {
		this.inteCicaText = inteCicaText;
	}

	public String getInteOutrosText() {
		return inteOutrosText;
	}

	public void setInteOutrosText(String inteOutrosText) {
		this.inteOutrosText = inteOutrosText;
	}

	public SintomasCheckbox getSintomasEsp() {
		return sintomasEsp;
	}

	public void setSintomasEsp(SintomasCheckbox sintomasEsp) {
		this.sintomasEsp = sintomasEsp;
	}

	public SintomasMembrosCheckbox getSintomasMembros() {
		return sintomasMembros;
	}

	public void setSintomasMembros(SintomasMembrosCheckbox sintomasMembros) {
		this.sintomasMembros = sintomasMembros;
	}

	public String getSintomasEspText() {
		return sintomasEspText;
	}

	public void setSintomasEspText(String sintomasEspText) {
		this.sintomasEspText = sintomasEspText;
	}

	public void setSintomasMembText(String sintomasMembText) {
		this.sintomasMembText = sintomasMembText;
	}
	
	public String getSintomasMembText() {
		return sintomasMembText;
	}
	
	public void setIntegHemorragia(IntegridadeHemorragia integHemorragia) {
		this.integHemorragia = integHemorragia;
	}
	public IntegridadeHemorragia getIntegHemorragia() {
		return integHemorragia;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getTextoAreachegada() {
		return textoAreachegada;
	}

	public void setTextoAreachegada(String textoAreachegada) {
		this.textoAreachegada = textoAreachegada;
	}

	public String getAvaliCefaloMental() {
		return avaliCefaloMental;
	}

	public void setAvaliCefaloMental(String avaliCefaloMental) {
		this.avaliCefaloMental = avaliCefaloMental;
	}

	public String getAvaliCefaloTexto() {
		return avaliCefaloTexto;
	}

	public void setAvaliCefaloTexto(String avaliCefaloTexto) {
		this.avaliCefaloTexto = avaliCefaloTexto;
	}

	public String getAvaliIntercorrencias() {
		return avaliIntercorrencias;
	}

	public void setAvaliIntercorrencias(String avaliIntercorrencias) {
		this.avaliIntercorrencias = avaliIntercorrencias;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}
