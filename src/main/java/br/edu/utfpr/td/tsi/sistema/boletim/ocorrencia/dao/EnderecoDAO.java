package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;



import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Endereco;

public interface EnderecoDAO {
	void cadastrar(Endereco endereco, String idBoletim);
	void remover(String idBoletim);
	Endereco consultar(String idBoletim);
}
