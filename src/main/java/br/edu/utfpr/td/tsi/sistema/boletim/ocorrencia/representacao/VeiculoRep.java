package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.representacao;


import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Veiculo;
import jakarta.persistence.Id;

public class VeiculoRep {
	
	@Id
	private String id;
	
	private String anoFabricacao;
	private String cor;
	private String marca;
	private String tipoVeiculo;
	
	private EmplacamentoRep emplacamento;
	
	public VeiculoRep() {}
	
	public VeiculoRep(Veiculo veiculo) {
		super();
		this.id = veiculo.getId();
		this.anoFabricacao = veiculo.getAnoFabricacao();
		this.cor = veiculo.getCor();
		this.marca = veiculo.getMarca();
		this.tipoVeiculo = veiculo.getTipoVeiculo();
		
		if (veiculo.getEmplacamento() != null) {
            this.emplacamento = new EmplacamentoRep(veiculo.getEmplacamento());
        }
	}
	
	public Veiculo converterParaDominio() {
		
		Veiculo veiculo = new Veiculo();
		veiculo.setId(this.id);
		veiculo.setAnoFabricacao(this.anoFabricacao);
		veiculo.setCor(this.cor);
		veiculo.setMarca(this.marca);
		veiculo.setTipoVeiculo(this.tipoVeiculo);
		
		 if (this.emplacamento != null) {
	            veiculo.setEmplacamento(this.emplacamento.converterParaDominio());
	        }
		
		return veiculo;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTipoVeiculo() {
		return tipoVeiculo;
	}
	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	public EmplacamentoRep getEmplacamento() {
        return emplacamento;
    }

    public void setEmplacamento(EmplacamentoRep emplacamento) {
        this.emplacamento = emplacamento;
    }
	
	
}
