package br.com.fidello.mb;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fidello.enums.PessoaIdentificacaoTipoEnum;
import br.com.fidello.enums.DocumentoTipoEnum;
import br.com.fidello.facade.UsuarioFacade;
import br.com.fidello.model.Pessoa;
import br.com.fidello.model.Email;
import br.com.fidello.model.Usuario;

@RequestScoped
@Named
public class UsuarioMB extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject private UsuarioFacade usuarioFacade;
	@Inject private Usuario usuario;
	private String cpf;
	private String cnpj;

	
	@PostConstruct
	protected void init() {  
	
		usuario.setPessoa(new Pessoa(PessoaIdentificacaoTipoEnum.CPF.getCodigo()));
		usuario.getPessoa().addEmail(new Email("", false));

	} 
	
	
	public String cadastroPublico(){

		try {
			
			usuario.getPessoa().setDocumentoTipo(usuario.getPessoa().getIdentificacaoTipo());
			usuario = usuarioFacade.cadastrarUsuario(usuario);

			displayInfoMessageToUser("Cadastro efetuado.", usuario.getPessoa().getNome() + " agora você está cadastrado no sistema, por favor efetue o login.");
			
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao criar usuário.", e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return "";

	}


	public String cadastrarUsuario(){

		try {
			
			usuario.getPessoa().setDocumento(this.getNumeroSRFFromCpfCnpj());
			
			usuario = usuarioFacade.cadastrarUsuario(usuario);
			
			
			displayInfoMessageToUser("Cadastro efetuado.", usuario.getPessoa().getNome() + " agora você está cadastrado no sistema, por favor efetue o login.");
			
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao criar usuário.", e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return "";

	}
	
	private String getNumeroSRFFromCpfCnpj(){
		String numeroSRF = null;
		if(DocumentoTipoEnum.CPF.getCodigo() == usuario.getPessoa().getDocumentoTipo()){
			numeroSRF = this.getCpf();
		}else{
			numeroSRF = this.getCnpj();
		}
		
		return numeroSRF;
	}
	
	public LabelValue[] getDocumentoTiposLabelValue(){
		
		LabelValue labelValue[] = new LabelValue[DocumentoTipoEnum.values().length];
		int i = 0;
		for (DocumentoTipoEnum documentoTipoEnum : DocumentoTipoEnum.values()) {
			labelValue[i] = new LabelValue(documentoTipoEnum.getTexto(), String.valueOf(documentoTipoEnum.getCodigo()));
			i++;
		}
		
		return labelValue;
			
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

}