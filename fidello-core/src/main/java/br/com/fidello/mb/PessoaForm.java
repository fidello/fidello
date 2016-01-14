package br.com.fidello.mb;

import java.io.Serializable;

import br.com.fidello.enums.DocumentoTipoEnum;

public class PessoaForm implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer documentoTipo = DocumentoTipoEnum.CPF.getCodigo();
	private String cpf;
	private String cnpj;
	private String nome;
	
	public boolean isDocumentoTipoCpf(){
		System.out.println("isDocumentoTipoCpf() "+documentoTipo);
		return (documentoTipo == DocumentoTipoEnum.CPF.getCodigo());
	}
	public boolean isDocumentoTipoCnpj(){
		System.out.println("isDocumentoTipoCnpj() "+documentoTipo);
		return (documentoTipo == DocumentoTipoEnum.CNPJ.getCodigo());
	}
	public void setDocumentoTipoCpf(){
		System.out.println("setDocumentoTipoCpf "+documentoTipo);
		documentoTipo = DocumentoTipoEnum.CPF.getCodigo();
//		return "";
	}
	public void setDocumentoTipoCnpj(){
		System.out.println("setDocumentoTipoCnpj "+documentoTipo);
		documentoTipo = DocumentoTipoEnum.CNPJ.getCodigo();
//		return "";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getDocumentoTipo() {
		System.out.println("getDocumentoTipo()");
		return documentoTipo;
	}
	public void setDocumentoTipo(Integer documentoTipo) {
		System.out.println("setDocumentoTipo()");
		this.documentoTipo = documentoTipo;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
