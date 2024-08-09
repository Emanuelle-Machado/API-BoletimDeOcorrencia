package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.negocio;

import java.util.List;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.BoletimFurtoVeiculo;

public interface RegrasBoletins {
	void cadastrar(BoletimFurtoVeiculo boletim);
	List<BoletimFurtoVeiculo> listarTodos();
	BoletimFurtoVeiculo consultar(String idBoletim);
	public void alterar(BoletimFurtoVeiculo boletim);
	public void remover(String idBoletim);
}
