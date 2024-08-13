package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio;

import java.util.Date;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class BoletimFurtoVeiculo {
	
	@Id
	private String id;
	
	private Date dataOcorrencia;
	private String periodoOcorrencia;
	
	@OneToOne
	private Parte parte;
	
	@OneToOne
	private Veiculo veiculoFurtado;
	
	@OneToOne
	private Endereco localOcorrencia;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}
	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}
	public String getPeriodoOcorrencia() {
		return periodoOcorrencia;
	}
	public void setPeriodoOcorrencia(String periodoOcorrencia) {
		this.periodoOcorrencia = periodoOcorrencia;
	}
	
	public Parte getParte() {
		return parte;
	}
	public void setParte(Parte parte) {
		this.parte = parte;
	}
	public Veiculo getVeiculoFurtado() {
		return veiculoFurtado;
	}
	public void setVeiculoFurtado(Veiculo veiculoFurtado) {
		this.veiculoFurtado = veiculoFurtado;
	}
	public Endereco getLocalOcorrencia() {
		return localOcorrencia;
	}
	public void setLocalOcorrencia(Endereco localOcorrencia) {
		this.localOcorrencia = localOcorrencia;
	}
}
