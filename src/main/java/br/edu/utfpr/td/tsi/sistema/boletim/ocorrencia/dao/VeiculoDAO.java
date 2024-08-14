package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import java.util.List;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Veiculo;


public interface VeiculoDAO {
	void cadastrar(Veiculo veiculo, String idVeiculo);
	void alterar(Veiculo veiculo);
	void remover(String idVeiculo);
	Veiculo consultar(String idVeiculo);
	List<Veiculo> listarTodos();
}
