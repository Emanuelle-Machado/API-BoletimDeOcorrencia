package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import java.util.List;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Emplacamento;


public interface EmplacamentoDAO {
	void cadastrar(Emplacamento emplacamento);
	void alterar(Emplacamento emplacamento);
	void remover(String idEmplacamento);
	Emplacamento consultar(String idEmplacamento);
	List<Emplacamento> listarTodos();
}
