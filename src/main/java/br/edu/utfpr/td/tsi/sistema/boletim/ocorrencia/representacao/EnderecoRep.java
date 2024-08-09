package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.representacao;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Endereco;

public class EnderecoRep {

	private String logradouro;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	
	public EnderecoRep() {}
	
	public EnderecoRep(Endereco endereco) {
		super();
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
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
	
	public Endereco converterParaDominio() {
		Endereco endereco = new Endereco();
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		return endereco;
	}
	
}
