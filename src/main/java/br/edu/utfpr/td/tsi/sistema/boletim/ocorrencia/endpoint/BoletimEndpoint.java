package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.endpoint;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.negocio.RegrasBoletins;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.representacao.BoletimFurtoVeiculoRep;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("boletim")
public class BoletimEndpoint {
	
	@Autowired
	private RegrasBoletins regrasBoletim;
	
	@QueryParam("idBoletim")
	private String idBoletim;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterBoletim() {
		BoletimFurtoVeiculo boletim = regrasBoletim.consultar(idBoletim);
		return Response.ok(new BoletimFurtoVeiculoRep(boletim)).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterarVeiculo(BoletimFurtoVeiculoRep boletim) {
		boletim.setId(idBoletim);
		BoletimFurtoVeiculo boletimDominio = boletim.converterParaDominio();
		regrasBoletim.alterar(boletimDominio);
		return Response.ok(new BoletimFurtoVeiculoRep(boletimDominio)).build();
	}
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public Response removerVeiculo() {
		regrasBoletim.remover(idBoletim);
		return Response.ok("Boletim removido com sucesso").build();
	}
	
}
