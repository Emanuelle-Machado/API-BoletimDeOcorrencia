package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.negocio.DadosObrigatoriosException;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.negocio.RegrasBoletins;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.representacao.BoletimFurtoVeiculoRep;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("listaDeBoletins")
public class ListaBoletinsEndpoint {
	
	@Autowired
	private RegrasBoletins regrasBoletins;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrarBoletim(BoletimFurtoVeiculoRep boletim) {
		
		try {
			BoletimFurtoVeiculo boletimDominio = boletim.converterParaDominio();
			regrasBoletins.cadastrar(boletimDominio, boletim.getVeiculoFurtado().getId());
			BoletimFurtoVeiculoRep boletimCadastrado = new BoletimFurtoVeiculoRep(boletimDominio);
		
			return Response.ok(boletimCadastrado).build();
		
		} catch (DadosObrigatoriosException e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response carregarListaBoletins() {
		List<BoletimFurtoVeiculo> lista = regrasBoletins.listarTodos();
		List<BoletimFurtoVeiculoRep> representacoes = new ArrayList<>();
		for(BoletimFurtoVeiculo boletim : lista) {
			representacoes.add(new BoletimFurtoVeiculoRep(boletim));
		}
		
		return Response.ok(representacoes).build();
	}
}
