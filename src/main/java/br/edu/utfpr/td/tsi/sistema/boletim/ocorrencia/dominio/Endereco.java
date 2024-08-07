package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio;

import jakarta.persistence.OneToOne;

public class Endereco {
	
	private String idEndereco;
	private String logradouro;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	
	public String getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(String idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@OneToOne
	private BoletimFurtoVeiculo boletimFurtoVeiculo;
	
}
