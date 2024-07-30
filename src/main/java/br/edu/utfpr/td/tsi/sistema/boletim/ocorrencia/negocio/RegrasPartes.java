package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.negocio;

import java.util.List;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Parte;

public interface RegrasPartes {
	void cadastrar(Parte parte);
	List<Parte> listarTodos();
	Parte consultar(String idParte);
	public void alterar(Parte parte);
	public void remover(String idParte);
}
