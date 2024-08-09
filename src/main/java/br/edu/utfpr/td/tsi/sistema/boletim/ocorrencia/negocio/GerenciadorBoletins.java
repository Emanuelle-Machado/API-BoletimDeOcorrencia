package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.negocio;

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
	public void cadastrar(BoletimFurtoVeiculo boletim) {
		String idBoletim = UUID.randomUUID().toString();
		boletim.setId(idBoletim);
		boletimFurtoVeiculoDAO.cadastrar(boletim);
		parteDAO.cadastrar(boletim.getParte(), idBoletim);
		enderecoDAO.cadastrar(boletim.getLocalOcorrencia(), idBoletim);
		//veiculoDAO.cadastrar(boletim.getVeiculoFurtado());
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
		Veiculo veiculo = veiculoDAO.consultar(idBoletim);
		
		boletim.setParte(parte);
		boletim.setLocalOcorrencia(endereco);
		boletim.setVeiculoFurtado(veiculo);
		
		return boletim;
	}

	@Override
	@Transactional
	public void alterar(BoletimFurtoVeiculo boletim) {
		
	}

	@Override
	@Transactional
	public void remover(String idBoletim) {
		
	}

}
