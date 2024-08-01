package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.endpoint;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.negocio.RegrasVeiculos;
import jakarta.ws.rs.Path;

@Path("veiculo")
public class VeiculoEndpoint {
	
	@Autowired
	private RegrasVeiculos regrasVeiculos;
}
