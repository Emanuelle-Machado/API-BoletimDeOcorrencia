package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.representacao;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.BoletimFurtoVeiculo;
import jakarta.persistence.Id;

public class BoletimFurtoVeiculoRep {

	@Id
	private String id;

	private String dataOcorrencia;
	private String periodoOcorrencia;

	private ParteRep parte;
	private EnderecoRep localOcorrencia;
	private VeiculoRep veiculoFurtado;

	public BoletimFurtoVeiculoRep() {
	}

	public BoletimFurtoVeiculoRep(BoletimFurtoVeiculo boletim) {
		super();
		this.id = boletim.getId();
		this.dataOcorrencia = serializarData(boletim.getDataOcorrencia());
		this.periodoOcorrencia = boletim.getPeriodoOcorrencia();
		
		if(boletim.getParte() != null) {
			this.parte = new ParteRep(boletim.getParte());
		}
		if(boletim.getLocalOcorrencia() != null) {
			this.localOcorrencia = new EnderecoRep(boletim.getLocalOcorrencia());
		}
		if(boletim.getVeiculoFurtado() != null) {
			this.veiculoFurtado = new VeiculoRep(boletim.getVeiculoFurtado());
		}

	}

	public BoletimFurtoVeiculo converterParaDominio() {
		
		BoletimFurtoVeiculo boletim = new BoletimFurtoVeiculo();
		boletim.setId(this.id);
		
		Date dataO = converterData(this.dataOcorrencia);
		boletim.setDataOcorrencia(dataO);
		
		boletim.setPeriodoOcorrencia(this.periodoOcorrencia);

		if(this.parte != null) {
			boletim.setParte(this.parte.converterParaDominio());
		}
		if(this.localOcorrencia != null) {
			boletim.setLocalOcorrencia(this.localOcorrencia.converterParaDominio());
		}
		if(this.veiculoFurtado != null) {
			boletim.setVeiculoFurtado(this.veiculoFurtado.converterParaDominio());
		}

		return boletim;
	}

	private Date converterData(String dataTextual) {
		DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
		DateTime dataConvertida = dtf.parseDateTime(dataTextual);
		return dataConvertida.toDate();
	}

	private String serializarData(Date data) {
		DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
		LocalDateTime dt = new LocalDateTime(data, DateTimeZone.UTC);
		return dtf.print(dt);
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

	public ParteRep getParte() {
		return parte;
	}

	public void setParte(ParteRep parte) {
		this.parte = parte;
	}

	public VeiculoRep getVeiculoFurtado() {
		return veiculoFurtado;
	}

	public void setVeiculoFurtado(VeiculoRep veiculoFurtado) {
		this.veiculoFurtado = veiculoFurtado;
	}

	public EnderecoRep getLocalOcorrencia() {
		return localOcorrencia;
	}

	public void setLocalOcorrencia(EnderecoRep localOcorrencia) {
		this.localOcorrencia = localOcorrencia;
	}

}
