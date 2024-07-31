package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
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
	public List<Veiculo> listarTodos() {

		StringBuilder sql = new StringBuilder();
		sql.append("select * from boletimocorrencia.veiculo");
		
		return jdbcTemplate.query(sql.toString(), new RowMapper<Veiculo>() {
			
			@Override
			public Veiculo mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Veiculo veiculo = new Veiculo();
				veiculo.setId(rs.getString("id"));
				veiculo.setAnoFabricacao(rs.getString("anoFabricacao"));
				veiculo.setCor(rs.getString("cor"));
				veiculo.setMarca(rs.getString("marca"));
				veiculo.setTipoVeiculo(rs.getString("tipoVeiculo"));
				
				return veiculo;
			}
		});
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

}
