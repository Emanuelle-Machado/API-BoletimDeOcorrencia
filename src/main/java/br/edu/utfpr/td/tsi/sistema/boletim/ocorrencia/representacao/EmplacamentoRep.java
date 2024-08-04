package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.representacao;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Emplacamento;

public class EmplacamentoRep {
	private String placa;
    private String estado;
    private String cidade;

    public EmplacamentoRep() {}

    public EmplacamentoRep(Emplacamento emplacamento) {
        this.placa = emplacamento.getPlaca();
        this.estado = emplacamento.getEstado();
        this.cidade = emplacamento.getCidade();
    }
    
    public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Emplacamento converterParaDominio() {
        Emplacamento emplacamento = new Emplacamento();
        emplacamento.setPlaca(this.placa);
        emplacamento.setEstado(this.estado);
        emplacamento.setCidade(this.cidade);
        return emplacamento;
    }
}
