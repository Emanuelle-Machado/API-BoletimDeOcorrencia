package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Veiculo;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.negocio.RegrasVeiculos;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.representacao.VeiculoRep;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("listaDeVeiculos")
public class ListaVeiculosEndpoint {
	
	@Autowired
	private RegrasVeiculos regrasVeiculos;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrarVeiculo(VeiculoRep veiculo) {
		
		Veiculo veiculoDominio = veiculo.converterParaDominio();
		regrasVeiculos.cadastrar(veiculoDominio);
		VeiculoRep veiculoCadastrado = new VeiculoRep(veiculoDominio);
		
		return Response.ok(veiculoCadastrado).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response carregarListaVeiculos() {
			
		List<Veiculo> lista = regrasVeiculos.listarTodos();
		List<VeiculoRep> representacoes = new ArrayList<>();
		for(Veiculo veiculo : lista) {
			representacoes.add(new VeiculoRep(veiculo));
		}
		
		return Response.ok(representacoes).build();
	}
}






