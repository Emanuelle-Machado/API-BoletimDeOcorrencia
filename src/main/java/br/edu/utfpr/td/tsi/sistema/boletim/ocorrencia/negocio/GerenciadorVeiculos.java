package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.negocio;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao.EmplacamentoDAO;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao.VeiculoDAO;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Veiculo;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Veiculo consultar(String idVeiculo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void alterar(Veiculo veiculo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void remover(String idVeiculo) {
		// TODO Auto-generated method stub
		
	}

}
