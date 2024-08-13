package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Endereco;

public class JdbcEnderecoDAO implements EnderecoDAO {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public void cadastrar(Endereco endereco, String idBoletim) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into boletimocorrencia.endereco");
		sql.append(" (logradouro, numero, bairro, cidade, estado, idBoletim) ");
		sql.append("values (:logradouro, :numero, :bairro, :cidade, :estado, :idBoletim)");
		
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("idBoletim", idBoletim);
		parametros.put("logradouro", endereco.getLogradouro());
		parametros.put("numero", endereco.getNumero());
		parametros.put("bairro", endereco.getBairro());
		parametros.put("cidade", endereco.getCidade());
		parametros.put("estado", endereco.getEstado());
		
	
		jdbcTemplate.update(sql.toString(), parametros);
	}

	@Override
	public void remover(String idBoletim) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from boletimocorrencia.endereco ");
		sql.append("where idBoletim= :id");
		MapSqlParameterSource params = new MapSqlParameterSource("id", idBoletim);
		jdbcTemplate.update(sql.toString(), params);
	}

	@Override
	public Endereco consultar(String idBoletim) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from boletimocorrencia.endereco ");
		sql.append("where idBoletim= :id");
		
		MapSqlParameterSource params = new MapSqlParameterSource("id", idBoletim);
		
		return jdbcTemplate.queryForObject(sql.toString(), params, new RowMapper<Endereco>() {
			@Override
			public Endereco mapRow(ResultSet rs, int rowNum) throws SQLException {
				Endereco endereco = new Endereco();
				endereco.setLogradouro(rs.getString("logradouro"));
				endereco.setNumero(rs.getInt("numero"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(rs.getString("estado"));
				
				return endereco;
			}
		});
	}

}
