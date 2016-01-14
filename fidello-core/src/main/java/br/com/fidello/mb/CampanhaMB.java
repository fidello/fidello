package br.com.fidello.mb;

import java.io.Serializable;


import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fidello.enums.DocumentoTipoEnum;
import br.com.fidello.enums.PessoaIdentificacaoTipoEnum;
import br.com.fidello.util.SelecaoUsuario;
import br.com.fidello.facade.PessoaFacade;
//import br.com.fidello.facade.CampanhaFacade;
import br.com.fidello.model.Pessoa;
import br.com.fidello.model.Email;
import br.com.fidello.dao.EmailDAO;
import br.com.fidello.dao.PessoaDAO;
import br.com.fidello.model.Loja;
import br.com.fidello.model.Campanha;
import br.com.fidello.seguranca.ControleAcesso;
import br.com.fidello.util.Utils;

@Named
@RequestScoped
public class CampanhaMB extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject	private ControleAcesso controleAcesso;

//	@Inject	private CampanhaFacade campanhaFacade;

	@Inject	private Campanha campanha;
	@Inject	private Pessoa pessoa;
	@Inject	private Email email;

	@Inject	private EmailDAO emailDAO;
	@Inject	private PessoaDAO pessoaDAO;
	
	@Inject	private SelecaoUsuario selecaoUsuario;

	private String nomeCliente;

			@PostConstruct
	protected void init() {
		pessoa = new Pessoa(DocumentoTipoEnum.CPF.getCodigo());
		selecaoUsuario.setTipoUsuario(1);
//
//		if (campanha == null) {
//			campanha = new Campanha();
//			// campanhaForm.setDocumentoTipo(DocumentoTipoEnum.Cpf.getCodigo());
//		}
//		if (pessoa == null) {
//			pessoa = new Pessoa();
//			// campanhaForm.setDocumentoTipo(DocumentoTipoEnum.Cpf.getCodigo());
//		}
//		if (loja == null) {
//			loja = new Loja();
//			// campanhaForm.setDocumentoTipo(DocumentoTipoEnum.Cpf.getCodigo());
//		}
//
	}

	public String mostrarNomeCliente() {

		try {

//
//				Pessoa pessoa = null;
//
//				if (this.campanhaForm.getUsuarioIdentificacaoTipo() == UsuarioIdentificacaoTipoEnum.EMAIL
//						.getCodigo()) {
//
//					pessoa = pessoaFacade.detalharPessoaPorEmail(this.campanhaForm
//							.getEmail());
//
//				}
			if (selecaoUsuario.getTipoUsuario() == PessoaIdentificacaoTipoEnum.CPF.getCodigo()) {
				pessoa = pessoaDAO.detalharPessoaPorUsuarioIdentificacao(selecaoUsuario.getTipoUsuario(), selecaoUsuario.getStrCpf());
			}
			if (selecaoUsuario.getTipoUsuario() == PessoaIdentificacaoTipoEnum.CNPJ.getCodigo()) {
				pessoa = pessoaDAO.detalharPessoaPorUsuarioIdentificacao(selecaoUsuario.getTipoUsuario(), selecaoUsuario.getStrCnpj());
			}

			nomeCliente = "Não encontrado";
			if (pessoa != null) {
				nomeCliente = pessoa.getNome();
			}

			

		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao buscar.",
					e.getLocalizedMessage());
			e.printStackTrace();
		}

		return "";

	}

	public String fornecerCampanhas() {

		try {

//			email = emailDAO.detalharEmail(getStrEmail());
			
//			if (selecaoUsuario.getTipoUsuario() == PessoaIdentificacaoTipoEnum.CPF.getCodigo()) {
//				pessoa = pessoaDAO.detalharPessoaPorUsuarioIdentificacao(selecaoUsuario.getTipoUsuario(), selecaoUsuario.getStrCpf());
//			}
//			if (selecaoUsuario.getTipoUsuario() == PessoaIdentificacaoTipoEnum.CNPJ.getCodigo()) {
//				pessoa = pessoaDAO.detalharPessoaPorUsuarioIdentificacao(selecaoUsuario.getTipoUsuario(), selecaoUsuario.getStrCnpj());
//			}
//			
//			if (selecaoUsuario.getTipoUsuario() == PessoaIdentificacaoTipoEnum.EMAIL.getCodigo()) {
//				pessoa = pessoaDAO.detalharPessoaPorEmail(selecaoUsuario.getStrEmail());
//			}
			
			
//			campanha.setLojaId(controleAcesso.getLojaAtual().getId());
//			campanha.setPessoaId(pessoa.getId());
//
//			campanha.setCodigoTipoConversao(1);
//			campanha.setCartao(1);
//
//						
//			campanha = campanhaFacade.cadastrarCampanhas(campanha);
//			
			displayInfoMessageToUser("Campanha gerado efetuado com sucesso!");

			
//			int lojaId = 1;
//			if (this.campanha.getPessoaId() != 0)
//
////				Integer lojaId = controleAcesso.getLojaAtual().getId();
//				
//				if (this.campanha.getUsuarioIdentificacaoTipo() == UsuarioIdentificacaoTipoEnum.EMAIL
//						.getCodigo()) {
//
//					campanha = campanhaFacade.cadastrarCampanhasPorEmail(lojaId,
//							this.campanhaForm.getEmail(), this.campanhaForm
//									.getCampanhas(), this.campanhaForm.getValor(),
//							Utils.utilDateToSqlDate(this.campanhaForm
//									.getValidade()), this.campanhaForm
//									.getDescricao(), Utils.getDataHoraAtual(),
//							this.campanhaForm.getCartao());
//
//				}
//				if (this.campanhaForm.getUsuarioIdentificacaoTipo() == UsuarioIdentificacaoTipoEnum.Cpf
//						.getCodigo()) {
//
//					campanha = campanhaFacade.cadastrarCampanhasPorDocumento(lojaId,
//							DocumentoTipoEnum.Cpf, this.campanhaForm.getCpf(),
//							this.campanhaForm.getCampanhas(), this.campanhaForm
//									.getValor(), Utils
//									.utilDateToSqlDate(this.campanhaForm
//											.getValidade()), this.campanhaForm
//									.getDescricao(), Utils.getDataHoraAtual(),
//							this.campanhaForm.getCartao());
//
//				}
//				if (this.campanhaForm.getUsuarioIdentificacaoTipo() == UsuarioIdentificacaoTipoEnum.Cnpj
//						.getCodigo()) {
//
//					campanha = campanhaFacade.cadastrarCampanhasPorDocumento(lojaId,
//							DocumentoTipoEnum.Cnpj, this.campanhaForm.getCnpj(),
//							this.campanhaForm.getCampanhas(), this.campanhaForm
//									.getValor(), Utils
//									.utilDateToSqlDate(this.campanhaForm
//											.getValidade()), this.campanhaForm
//									.getDescricao(), Utils.getDataHoraAtual(),
//							this.campanhaForm.getCartao());
//
//				}
//
//				displayInfoMessageToUser("Campanhas cadastrados.",
//						"Campanhas cadastrados com sucesso.");
//
//			} else {
//				displayErrorMessageToUser("Falha no login",
//						"Preencha a identificação.");
//				return null;
//			}
//
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao criar campanha.",
					e.getLocalizedMessage());
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

	public Campanha getCampanha() {
		return campanha;
	}

	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public SelecaoUsuario getSelecaoUsuario() {
		return selecaoUsuario;
	}

	public void setSelecaoUsuario(SelecaoUsuario selecaoUsuario) {
		this.selecaoUsuario = selecaoUsuario;
	}

}

