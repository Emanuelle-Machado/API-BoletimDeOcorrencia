package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

public class BoletimFurtoVeiculo {
	
	@Id
	private String id;
	
	private String identificador;
	private String dataOcorrencia;
	private String periodoOcorrencia;
	
	@OneToMany
	private Parte partes;
	
	@OneToMany
	private Veiculo veiculoFurtado;
	
	@OneToOne
	private Endereco localOcorrencia;
	
	public String getIdBoletimFurtoVeiculo() {
		return id;
	}
	public void setIdBoletimFurtoVeiculo(String id) {
		this.id = id;
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
