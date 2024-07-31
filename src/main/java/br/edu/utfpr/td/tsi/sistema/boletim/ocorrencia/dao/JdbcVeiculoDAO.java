package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Veiculo;

@Component
public class JdbcVeiculoDAO implements VeiculoDAO {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public void cadastrar(Veiculo veiculo) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into boletimocorrencia.veiculo");
		sql.append("( id, anoFabricacao, cor, marca, tipoVeiculo )");
		sql.append("values (:id, :anoFabricacao, :cor, :marca, :tipoVeiculo)");
		
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("id", veiculo.getId());
		parametros.put("anoFabricacao", veiculo.getAnoFabricacao());
		parametros.put("cor", veiculo.getCor());
		parametros.put("marca", veiculo.getMarca());
		parametros.put("tipoVeiculo", veiculo.getTipoVeiculo());

		jdbcTemplate.update(sql.toString(), parametros);
	}

	@Override
	public void alterar(Veiculo veiculo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(String idVeiculo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Veiculo consultar(String idVeiculo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Veiculo> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
