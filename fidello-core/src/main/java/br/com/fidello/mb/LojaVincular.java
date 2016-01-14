package br.com.fidello.mb;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.fidello.enums.DocumentoTipoEnum;
import br.com.fidello.facade.PessoaFacade;
import br.com.fidello.model.Loja;
import br.com.fidello.model.Pessoa;

public class LojaVincular implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject private PessoaFacade pessoaFacade;

	private Integer documentoTipo = DocumentoTipoEnum.CPF.getCodigo();
	private String cpf;
	private String cnpj;
	private String email;
	private String nome;
	
	private Loja loja;
	
	public String mostrarNome(){

		try {
			
			String documento = null;
			if(this.getDocumentoTipo().equals(DocumentoTipoEnum.CPF.getCodigo())){
				documento = this.getCpf();
			}else{
				documento = this.getCnpj();
			}
			
//			Pessoa pessoa =  pessoaFacade.detalharPessoaPorDocumento(DocumentoTipoEnum.getDocumentoTipoFromCodigo(this.getDocumentoTipo()) , documento);
			Pessoa pessoa =  null;
			
			String nome = "Não encontrado";
			if(pessoa != null){
				nome = pessoa.getNome();
			}
			
			this.setNome(nome);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";

	}
	
	
	public Integer getDocumentoTipo() {
		return documentoTipo;
	}
	public void setDocumentoTipo(Integer documentoTipo) {
		this.documentoTipo = documentoTipo;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Loja getLoja() {
		return loja;
	}
	public void setLoja(Loja loja) {
		this.loja = loja;
	}

}
