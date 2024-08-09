package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.representacao;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Endereco;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Parte;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Veiculo;
import jakarta.persistence.Id;

public class BoletimFurtoVeiculoRep {

	@Id
	private String id;
	
	private String dataOcorrencia;
	private String periodoOcorrencia;
	
	private Parte parte;
	private Veiculo veiculoFurtado;
	private Endereco localOcorrencia;
	
	public BoletimFurtoVeiculoRep() {}
	
	public BoletimFurtoVeiculoRep(BoletimFurtoVeiculo boletim) {
		super();
		this.id = boletim.getId();
	}
	
	public BoletimFurtoVeiculo converterParaDominio() {
		BoletimFurtoVeiculo boletim = new BoletimFurtoVeiculo();
		boletim.setId(this.id);
		
		return boletim;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
