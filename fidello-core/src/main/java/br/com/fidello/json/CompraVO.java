package br.com.fidello.json;

public class CompraVO {

	private String descricao;

	private Double valor;

	private Integer idLoja;

	private Integer idPessoa;

	private PontoVO pontos;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(Integer idLoja) {
		this.idLoja = idLoja;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public PontoVO getPontos() {
		return pontos;
	}

	public void setPontos(PontoVO pontos) {
		this.pontos = pontos;
	}

}
