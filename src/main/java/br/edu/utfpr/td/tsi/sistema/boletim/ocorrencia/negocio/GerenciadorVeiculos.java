package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.negocio;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao.EmplacamentoDAO;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao.VeiculoDAO;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Emplacamento;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Veiculo;

@Component
public class GerenciadorVeiculos implements RegrasVeiculos {

	@Autowired
	private VeiculoDAO veiculoDAO;
	
	@Autowired
	private EmplacamentoDAO emplacamentoDAO;
	
	@Override
	@Transactional
	public void cadastrar(Veiculo veiculo) {
		String idVeiculo = UUID.randomUUID().toString();
		veiculo.setId(idVeiculo);
		veiculoDAO.cadastrar(veiculo);
		emplacamentoDAO.cadastrar(veiculo.getEmplacamento(), idVeiculo);
	}

	@Override
	public List<Veiculo> listarTodos() {
		return veiculoDAO.listarTodos();
	}

	@Override
	public Veiculo consultar(String idVeiculo) {
		Veiculo veiculo = veiculoDAO.consultar(idVeiculo);
		Emplacamento emplacamento = emplacamentoDAO.consultar(idVeiculo);
		veiculo.setEmplacamento(emplacamento);
		return veiculo;
	}

	@Override
	@Transactional
	public void alterar(Veiculo veiculo) {
		veiculoDAO.alterar(veiculo);
		emplacamentoDAO.remover(veiculo.getId());
		emplacamentoDAO.cadastrar(veiculo.getEmplacamento(), veiculo.getId());	
	}

	@Override
	@Transactional
	public void remover(String idVeiculo) {
		emplacamentoDAO.remover(idVeiculo);
		veiculoDAO.remover(idVeiculo);
	}

}
