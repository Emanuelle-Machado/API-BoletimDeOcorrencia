package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio;

public class BoletimFurtoVeiculo {
	
	private String idBoletimFurtoVeiculo;
	private String identificador;
	private String dataOcorrencia;
	private String periodoOcorrencia;
	private Parte partes;
	private Endereco localOcorrencia;
	private Veiculo veiculoFurtado;
	
	public String getIdBoletimFurtoVeiculo() {
		return idBoletimFurtoVeiculo;
	}
	public void setIdBoletimFurtoVeiculo(String idBoletimFurtoVeiculo) {
		this.idBoletimFurtoVeiculo = idBoletimFurtoVeiculo;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getDataOcorrencia() {
		return dataOcorrencia;
	}
	public void setDataOcorrencia(String dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}
	
	public String getPeriodoOcorrencia() {
		return periodoOcorrencia;
	}
	public void setPeriodoOcorrencia(String periodoOcorrencia) {
		this.periodoOcorrencia = periodoOcorrencia;
	}
	
	
}
