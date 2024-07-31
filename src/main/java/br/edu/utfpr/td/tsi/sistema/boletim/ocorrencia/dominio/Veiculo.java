package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio;

public class Veiculo {
	
	private String id;
	private String anoFabricacao;
	private String cor;
	private String marca;
	private String tipoVeiculo;
	private Emplacamento emplacamento;
	
	
	public Emplacamento getEmplacamento() {
		return emplacamento;
	}
	public void setEmplacamento(Emplacamento emplacamento) {
		this.emplacamento = emplacamento;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
