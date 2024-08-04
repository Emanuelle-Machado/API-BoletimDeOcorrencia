package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio;

import jakarta.persistence.OneToOne;

public class Emplacamento {
	
	private String idVeiculo;
	private String placa;
	private String estado;
	private String cidade;
	
	
	
	public String getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(String idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	@OneToOne
	private Veiculo veiculo;
	
	
}
