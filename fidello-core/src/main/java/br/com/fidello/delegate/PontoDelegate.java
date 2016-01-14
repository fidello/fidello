package br.com.fidello.delegate;

import javax.inject.Inject;

import br.com.fidello.dao.PessoaDAO;
import br.com.fidello.enums.PessoaIdentificacaoTipoEnum;
import br.com.fidello.facade.PontoFacade;
import br.com.fidello.model.Campanha;
import br.com.fidello.model.Loja;
import br.com.fidello.model.Pessoa;
import br.com.fidello.model.Ponto;

public class PontoDelegate {

	@Inject
	private PontoFacade pontoFacade;
	
	@Inject PessoaDAO pessoaDAO;

	public String fornecerPontos(Pessoa pessoa, Ponto ponto, Loja loja, Campanha campanha) throws Exception {


		if (pessoa.getIdentificacaoTipo() == PessoaIdentificacaoTipoEnum.CPF
				.getCodigo()) {
			pessoa = pessoaDAO.detalharPessoaPorUsuarioIdentificacao(
					pessoa.getIdentificacaoTipo(), pessoa.getNumeroSRF());
		}
		if (pessoa.getDocumentoTipo() == PessoaIdentificacaoTipoEnum.CNPJ
				.getCodigo()) {
			pessoa = pessoaDAO.detalharPessoaPorUsuarioIdentificacao(
					pessoa.getIdentificacaoTipo(), pessoa.getNumeroSRF());
		}

		ponto.setPessoa(pessoa);
		
		ponto.setLoja(loja);

		ponto = pontoFacade.cadastrarPontos(ponto, campanha);

		return "";

	}

}
