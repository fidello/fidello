package br.com.fidello.json;

public class CampanhaVO {

	
	private String nome;
	
	private String taxa;
	
	private Integer validade;
	
	private Integer tipoValidade;

	private Integer idPessoa;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTaxa() {
		return taxa;
	}

	public void setTaxa(String taxa) {
		this.taxa = taxa;
	}

	public Integer getValidade() {
		return validade;
	}

	public void setValidade(Integer validade) {
		this.validade = validade;
	}

	public Integer getTipoValidade() {
		return tipoValidade;
	}

	public void setTipoValidade(Integer tipoValidade) {
		this.tipoValidade = tipoValidade;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	}
