package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio;

public class Veiculo {
	
	private String idVeiculo;
	private String anoFabricacao;
	private String cor;
	private String marca;
	private String tipoVeiculo;
	private Emplacamento emplacamento;
	
	public String getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(String idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public String getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTipoVeiculo() {
		return tipoVeiculo;
	}
	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	
	
}
