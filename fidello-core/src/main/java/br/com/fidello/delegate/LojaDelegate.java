package br.com.fidello.delegate;

import javax.inject.Inject;

import br.com.fidello.facade.LojaFacade;
import br.com.fidello.model.Loja;

public class LojaDelegate {

	@Inject
	private LojaFacade lojaFacade;

	public void cadastrarLoja(Loja loja) throws Exception {

		loja = lojaFacade.cadastrarLoja(loja);
		
		
	}

}
