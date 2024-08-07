package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Emplacamento;

@Component
public class JdbcEmplacamentoDAO implements EmplacamentoDAO {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public void cadastrar(Emplacamento emplacamento, String idVeiculo) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into boletimocorrencia.emplacamento");
		sql.append(" (placa, estado, cidade, idVeiculo) ");
		sql.append("values (:placa, :estado, :cidade, :idVeiculo)");
		
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("idVeiculo", idVeiculo);
		parametros.put("placa", emplacamento.getPlaca());
		parametros.put("estado", emplacamento.getEstado());
		parametros.put("cidade", emplacamento.getCidade());
	
		jdbcTemplate.update(sql.toString(), parametros);
	}

	@Override
	public void remover(String idVeiculo) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from boletimocorrencia.emplacamento ");
		sql.append("where idVeiculo= :id");
		MapSqlParameterSource params = new MapSqlParameterSource("id", idVeiculo);
		jdbcTemplate.update(sql.toString(), params);
	}

	@Override
	public Emplacamento consultar(String idVeiculo) {

		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from boletimocorrencia.emplacamento ");
		sql.append("where idVeiculo= :id");
		
		MapSqlParameterSource params = new MapSqlParameterSource("id", idVeiculo);
		
		return jdbcTemplate.queryForObject(sql.toString(), params, new RowMapper<Emplacamento>() {
			@Override
			public Emplacamento mapRow(ResultSet rs, int rowNum) throws SQLException {
				Emplacamento emplacamento = new Emplacamento();
				emplacamento.setPlaca(rs.getString("placa"));
				emplacamento.setCidade(rs.getString("cidade"));
				emplacamento.setEstado(rs.getString("estado"));
				
				return emplacamento;
			}
		});
	}

}
