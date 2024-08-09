package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.representacao;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Parte;

public class ParteRep {

	private String nome;
	private String email;
	private String telefone;
	private String tipoEnvolvimento;
	
	public ParteRep() {}

	public ParteRep(Parte parte) {
		this.nome = parte.getNome();
		this.email = parte.getEmail();
		this.telefone = parte.getTelefone();
		this.tipoEnvolvimento = parte.getTipoEnvolvimento();
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
	
	public Parte converterParaDominio() {
		
		Parte parte = new Parte();
		parte.setNome(nome);
		parte.setEmail(email);
		parte.setTelefone(telefone);
		parte.setTipoEnvolvimento(tipoEnvolvimento);
		
		return parte;
	}
	
}
