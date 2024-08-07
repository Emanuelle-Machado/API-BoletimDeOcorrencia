package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio;

import jakarta.persistence.ManyToOne;

public class Parte {
	
	private String idParte;
	private String nome;
	private String email;
	private String telefone;
	private String tipoEnvolvimento;
	
	
	public String getIdParte() {
		return idParte;
	}
	public void setIdParte(String idParte) {
		this.idParte = idParte;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTipoEnvolvimento() {
		return tipoEnvolvimento;
	}
	public void setTipoEnvolvimento(String tipoEnvolvimento) {
		this.tipoEnvolvimento = tipoEnvolvimento;
	}
	
	@ManyToOne
	private BoletimFurtoVeiculo boletimFurtoVeiculo;
}
