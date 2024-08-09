package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import java.util.List;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.BoletimFurtoVeiculo;

public interface BoletimFurtoVeiculoDAO {
	void cadastrar(BoletimFurtoVeiculo boletim);
	void alterar(BoletimFurtoVeiculo boletim);
	void remover(String idBoletim);
	BoletimFurtoVeiculo consultar(String idBoletim);
	List<BoletimFurtoVeiculo> listarTodos();
}
