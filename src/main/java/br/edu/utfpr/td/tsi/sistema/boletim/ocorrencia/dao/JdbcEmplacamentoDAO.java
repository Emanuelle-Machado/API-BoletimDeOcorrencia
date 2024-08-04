package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
		sql.append(" (placa, estado, cidade) ");
		sql.append("values (:placa, :estado, :cidade)");
		
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("idVeiculo", idVeiculo);
		parametros.put("placa", emplacamento.getPlaca());
		parametros.put("estado", emplacamento.getEstado());
		parametros.put("cidade", emplacamento.getCidade());
	
		jdbcTemplate.update(sql.toString(), parametros);
	}

	@Override
	public void alterar(Emplacamento emplacamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(String idVeiculo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Emplacamento consultar(String idVeiculo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emplacamento> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
