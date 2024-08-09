package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;



import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Parte;


public interface ParteDAO {
	void cadastrar(Parte parte, String idBoletim);
	void remover(String idBoletim);
	Parte consultar(String idBoletim);
}
