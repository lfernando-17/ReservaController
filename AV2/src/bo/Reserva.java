package bo;

public class Reserva {
	private String dt_inicio;
	private String dt_fim;
	private String hora;
	private String codigo;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	private String pessoa_cpf;
	private String espaco_codigo;
	private String nome;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDt_inicio() {
		return dt_inicio;
	}
	public void setDt_inicio(String dt_inicio) {
		this.dt_inicio = dt_inicio;
	}
	public String getDt_fim() {
		return dt_fim;
	}
	public void setDt_fim(String dt_fim) {
		this.dt_fim = dt_fim;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getPessoa_cpf() {
		return pessoa_cpf;
	}
	public void setPessoa_cpf(String pessoa_cpf) {
		this.pessoa_cpf = pessoa_cpf;
	}
	public String getEspaco_codigo() {
		return espaco_codigo;
	}
	public void setEspaco_codigo(String espaco_codigo) {
		this.espaco_codigo = espaco_codigo;
	}
	
	
}
