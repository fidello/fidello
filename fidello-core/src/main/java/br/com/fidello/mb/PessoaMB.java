package br.com.fidello.mb;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fidello.enums.DocumentoTipoEnum;
import br.com.fidello.facade.PessoaFacade;
import br.com.fidello.model.Email;
import br.com.fidello.model.Pessoa;
import br.com.fidello.model.Usuario;

@RequestScoped
@Named
public class PessoaMB extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject private PessoaFacade pessoaFacade;
	@Inject private Pessoa pessoa;
	@Inject private Usuario usuario;
	
	@PostConstruct
	protected void init() {  
		
		if(pessoa.getDocumentoTipo() == null){
			pessoa.setDocumentoTipo(DocumentoTipoEnum.CPF.getCodigo());
		}
		pessoa.addEmail(new Email("", false));
		
	}
	
	public void alterarUsuarioDocumentoTipo(){
		
	}
	
	public String cadastroPublico(){

		try {
			
			pessoa = pessoaFacade.cadastrarCliente(pessoa);

			displayInfoMessageToUser("Cadastro efetuado.", pessoa.getNome() + " agora você está cadastrado no sistema, por favor efetue o login.");
			
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao criar usuário.", e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return "";

	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	} 
	
}