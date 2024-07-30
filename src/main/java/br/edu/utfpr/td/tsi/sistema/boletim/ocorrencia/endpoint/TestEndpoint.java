package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.endpoint;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("teste")
public class TestEndpoint {
	
	@GET
	public Response teste() {
	return Response.ok("Teste bem sucedido").build();
	}

}
