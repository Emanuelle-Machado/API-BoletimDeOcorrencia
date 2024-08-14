package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.negocio;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao.BoletimFurtoVeiculoDAO;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao.EnderecoDAO;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao.ParteDAO;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao.VeiculoDAO;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Emplacamento;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Endereco;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Parte;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Veiculo;

@Component
public class GerenciadorBoletins implements RegrasBoletins {

	@Autowired
	private BoletimFurtoVeiculoDAO boletimFurtoVeiculoDAO;
	
	@Autowired
	private ParteDAO parteDAO;
	
	@Autowired
	private EnderecoDAO enderecoDAO;
	
	@Autowired
	private VeiculoDAO veiculoDAO;
	
	@Override
	@Transactional
	public void cadastrar(BoletimFurtoVeiculo boletim, String idVeiculo) {
		String idBoletim = UUID.randomUUID().toString();
		boletim.setId(idBoletim);
		boletimFurtoVeiculoDAO.cadastrar(boletim);
		parteDAO.cadastrar(boletim.getParte(), idBoletim);
		enderecoDAO.cadastrar(boletim.getLocalOcorrencia(), idBoletim);
		veiculoDAO.cadastrar(boletim.getVeiculoFurtado(), idVeiculo);
	}

	@Override
	public List<BoletimFurtoVeiculo> listarTodos() {
		return boletimFurtoVeiculoDAO.listarTodos();
	}

	@Override
	public BoletimFurtoVeiculo consultar(String idBoletim) {
		BoletimFurtoVeiculo boletim = boletimFurtoVeiculoDAO.consultar(idBoletim);
		
		Parte parte = parteDAO.consultar(idBoletim);
		Endereco endereco = enderecoDAO.consultar(idBoletim);
		Veiculo veiculo = veiculoDAO.consultar(boletim.getVeiculoFurtado().getId());
		
		boletim.setParte(parte);
		boletim.setLocalOcorrencia(endereco);
		boletim.setVeiculoFurtado(veiculo);
		
		return boletim;
	}

	@Override
	@Transactional
	public void alterar(BoletimFurtoVeiculo boletim) {
		boletimFurtoVeiculoDAO.alterar(boletim);
		
		parteDAO.remover(boletim.getId());
		parteDAO.cadastrar(boletim.getParte(), boletim.getId());	
		
		enderecoDAO.remover(boletim.getId());
		enderecoDAO.cadastrar(boletim.getLocalOcorrencia(), boletim.getId());
		
		veiculoDAO.remover(boletim.getId());
		veiculoDAO.cadastrar(boletim.getVeiculoFurtado(), boletim.getVeiculoFurtado().getId());
	}

	@Override
	@Transactional
	public void remover(String idBoletim, String idVeiculo) {
		parteDAO.remover(idBoletim);
		enderecoDAO.remover(idBoletim);
		veiculoDAO.remover(idVeiculo);
		boletimFurtoVeiculoDAO.remover(idBoletim);
	}
	
	private void validarEmail(String email) {
		String msgError = "Formato do email está incorreto";
		throw new FormatoEmailException(msgError);
	}

	private void validarTelefone(String telefone) {
		String msgError = "Formato do telefone está incorreto";
		throw new FormatoTelefoneException(msgError);
	}
	
	private void validarData(Date dataO) {
		String msgError = "Formato da data de ocorrência está incorreto";
		throw new FormatoTelefoneException(msgError);
	}
	
	private void validarDadosObrigatorios(BoletimFurtoVeiculo boletim) {
		String msgError = "Dados obrigatórios estão faltando";
		throw new FormatoTelefoneException(msgError);
	}
	
	private void validarPlaca(Emplacamento emplacamento) {
		String msgError = "Formato da placa está incorreto";
		throw new FormatoTelefoneException(msgError);
	}

}
