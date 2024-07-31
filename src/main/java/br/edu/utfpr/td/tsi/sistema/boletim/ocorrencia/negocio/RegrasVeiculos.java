package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.negocio;

import java.util.List;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Veiculo;

public interface RegrasVeiculos {
	void cadastrar(Veiculo veiculo);
	List<Veiculo> listarTodos();
	Veiculo consultar(String idVeiculo);
	public void alterar(Veiculo veiculo);
	public void remover(String idVeiculo);
}
