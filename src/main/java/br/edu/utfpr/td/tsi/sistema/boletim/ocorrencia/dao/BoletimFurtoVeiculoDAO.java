package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import java.util.List;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.BoletimFurtoVeiculo;

public interface BoletimFurtoVeiculoDAO {
	void cadastrar(BoletimFurtoVeiculo boletimFurtoVeiculo);
	void alterar(BoletimFurtoVeiculo boletimFurtoVeiculo);
	void remover(String idBoletimFurtoVeiculo);
	BoletimFurtoVeiculo consultar(String idBoletimFurtoVeiculo);
	List<BoletimFurtoVeiculo> listarTodos();
}
