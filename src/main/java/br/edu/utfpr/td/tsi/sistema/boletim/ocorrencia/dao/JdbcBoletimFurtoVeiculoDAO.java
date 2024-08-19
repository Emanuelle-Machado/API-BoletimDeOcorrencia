package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.negocio.BoletimNaoEncontradoException;

@Component
public class JdbcBoletimFurtoVeiculoDAO implements BoletimFurtoVeiculoDAO {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public void cadastrar(BoletimFurtoVeiculo boletim) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into boletimocorrencia.boletimfurtoveiculo");
		sql.append("( idBoletim, dataOcorrencia, periodoOcorrencia )");
		sql.append("values (:idBoletim, :dataOcorrencia, :periodoOcorrencia)");

		Map<String, Object> parametros = new HashMap<>();
		parametros.put("idBoletim", boletim.getId());
		parametros.put("dataOcorrencia", boletim.getDataOcorrencia());
		parametros.put("periodoOcorrencia", boletim.getPeriodoOcorrencia());

		jdbcTemplate.update(sql.toString(), parametros);
	}

	@Override
	public List<BoletimFurtoVeiculo> listarTodos() {

		StringBuilder sql = new StringBuilder();
		sql.append("select * from boletimocorrencia.boletimfurtoveiculo");

		return jdbcTemplate.query(sql.toString(), new RowMapper<BoletimFurtoVeiculo>() {

			@Override
			public BoletimFurtoVeiculo mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {

				BoletimFurtoVeiculo boletim = new BoletimFurtoVeiculo();
				boletim.setId(rs.getString("idBoletim"));
				boletim.setDataOcorrencia(rs.getDate("dataOcorrencia"));
				boletim.setPeriodoOcorrencia(rs.getString("periodoOcorrencia"));

				return boletim;
			}
		});
	}

	@Override
	public void alterar(BoletimFurtoVeiculo boletim) {
		StringBuilder sql = new StringBuilder();
		sql.append("update boletimocorrencia.boletimfurtoveiculo set ");
		sql.append("dataOcorrencia= :dataOcorrencia, ");
		sql.append("periodoOcorrencia= :periodoOcorrencia, ");
		sql.append("where idBoletim = :id");

		Map<String, Object> parametros = new HashMap<>();

		parametros.put("id", boletim.getId());
		parametros.put("dataOcorrencia", boletim.getDataOcorrencia());
		parametros.put("periodoOcorrencia", boletim.getPeriodoOcorrencia());

		int update = jdbcTemplate.update(sql.toString(), parametros);
		if (update == 0) {
		throw new BoletimNaoEncontradoException("Boletim nao encontrado");
		}
	}

	@Override
	public void remover(String idBoletim) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from boletimocorrencia.boletimfurtoveiculo ");
		sql.append("where idBoletim = :id");
		MapSqlParameterSource params = new MapSqlParameterSource("id", idBoletim);
		
		int removido = jdbcTemplate.update(sql.toString(), params);
		if (removido == 0) {
		String msgErro = "Contato nao encontrado";
		throw new BoletimNaoEncontradoException(msgErro);
		}
	}

	@Override
	public BoletimFurtoVeiculo consultar(String idBoletim) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from boletimocorrencia.boletimfurtoveiculo ");
		sql.append("where idBoletim = :id");

		MapSqlParameterSource params = new MapSqlParameterSource("id", idBoletim);
		
		try {
			return jdbcTemplate.queryForObject(sql.toString(), params, new RowMapper<BoletimFurtoVeiculo>() {
				@Override
				public BoletimFurtoVeiculo mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
					BoletimFurtoVeiculo boletim = new BoletimFurtoVeiculo();
					boletim.setId(rs.getString("idBoletim"));
					boletim.setDataOcorrencia(rs.getDate("dataOcorrencia"));
					boletim.setPeriodoOcorrencia(rs.getString("periodoOcorrencia"));

					return boletim;
				}
			});
		} catch (IncorrectResultSizeDataAccessException e) {
			String msgErro = "Boletim nao encontrado";
			throw new BoletimNaoEncontradoException(msgErro);
		}
	}

}
