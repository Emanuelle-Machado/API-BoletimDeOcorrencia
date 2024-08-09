package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;


import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Emplacamento;


public interface EmplacamentoDAO {
	void cadastrar(Emplacamento emplacamento, String idVeiculo);
	void remover(String idVeiculo);
	Emplacamento consultar(String idVeiculo);
}
