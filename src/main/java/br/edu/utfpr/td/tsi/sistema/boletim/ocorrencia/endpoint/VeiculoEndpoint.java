package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.endpoint;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Veiculo;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.negocio.RegrasVeiculos;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.representacao.VeiculoRep;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("veiculo")
public class VeiculoEndpoint {
	
	@Autowired
	private RegrasVeiculos regrasVeiculos;
	
	@QueryParam("idVeiculo")
	private String idVeiculo;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterVeiculo() {
		Veiculo veiculo = regrasVeiculos.consultar(idVeiculo);
		return Response.ok(new VeiculoRep(veiculo)).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterarVeiculo(VeiculoRep veiculo) {
		veiculo.setId(idVeiculo);
		Veiculo veiculoDominio = veiculo.converterParaDominio();
		regrasVeiculos.alterar(veiculoDominio);
		return Response.ok(new VeiculoRep(veiculoDominio)).build();
	}
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public Response removerVeiculo() {
		regrasVeiculos.remover(idVeiculo);
		return Response.ok("Veiculo removido com sucesso").build();
	}
}
