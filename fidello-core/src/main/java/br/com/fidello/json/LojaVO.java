package br.com.fidello.json;

public class LojaVO {

	
	
	public LojaVO(String nome, String telefone, Integer idPessoa) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.idPessoa = idPessoa;
	}

	private String nome;
	
	private String telefone;
	
	private EnderecoVO endereco;

	private Integer idPessoa;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public EnderecoVO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoVO endereco) {
		this.endereco = endereco;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	
}
