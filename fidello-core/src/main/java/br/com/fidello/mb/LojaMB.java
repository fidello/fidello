package br.com.fidello.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fidello.enums.DocumentoTipoEnum;
import br.com.fidello.enums.PessoaIdentificacaoTipoEnum;
import br.com.fidello.enums.TelefoneTipoEnum;
import br.com.fidello.facade.LojaFacade;
import br.com.fidello.facade.PessoaFacade;
import br.com.fidello.facade.UsuarioLojaFacade;
import br.com.fidello.model.Email;
import br.com.fidello.model.Endereco;
import br.com.fidello.model.Loja;
import br.com.fidello.model.Pessoa;
import br.com.fidello.model.Telefone;
import br.com.fidello.seguranca.ControleAcesso;

@Named
@RequestScoped
public class LojaMB extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject private ControleAcesso controleAcesso;
	
	@Inject private LojaFacade lojaFacade;
	@Inject private PessoaFacade pessoaFacade;
	@Inject private UsuarioLojaFacade pessoaLojaFacade;
	
	@Inject private Loja loja;
	@Inject private Endereco endereco; // TODO Está temporário assim, depois fazer um componente de endereço que reçeba endereço e faça o form
	private String cpfLoja;
	private String cnpjLoja;
	
	@PostConstruct
	protected void init() {  
		
		loja.setPessoa(new Pessoa(PessoaIdentificacaoTipoEnum.CPF.getCodigo()));
		loja.getPessoa().addEmail(new Email("", false));
		loja.getPessoa().addTelefone(new Telefone("", "", "", TelefoneTipoEnum.COMERCIAL.getCodigo(), false));
		loja.getPessoa().addTelefone(new Telefone("", "", "", TelefoneTipoEnum.CELULAR.getCodigo(), false));
		loja.getPessoa().addEndereco(new Endereco());
		
	} 
	
	private String getNumeroSRFFromCpfCnpj(){
		String numeroSRF = null;
		if(loja.getPessoa().getDocumentoTipo().equals(DocumentoTipoEnum.CPF.getCodigo())){
			numeroSRF = this.getCpfLoja();
		}else{
			numeroSRF = this.getCnpjLoja();
		}
		
		return numeroSRF;
	}
	
	/*public String mostrarNomePessoa(){

		try {
			
			loja.getPessoa().setDocumento(getNumeroSRFFromCpfCnpj());
			
			Pessoa pessoa =  pessoaFacade.detalharPessoaPorDocumento(loja.getNumeroSRFTipoPessoa() , documentoPessoa);
			
			if(pessoa == null){
				loja.getPessoa().setNome("Não encontrado");
			}else{
				loja.setPessoa(pessoa);
			}
			
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao buscar.", e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return "";

	}*/
	
	public String mostrarNomeLoja(){

		try {
			
//			loja.getPessoa().setDocumento(getNumeroSRFFromCpfCnpj());
//			
//			Pessoa pessoa =  pessoaFacade.detalharPessoaPorDocumento(DocumentoTipoEnum.getFromCodigo(loja.getPessoa().getNumeroSRFTipo()) , loja.getPessoa().getNumeroSRF());
//			
//			if(pessoa == null){
//				loja.getPessoa().setNome("Não encontrado");
//			}else{
//				loja.setPessoa(pessoa);
//			}
			
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao buscar.", e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return "";

	}
	
	/*
	public String vincularLojaPessoa(){
		
		try {
			
			String documento = null;
			if(lojaForm.getLojaVincularSelecionada().getNumeroSRFTipo().equals(DocumentoTipoEnum.CPF.getCodigo())){
				documento = lojaForm.getLojaVincularSelecionada().getCpf();
			}else{
				documento = lojaForm.getLojaVincularSelecionada().getCnpj();
			}
			
			Pessoa pessoa = pessoaFacade.detalharPessoaPorDocumento(DocumentoTipoEnum.getNumeroSRFTipoFromCodigo(lojaForm.getLojaVincularSelecionada().getNumeroSRFTipo()), documento);
			if(pessoa == null){
				displayErrorMessageToUser("Falha", "Usuário não encontrado.");
				return "";
			}
			
//			PessoaLoja pessoaLoja = pessoaLojaFacade.vincularLojaPessoa(lojaForm.getLojaVincularSelecionada().getLoja().getId(), pessoa.getId());
			
			displayInfoMessageToUser("Sucesso.", "Agora é representante.");
			
		} catch (Exception e) {
			
			displayErrorMessageToUser("Falha ao buscar lojas.", e.getLocalizedMessage());
			e.printStackTrace();
			
		}
		
		return "";
	}
	*/
	
	public String cadastrarLoja(){
		
		try {
			
			loja.getPessoa().setDocumentoTipo(loja.getPessoa().getIdentificacaoTipo());
		
			loja = lojaFacade.cadastrarLoja(loja);
			
			displayInfoMessageToUser("Cadastro efetuado com sucesso!", loja.getNomeFantasia());
			
		} catch (Exception e) {
			
			displayErrorMessageToUser("Falha ao buscar lojas.", e.getLocalizedMessage());
			e.printStackTrace();
			
		}
		
		return "";
	}
	/*
	public Collection<LojaVincular> getListaLojaVincular(){

		try {
			
			if(this.lojaForm.getListaLojaVincular() == null){
				
				Collection<Loja> lojas = lojaFacade.listarTodasLojas();

				Collection<LojaVincular> listaLojaVincularForm = new ArrayList<LojaVincular>();
				for (Loja loja : lojas) {
					
					LojaVincular lojaVincularForm = new LojaVincular();
					lojaVincularForm.setLoja(loja);
					
					listaLojaVincularForm.add(lojaVincularForm);
					
				}
				
				this.getLojaForm().setListaLojaVincular(listaLojaVincularForm);
				
			}
			
			
			return this.getLojaForm().getListaLojaVincular();
			
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao buscar lojas.", e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return new ArrayList<LojaVincular>();
		
	}
	*/

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public String getCpfLoja() {
		return cpfLoja;
	}

	public void setCpfLoja(String cpfLoja) {
		this.cpfLoja = cpfLoja;
	}

	public String getCnpjLoja() {
		return cnpjLoja;
	}

	public void setCnpjLoja(String cnpjLoja) {
		this.cnpjLoja = cnpjLoja;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}