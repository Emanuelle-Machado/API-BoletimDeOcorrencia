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

		validarDadosObrigatorios(boletim);
		validarPlaca(boletim.getVeiculoFurtado().getEmplacamento());
		validarEmail(boletim.getParte().getEmail());
		validarTelefone(boletim.getParte().getTelefone());
		validarData(boletim.getDataOcorrencia());

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
		String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		if (email == null || !email.matches(regex)) {
			String msgError = "Formato do email está incorreto";
			throw new FormatoEmailException(msgError);
		}
	}

	private void validarTelefone(String telefone) {
		String regex = "^\\(?(\\d{2})\\)?[\\s-]?\\d{4,5}-?\\d{4}$";
		if (telefone == null || !telefone.matches(regex)) {
			String msgError = "Formato do telefone está incorreto";
			throw new FormatoTelefoneException(msgError);
		}
	}

	private void validarData(Date dataO) {
		if (dataO == null) {
			String msgError = "A data de ocorrência está ausente";
			throw new FormatoDataException(msgError);
		}

		Date dataAtual = new Date();
		if (dataO.after(dataAtual)) {
			String msgError = "A data de ocorrência não pode estar no futuro";
			throw new FormatoDataException(msgError);
		}
	}

	private void validarDadosObrigatorios(BoletimFurtoVeiculo boletim) {
		if (boletim.getDataOcorrencia() == null ||
				boletim.getPeriodoOcorrencia() == null ||
				boletim.getParte() == null ||
				boletim.getLocalOcorrencia() == null ||
				boletim.getVeiculoFurtado() == null) {
			String msgError = "Dados obrigatórios estão faltando";
			throw new DadosObrigatoriosException(msgError);
		}
	}

	private void validarPlaca(Emplacamento emplacamento) {
		String regex = "^[A-Z]{3}[0-9][A-Z0-9][0-9]{2}$";
		if (emplacamento == null || emplacamento.getPlaca() == null || !emplacamento.getPlaca().matches(regex)) {
			String msgError = "Formato da placa está incorreto";
			throw new FormatoPlacaException(msgError);
		}
	}

}
