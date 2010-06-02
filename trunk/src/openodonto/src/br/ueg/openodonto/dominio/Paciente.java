package br.ueg.openodonto.dominio;

import java.sql.Date;
import java.util.Map;

import br.ueg.openodonto.persistencia.orm.Column;
import br.ueg.openodonto.persistencia.orm.Table;

@Table(name="pacientes")
public class Paciente extends Pessoa{

	private static final long serialVersionUID = -8543328508793753975L;

	public static void main(String[] args) {
		Paciente paciente = new Paciente();
		paciente.setCodigo(5L);
		paciente.setCpf("02549287142");
		Map<String, Object> debug = paciente.format();
		System.out.println(debug);
	}
	
	@Column(name="cpf")
	private String      cpf;	
	
	@Column(name="data_inicio_tratamento")
	private Date        dataInicioTratamento;
	
	@Column(name="data_termino_treinamento")
	private Date        dataTerminoTratamento;
	
	@Column(name="data_retorno")
	private Date        dataRetorno;
	
	@Column(name="data_nascimento")
	private Date        dataNascimento;
	
	@Column(name="responsavel")
	private String      responsavel;
	
	@Column(name="referencia")
	private String      referencia;
	
	@Column(name="observacao")
	private String      observacao;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataInicioTratamento() {
		return dataInicioTratamento;
	}

	public void setDataInicioTratamento(Date dataInicioTratamento) {
		this.dataInicioTratamento = dataInicioTratamento;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Date getDataTerminoTratamento() {
		return dataTerminoTratamento;
	}

	public void setDataTerminoTratamento(Date dataTerminoTratamento) {
		this.dataTerminoTratamento = dataTerminoTratamento;
	}

	public Date getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}	

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return super.toString() + "Paciente [cpf=" + cpf + ", dataInicioTratamento="
				+ dataInicioTratamento + ", dataNascimento=" + dataNascimento
				+ ", dataRetorno=" + dataRetorno + ", dataTerminoTratamento="
				+ dataTerminoTratamento + ", observacao=" + observacao
				+ ", referencia=" + referencia + ", responsavel=" + responsavel
				+ "]";
	}	
	
}