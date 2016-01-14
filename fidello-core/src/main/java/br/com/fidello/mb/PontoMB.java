package br.com.fidello.mb;

import java.io.Serializable;




import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fidello.enums.DocumentoTipoEnum;
import br.com.fidello.enums.PessoaIdentificacaoTipoEnum;
import br.com.fidello.seguranca.ControleAcesso;
import br.com.fidello.util.SelecaoUsuario;
import br.com.fidello.facade.PontoFacade;
import br.com.fidello.facade.UsuarioFacade;
import br.com.fidello.model.Pessoa;
import br.com.fidello.dao.PessoaDAO;
import br.com.fidello.model.Ponto;
import br.com.fidello.model.LojaCampanha;
import br.com.fidello.model.Campanha;

@Named
@RequestScoped
public class PontoMB extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject	private Ponto ponto;
	@Inject	private Pessoa pessoa;
	@Inject	private LojaCampanha lojaCampanha;

	@Inject private ControleAcesso controleAcesso;

	@Inject private PontoFacade pontoFacade;
	
	Integer Pontos;
	Double Valor;
	
	@Inject	private PessoaDAO pessoaDAO;
	
	@Inject	private SelecaoUsuario selecaoUsuario;

	private String nomeCliente;

	@PostConstruct
	protected void init() {
		selecaoUsuario.setTipoUsuario(1);

		if (ponto == null) {
			ponto = new Ponto();
		}

		pessoa = new Pessoa(DocumentoTipoEnum.CPF.getCodigo());

		if (lojaCampanha == null) {
			lojaCampanha = new LojaCampanha();
		}

	}

	public String mostrarNomeCliente() {

		try {

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

	public String fornecerPontos() {

		try {

			if (pessoa.getIdentificacaoTipo() == PessoaIdentificacaoTipoEnum.CPF.getCodigo()) {
				pessoa = pessoaDAO.detalharPessoaPorUsuarioIdentificacao(pessoa.getIdentificacaoTipo(), pessoa.getNumeroSRF());
			}
			if (pessoa.getDocumentoTipo() == PessoaIdentificacaoTipoEnum.CNPJ.getCodigo()) {
				pessoa = pessoaDAO.detalharPessoaPorUsuarioIdentificacao(pessoa.getIdentificacaoTipo(), pessoa.getNumeroSRF());
			}
			
			ponto.setPessoa(pessoa);
			ponto.setLoja(controleAcesso.getLoja());

			ponto = pontoFacade.cadastrarPontos(ponto, lojaCampanha.getCampanha());
			
			displayInfoMessageToUser("Pontos gerados com sucesso!");
			
		} catch (Exception e) {
			displayErrorMessageToUser("Falha ao fornecer os pontos.",
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

	public Ponto getPonto() {
		return ponto;
	}

	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
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

	public LojaCampanha getLojaCampanha() {
		return lojaCampanha;
	}

	public void setLojaCampanha(LojaCampanha lojaCampanha) {
		this.lojaCampanha = lojaCampanha;
	}


}


