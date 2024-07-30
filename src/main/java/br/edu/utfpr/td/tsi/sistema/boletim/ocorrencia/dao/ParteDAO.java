package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import java.util.List;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Parte;


public interface ParteDAO {
	void cadastrar(Parte parte);
	void alterar(Parte parte);
	void remover(String idParte);
	Parte consultar(String idParte);
	List<Parte> listarTodos();
}
