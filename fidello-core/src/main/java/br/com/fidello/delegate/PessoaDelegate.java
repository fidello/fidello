package br.com.fidello.delegate;

import java.util.List;

import javax.inject.Inject;

import br.com.fidello.facade.PessoaFacade;
import br.com.fidello.json.PessoaVO;

public class PessoaDelegate {

	@Inject
	private PessoaFacade pessoaFacade;

	public List<PessoaVO> buscarPessoasFisicas() throws Exception {
		return pessoaFacade.buscarPessoasFisicas();
	}

}
