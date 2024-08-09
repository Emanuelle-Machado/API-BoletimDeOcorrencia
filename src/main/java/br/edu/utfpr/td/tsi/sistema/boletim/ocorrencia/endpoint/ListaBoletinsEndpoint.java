package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.endpoint;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.negocio.RegrasBoletins;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("listaDeBoletins")
public class ListaBoletinsEndpoint {
	
	@Autowired
	private RegrasBoletins regrasBoletins;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrarBoletim(BoletimFurtoVeiculo boletim) {
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response carregarListaBoletins() {
		
		return null;
	}
}
