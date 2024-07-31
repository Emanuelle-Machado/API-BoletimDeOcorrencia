package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.representacao;



import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Emplacamento;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dominio.Veiculo;

public class VeiculoRep {
	private String id;
	private String anoFabricacao;
	private String cor;
	private String marca;
	private String tipoVeiculo;
	private String placa;
	private String estado;
	private String cidade;
	
	
	public VeiculoRep() {}
	
	public VeiculoRep(Veiculo veiculo) {
		super();
		this.id = veiculo.getId();
		this.anoFabricacao = veiculo.getAnoFabricacao();
		this.cor = veiculo.getCor();
		this.marca = veiculo.getMarca();
		this.tipoVeiculo = veiculo.getTipoVeiculo();
		
		if(veiculo.getEmplacamento() != null) {
			this.placa = veiculo.getEmplacamento().getPlaca();
			this.estado = veiculo.getEmplacamento().getEstado();
			this.cidade = veiculo.getEmplacamento().getCidade();
		}	
	}
	
	public Veiculo converterParaDominio() {
		
		Veiculo veiculo = new Veiculo();
		veiculo.setId(this.id);
		veiculo.setAnoFabricacao(this.anoFabricacao);
		veiculo.setCor(this.cor);
		veiculo.setMarca(this.marca);
		veiculo.setTipoVeiculo(this.tipoVeiculo);
		
		Emplacamento emplacamento = new Emplacamento();
		emplacamento.setPlaca(this.placa);
		emplacamento.setEstado(this.estado);
		emplacamento.setCidade(this.cidade);
		
		veiculo.setEmplacamento(emplacamento);
		
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
	
	
}
