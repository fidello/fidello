package br.com.fidello.mb;

import java.io.Serializable;
import java.util.Date;

import br.com.fidello.enums.PessoaIdentificacaoTipoEnum;

public class PontoForm implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer usuarioIdentificacaoTipo = PessoaIdentificacaoTipoEnum.EMAIL.getCodigo();
	private String cpf;
	private String cnpj;
	private String email;
	private String nomeCliente;
	private Long pontos = 1L;
	private Double valor = 0.00;
	private String descricao;
	private Date validade;
	private Integer cartao;
	
	public Integer getUsuarioIdentificacaoTipo() {
		return usuarioIdentificacaoTipo;
	}
	public void setUsuarioIdentificacaoTipo(Integer usuarioIdentificacaoTipo) {
		this.usuarioIdentificacaoTipo = usuarioIdentificacaoTipo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPontos() {
		return pontos;
	}
	public void setPontos(Long pontos) {
		this.pontos = pontos;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public Integer getCartao() {
		return cartao;
	}
	public void setCartao(Integer cartao) {
		this.cartao = cartao;
	}
	
	
	
}
