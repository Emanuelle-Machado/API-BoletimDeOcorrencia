package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Parte;

@Component
public class JdbcParteDAO implements ParteDAO {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public void cadastrar(Parte parte, String idBoletim) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into boletimocorrencia.parte");
		sql.append(" (nome, email, telefone, tipoEnvolvimento, idBoletim) ");
		sql.append("values (:nome, :email, :telefone, :tipoEnvolvimento, :idBoletim)");

		Map<String, Object> parametros = new HashMap<>();
		parametros.put("idBoletim", idBoletim);
		parametros.put("nome", parte.getNome());
		parametros.put("email", parte.getEmail());
		parametros.put("telefone", parte.getTelefone());
		parametros.put("tipoEnvolvimento", parte.getTipoEnvolvimento());

		jdbcTemplate.update(sql.toString(), parametros);
	}

	@Override
	public void remover(String idBoletim) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from boletimocorrencia.parte ");
		sql.append("where idBoletim= :id");
		MapSqlParameterSource params = new MapSqlParameterSource("id", idBoletim);
		jdbcTemplate.update(sql.toString(), params);
	}

	@Override
	public Parte consultar(String idBoletim) {

		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from boletimocorrencia.parte ");
		sql.append("where idBoletim= :id");

		MapSqlParameterSource params = new MapSqlParameterSource("id", idBoletim);

		return jdbcTemplate.queryForObject(sql.toString(), params, new RowMapper<Parte>() {
			@Override
			public Parte mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
				Parte parte = new Parte();
				parte.setNome(rs.getString("nome"));
				parte.setEmail(rs.getString("email"));
				parte.setTelefone(rs.getString("telefone"));
				parte.setTipoEnvolvimento(rs.getString("tipoEnvolvimento"));

				return parte;
			}
		});
	}

}
