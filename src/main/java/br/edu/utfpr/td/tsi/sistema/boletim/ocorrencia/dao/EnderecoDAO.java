package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import java.util.List;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Endereco;

public interface EnderecoDAO {
	void cadastrar(Endereco endereco);
	void alterar(Endereco endereco);
	void remover(String idEndereco);
	Endereco consultar(String idEndereco);
	List<Endereco> listarTodos();
}
